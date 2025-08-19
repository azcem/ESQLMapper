package Mapper;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ESQLMapper extends ESQLBaseListener{
    private boolean skipEndIfFlag = false;

    private final String source;
    private final String sourceMapped;
    private final String target;
    private final String targetMapped;
    /** references map correlation name to absolute path */
    private final Map<String, List<String>> references = new HashMap<>() {
        {
            put("OutputRoot", new ArrayList<>(List.of("OutputRoot")));
            put("InputRoot", new ArrayList<>(List.of("InputRoot")));
            put("Environment", new ArrayList<>(List.of("Environment")));
        }
    };
    /** Map of fieldReference parseTree and List of field names. */
    private final ParseTreeProperty<List<String>> fieldReferenceList = new ParseTreeProperty<>();
    /** Map of expression parseTree and List of tokens. */
    private final ParseTreeProperty<List<String>> expressionList = new ParseTreeProperty<>();
    /** Map of routine Call parseTree and List of tokens. */
    private final ParseTreeProperty<List<String>> routineCallList= new ParseTreeProperty<>();
    /** Map of numeric function call parseTree and List of tokens. */
    private final ParseTreeProperty<List<String>> numericFunctionCallList = new ParseTreeProperty<>();
    /** Map of string manipulation function call parseTree and List of tokens. */
    private final ParseTreeProperty<List<String>> stringManipulationFunctionCallList = new ParseTreeProperty<>();
    /** Map of field function call parseTree and List of tokens. */
    private final ParseTreeProperty<List<String>> fieldFunctionCallList = new ParseTreeProperty<>();
    /** Map of complex function call parseTree and List of tokens. */
    private final ParseTreeProperty<List<String>> complexFunctionCallList = new ParseTreeProperty<>();
    /** Map of miscellaneous function call parseTree and List of tokens. */
    private final ParseTreeProperty<List<String>> miscellaneousFunctionCallList = new ParseTreeProperty<>();
    /** Map of case function call parseTree and List of tokens. */
    private final ParseTreeProperty<List<String>> caseFunctionList = new ParseTreeProperty<>();
    /** Map of select function call parseTree and List of tokens. */
    private final ParseTreeProperty<List<String>> selectFunctionList = new ParseTreeProperty<>();
    /** Map of cast function call parseTree and List of tokens. */
    private final ParseTreeProperty<List<String>> castFunctionList = new ParseTreeProperty<>();
    /** Map of row function call parseTree and List of tokens. */
    private final ParseTreeProperty<List<String>> rowFunctionList = new ParseTreeProperty<>();
    /** Map of condition parseTree and List of tokens. */
    private final ParseTreeProperty<List<String>> conditionList = new ParseTreeProperty<>();

    public ESQLMapper(String source, String sourceMapped, String target, String targetMapped) {
        this.source = source;
        this.sourceMapped = sourceMapped;
        this.target = target;
        this.targetMapped = targetMapped;
    }
    /** Overrides */

    /**
     * Handles Declare Reference statement where it keeps a mapping of reference name and absolute path.
     * @param ctx the parse tree
     */
    @Override
    public void exitDeclareReferenceStatement(ESQLParser.DeclareReferenceStatementContext ctx) {
        for (var identifier : ctx.varList().fieldReferenceIdentifier()) {
            references.put(identifier.getText(), fieldReferenceList.get(ctx.fieldReference()));
        }
    }

    @Override
    /**
     * Handles Field Reference part of the statement and adds it to the fieldReferenceList parse tree map.
     * @param ctx the parse tree
     */
    public void exitFieldReference(ESQLParser.FieldReferenceContext ctx) {
        var path = new ArrayList<String>();
        // add absolute path of correlation name
        if (references.containsKey(ctx.correlationName().getText())) {
            path.addAll(references.get(ctx.correlationName().getText()));
        } else {
            path.add(ctx.correlationName().getText());
        }
        //add fields
        for (var element : ctx.pathElement()) {
            // add type
            if (element.type() != null) {
                var type = element.type();
                path.add("(");
                path.add(type.getText());
                path.add(")");
            }
            // add element name
            if (element.elementName() != null) {
                var elementName = element.elementName();
                path.add("/");
                if (elementName.fieldReferenceIdentifier() != null) {
                    path.add(elementName.fieldReferenceIdentifier().getText());
                } else if (elementName.expression() != null) {
                    path.add("{"
                            + String.join(" ", expressionList.get(elementName.expression()))
                            + "}");
//                    path.add("{");
//                    path.add(String.join(" ", expressionList.get(elementName.expression())));
//                    path.add("}");
                } else {
                    path.add("*");
                }
            }
            // add array subscript
            if (element.arraySubscript() != null) {
                for (var child : element.arraySubscript().children) {
                    if (child instanceof ESQLParser.ExpressionContext) {
                        path.add(String.join(" ", expressionList.get(child)));
                    } else {
                        path.add(child.getText());
                    }
                }
            }
        }
        String pathStr = String.join("", path);
        pathStr = mapToBody(pathStr, source, sourceMapped);
        pathStr = mapToBody(pathStr, target, targetMapped);
        fieldReferenceList.put(ctx, List.of(pathStr));
    }

    @Override
    /** Handles Expression part of the statement and add the tokens to the parseTree map expressionList.
     * @param ctx the parse tree
     */
    public void exitExpression(ESQLParser.ExpressionContext ctx) {
        var tokens = new ArrayList<String>();
        if (ctx.fieldReference() != null) {
            tokens.addAll(fieldReferenceList.get(ctx.fieldReference()));
        } else if (ctx.routineCall() != null) {
            tokens.addAll(routineCallList.get(ctx.routineCall()));
        } else if (ctx.expression() != null) {
            for (var child : ctx.children) {
                if (child instanceof ESQLParser.ExpressionContext) {
                    tokens.addAll(expressionList.get(child));
                } else {
                    tokens.add(child.getText());
                }
            }
        } else {
            tokens.addAll(ctx.children.stream().map(child -> child.getText()).toList());
        }
        expressionList.put(ctx, tokens);
    }

    /**
     * Handles Routine Call expression and adds its tokens to routineCall List map.
     * @param ctx the parse tree
     */
    @Override
    public void exitRoutineCall(ESQLParser.RoutineCallContext ctx) {
        var tokens = new ArrayList<String>();
        if (ctx.expressionList() != null) {
            tokens.add(ctx.routineName().getText() +
                    "(" + String.join(", ",ctx.expressionList().expression().stream()
                    .map(expression -> expressionList.get(expression))
                    .map(expressionTokens -> String.join(" ", expressionTokens))
                    .toList()) + ")");
//            tokens.add("(");
//            for (var expression : ctx.expressionList().expression()) {
//                tokens.addAll(expressionList.get(expression));
//                tokens.add(",");
//            }
//            tokens.remove(tokens.size()-1);
//            tokens.add(")");
        } else if (ctx.databaseFunctionCall() != null) {
            tokens.add(ctx.getText());
        } else if (ctx.dateTimeFunctionCall() != null) {
            for (var child : ctx.dateTimeFunctionCall().children) {
                if (child instanceof ESQLParser.FieldReferenceContext) {
                    tokens.addAll(fieldReferenceList.get(child));
                } else {
                    tokens.add(child.getText());
                }
            }
        } else if (ctx.numericFunctionCall() != null) {
            tokens.addAll(numericFunctionCallList.get(ctx.numericFunctionCall()));
        } else if (ctx.stringManipulationFunctionCall() != null) {
            tokens.addAll(stringManipulationFunctionCallList.get(ctx.stringManipulationFunctionCall()));
        } else if (ctx.fieldFunctionCall() != null) {
            tokens.addAll(fieldFunctionCallList.get(ctx.fieldFunctionCall()));
        } else if (ctx.complexFunctionCall() != null) {
            tokens.addAll(complexFunctionCallList.get(ctx.complexFunctionCall()));
        } else if (ctx.miscellaneousFunctionCall() != null) {
            tokens.addAll(miscellaneousFunctionCallList.get(ctx.miscellaneousFunctionCall()));
        }
        routineCallList.put(ctx, tokens);
    }

    /**
     * Handles numeric function calls.
     * @param ctx the parse tree
     */
    @Override
    public void exitNumericFunctionCall(ESQLParser.NumericFunctionCallContext ctx) {
        var tokens = new ArrayList<String>();
        for (var child : ctx.children) {
            if (child instanceof ESQLParser.ExpressionContext) {
                tokens.addAll(expressionList.get(child));
            } else {
                tokens.add(child.getText());
            }
        }
        numericFunctionCallList.put(ctx, tokens);
    }

    /**
     * Handles string manipulation function calls.
     * @param ctx the parse tree
     */
    @Override
    public void exitStringManipulationFunctionCall(ESQLParser.StringManipulationFunctionCallContext ctx) {
        var tokens = new ArrayList<String>();
        for (var child : ctx.children) {
            if (child instanceof ESQLParser.ExpressionContext) {
                tokens.addAll(expressionList.get(child));
            } else {
                tokens.add(child.getText());
            }
        }
        stringManipulationFunctionCallList.put(ctx, tokens);
    }

    /**
     * Handles field function call.
      * @param ctx the parse tree
     */
    @Override
    public void exitFieldFunctionCall(ESQLParser.FieldFunctionCallContext ctx) {
        var tokens = new ArrayList<String>();
        if (ctx.fieldReference() != null) {
            for (var child : ctx.children) {
                if (child instanceof ESQLParser.FieldReferenceContext) {
                    tokens.addAll(fieldReferenceList.get(child));
                } else if (child instanceof ESQLParser.ExpressionContext) {
                    tokens.addAll(expressionList.get(child));
                } else {
                    tokens.add(child.getText());
                }
            }
        } else {
            for (var child : ctx.children) {
                if (child instanceof ESQLParser.ExpressionListContext) {
                    var expressions = ((ESQLParser.ExpressionListContext) child).expression();
                    tokens.addAll(expressionList.get(expressions.get(0)));
                    tokens.add(",");
                    for (int i = 1; i < expressions.size(); i++) {
                        tokens.addAll(expressionList.get(expressions.get(i)));
                    }
                } else {
                    tokens.add(child.getText());
                }
            }
        }
        fieldFunctionCallList.put(ctx, tokens);
    }

    /**
     * Handles complex function call.
     * @param ctx the parse tree
     */
    @Override
    public void exitComplexFunctionCall(ESQLParser.ComplexFunctionCallContext ctx) {
        var tokens = new ArrayList<String>();
        if (ctx.caseFunction() != null) {
            tokens.addAll(caseFunctionList.get(ctx.caseFunction()));
        } else if (ctx.castFunction() != null) {
            tokens.addAll(castFunctionList.get(ctx.castFunction()));
        } else if (ctx.selectFunction() != null) {
            tokens.addAll(selectFunctionList.get(ctx.selectFunction()));
        } else if (ctx.rowFunction() != null) {
            tokens.addAll(rowFunctionList.get(ctx.rowFunction()));
        }
        complexFunctionCallList.put(ctx, tokens);
    }

    /**
     * Handles case function.
     * @param ctx the parse tree
     */
    @Override
    public void exitCaseFunction(ESQLParser.CaseFunctionContext ctx) {
        var tokens = new ArrayList<String>();
        for (var child : ctx.children) {
            if (child instanceof ESQLParser.SimpleWhenClauseContext) {
                for (var grandChild : ((ESQLParser.SimpleWhenClauseContext) child).children) {
                    if (grandChild instanceof ESQLParser.ExpressionContext) {
                        tokens.addAll(expressionList.get(grandChild));
                    } else {
                        tokens.add(grandChild.getText());
                    }
                }
            } else if (child instanceof ESQLParser.SearchedWhenClauseContext) {
                for (var grandChild : ((ESQLParser.SearchedWhenClauseContext) child).children) {
                    if (grandChild instanceof ESQLParser.ConditionContext) {
                        tokens.addAll(conditionList.get(grandChild));
                    } else if (grandChild instanceof ESQLParser.ExpressionContext) {
                        tokens.addAll(expressionList.get(grandChild));
                    } else {
                        tokens.add(grandChild.getText());
                    }
                }
            } else if (child instanceof ESQLParser.ExpressionContext) {
                tokens.addAll(expressionList.get(child));
            } else {
                tokens.add(child.getText());
            }
        }
        caseFunctionList.put(ctx, tokens);
    }

    /**
     * Handles Cast function.
     * @param ctx the parse tree
     */
    @Override
    public void exitCastFunction(ESQLParser.CastFunctionContext ctx) {
        var tokens = new ArrayList<String>();
        for (var child : ctx.children) {
            if (child instanceof ESQLParser.ExpressionContext) {
                tokens.addAll(expressionList.get(child));
            } else if (child instanceof ESQLParser.DataTypeContext) {
                tokens.addAll(((ESQLParser.DataTypeContext) child).children.stream()
                        .map(grandChild -> grandChild.getText())
                        .toList());
            } else {
                tokens.add(child.getText());
            }
        }
        castFunctionList.put(ctx, tokens);
    }

    /**
     * Handles select function.
     * @param ctx the parse tree
     */
    @Override
    public void exitSelectFunction(ESQLParser.SelectFunctionContext ctx) {
        var tokens = new ArrayList<String>();
        tokens.add("SELECT");
        var selectClauses = ctx.selectClause();
        for (var selectClauseCtx : selectClauses) {
            for (var child : selectClauseCtx.children) {
                if (child instanceof ESQLParser.ExpressionContext) {
                    tokens.addAll(expressionList.get(child));
                } else if (child instanceof ESQLParser.FieldReferenceContext) {
                    tokens.addAll(fieldReferenceList.get(child));
                } else {
                    tokens.add(child.getText());
                }
            }
            tokens.add(",");
        }
        tokens.remove(tokens.size()-1);
        var fromClauseCtx = ctx.fromClause();
        for (var child : fromClauseCtx.children) {
            if (child instanceof ESQLParser.FieldReferenceContext) {
                tokens.addAll(fieldReferenceList.get(child));
            } else {
                tokens.add(child.getText());
            }
        }
        if (ctx.whereClause() != null) {
            tokens.add("WHERE");
            tokens.addAll(conditionList.get(ctx.whereClause().condition()));
        }
        selectFunctionList.put(ctx, tokens);
    }

    /**
     * Handles row function.
     * @param ctx the parse tree
     */
    @Override
    public void exitRowFunction(ESQLParser.RowFunctionContext ctx) {
        var tokens = new ArrayList<String>();
        for (var child : ctx.children) {
            if (child instanceof ESQLParser.ConditionContext) {
                tokens.addAll(expressionList.get(child));
            } else if (child instanceof ESQLParser.FieldReferenceContext) {
                tokens.addAll(fieldReferenceList.get(child));
            } else {
                tokens.add(child.getText());
            }
        }
        rowFunctionList.put(ctx, tokens);
    }

    @Override
    public void exitMiscellaneousFunctionCall(ESQLParser.MiscellaneousFunctionCallContext ctx) {
        var tokens = new ArrayList<String>();
        var passthruCtx = ctx.passthruFunction();
        for (var child : passthruCtx.children) {
            if (child instanceof ESQLParser.ExpressionContext) {
                tokens.addAll(expressionList.get(child));
            } else if (child instanceof ESQLParser.ExpressionListContext) {
                var expressions = ((ESQLParser.ExpressionListContext) child).expression();
                for (var expression : expressions) {
                    tokens.addAll(expressionList.get(expression));
                    tokens.add(",");
                }
                tokens.remove(tokens.size()-1); //remove last ,
            } else {
                tokens.add(child.getText());
            }
        }
        miscellaneousFunctionCallList.put(ctx, tokens);
    }

    /**
     * Handles conditions and adds its tokens to list.
     * @param ctx the parse tree
     */
    @Override
    public void exitCondition(ESQLParser.ConditionContext ctx) {
        var tokens = new ArrayList<String>();
        for (var child : ctx.children) {
            if (child instanceof ESQLParser.ConditionContext) {
                tokens.addAll(conditionList.get(child));
            } else if (child instanceof ESQLParser.ExpressionContext) {
                tokens.addAll(expressionList.get(child));
            } else if (child instanceof ESQLParser.ExpressionListContext) {
                var expressions = ((ESQLParser.ExpressionListContext) child).expression();
                for (var expression : expressions) {
                    tokens.addAll(expressionList.get(expression));
                    tokens.add(",");
                }
                tokens.remove(tokens.size()-1);
            } else {
                tokens.add(child.getText());
            }
        }
        //add tokens to condition list
        conditionList.put(ctx, tokens);
        //print while, if, else if statements
        if (ctx.parent instanceof ESQLParser.IfClauseContext) {
            printIf(ctx);
        } else if (ctx.parent instanceof ESQLParser.ElseifClauseContext) {
            printElseIf(ctx);
        } else if (ctx.parent instanceof ESQLParser.WhileStatementContext) {
            printWhile(ctx);
        }
    }

    /** Printers */
    /**
     * prints the field reference and source expression of the set statement to stdout.
     * @param ctx the parse tree
     */
    @Override
    public void exitSetStatement(ESQLParser.SetStatementContext ctx) {
        System.out.print(formatField(fieldReferenceList.get(ctx.fieldReference())));
        System.out.print(";");
        if (ctx.sourceExpression().condition() != null) {
            System.out.println(formatField(conditionList.get(ctx.sourceExpression().condition())));
        } else {
            System.out.println(formatField(expressionList.get(ctx.sourceExpression().expression())));
        }
    }

    /**
     * Prints declare statement to stdout.
     * @param ctx the parse tree
     */
    @Override
    public void exitDeclareStatement(ESQLParser.DeclareStatementContext ctx) {
        var tokens = new ArrayList<String>();
        for (var child : ctx.children) {
            if (child instanceof ESQLParser.ConditionContext) {
                tokens.addAll(conditionList.get(child));
            } else if (child instanceof ESQLParser.VarListContext) {
                for (var grandChild : ((ESQLParser.VarListContext) child).children) {
                    tokens.add(grandChild.getText());
                }
            } else {
                tokens.add(child.getText());
            }
        }
        System.out.println(formatField(tokens));
    }

    /**
     * Prints if statement to stdout.
     * @param ctx
     */
    private void printIf(ESQLParser.ConditionContext ctx) {
        if (ctx.getText().contains("LASTMOVE")) {
            skipEndIfFlag = true;
            return;
        }
        System.out.println("IF " + String.join(" ", formatField(conditionList.get(ctx)) + " THEN"));
    }

    /**
     * Prints else if statement to stdout.
     * @param ctx
     */
    private void printElseIf(ESQLParser.ConditionContext ctx) {
        System.out.println("ELSE IF " + String.join(" ", formatField(conditionList.get(ctx)) + " THEN"));
    }

    /**
     * Prints else to stdout.
     * @param ctx the parse tree
     */
    @Override
    public void enterElseClause(ESQLParser.ElseClauseContext ctx) {
        System.out.println("ELSE");
    }

    /**
     * Prints end if to stdout.
     * @param ctx the parse tree
     */
    @Override
    public void exitIfStatement(ESQLParser.IfStatementContext ctx) {
        if (skipEndIfFlag) {
            skipEndIfFlag = false;
            return;
        }
        System.out.println("END IF");
    }

    /**
     * Prints while statement to stdout.
     * @param ctx
     */
    private void printWhile(ESQLParser.ConditionContext ctx) {
        String ctxText = ctx.getText();
        if (ctxText.contains("LASTMOVE")) {
            System.out.println("Loop on "
            + references.get(ctx.expression(0).routineCall().expressionList().expression(0).getText()).get(0));
        } else {
            System.out.println("WHILE " + formatField(conditionList.get(ctx)));
        }
    }

    /**
     * Prints end loop to stdout.
     * @param ctx the parse tree
     */
    @Override
    public void exitWhileStatement(ESQLParser.WhileStatementContext ctx) {
        System.out.println("End Loop");
    }

    /** Helpers */
    /**
     * Transforms list of tokens to formatted string.
     * @param tokens the list of tokens
     * @return formatted string
     */
    private String formatField(List<String> tokens) {
        return String.join(" ", tokens);
    }

    /**
     * Replaces root with root Mapped (typically /Body).
     * @param path full path
     * @param root root to be replaced
     * @param rootMapped path to be replaced with
     * @return field reference after mapping root to /Body
     */
    private String mapToBody(String path, String root, String rootMapped) {
        return path.replace(root, rootMapped);
    }

}