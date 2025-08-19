package Mapper;

// Generated from ESQL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ESQLParser}.
 */
public interface ESQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ESQLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ESQLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ESQLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(ESQLParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(ESQLParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#moduleName}.
	 * @param ctx the parse tree
	 */
	void enterModuleName(ESQLParser.ModuleNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#moduleName}.
	 * @param ctx the parse tree
	 */
	void exitModuleName(ESQLParser.ModuleNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#routineDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRoutineDeclaration(ESQLParser.RoutineDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#routineDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRoutineDeclaration(ESQLParser.RoutineDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#routineType}.
	 * @param ctx the parse tree
	 */
	void enterRoutineType(ESQLParser.RoutineTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#routineType}.
	 * @param ctx the parse tree
	 */
	void exitRoutineType(ESQLParser.RoutineTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#routineName}.
	 * @param ctx the parse tree
	 */
	void enterRoutineName(ESQLParser.RoutineNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#routineName}.
	 * @param ctx the parse tree
	 */
	void exitRoutineName(ESQLParser.RoutineNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(ESQLParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(ESQLParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(ESQLParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(ESQLParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#parameterName}.
	 * @param ctx the parse tree
	 */
	void enterParameterName(ESQLParser.ParameterNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#parameterName}.
	 * @param ctx the parse tree
	 */
	void exitParameterName(ESQLParser.ParameterNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(ESQLParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(ESQLParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#language}.
	 * @param ctx the parse tree
	 */
	void enterLanguage(ESQLParser.LanguageContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#language}.
	 * @param ctx the parse tree
	 */
	void exitLanguage(ESQLParser.LanguageContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#resultSet}.
	 * @param ctx the parse tree
	 */
	void enterResultSet(ESQLParser.ResultSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#resultSet}.
	 * @param ctx the parse tree
	 */
	void exitResultSet(ESQLParser.ResultSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#routineBody}.
	 * @param ctx the parse tree
	 */
	void enterRoutineBody(ESQLParser.RoutineBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#routineBody}.
	 * @param ctx the parse tree
	 */
	void exitRoutineBody(ESQLParser.RoutineBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ESQLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ESQLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#basicStatement}.
	 * @param ctx the parse tree
	 */
	void enterBasicStatement(ESQLParser.BasicStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#basicStatement}.
	 * @param ctx the parse tree
	 */
	void exitBasicStatement(ESQLParser.BasicStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#messageTreeManipulationStatement}.
	 * @param ctx the parse tree
	 */
	void enterMessageTreeManipulationStatement(ESQLParser.MessageTreeManipulationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#messageTreeManipulationStatement}.
	 * @param ctx the parse tree
	 */
	void exitMessageTreeManipulationStatement(ESQLParser.MessageTreeManipulationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#databaseUpdateStatement}.
	 * @param ctx the parse tree
	 */
	void enterDatabaseUpdateStatement(ESQLParser.DatabaseUpdateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#databaseUpdateStatement}.
	 * @param ctx the parse tree
	 */
	void exitDatabaseUpdateStatement(ESQLParser.DatabaseUpdateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#nodeInteractionStatement}.
	 * @param ctx the parse tree
	 */
	void enterNodeInteractionStatement(ESQLParser.NodeInteractionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#nodeInteractionStatement}.
	 * @param ctx the parse tree
	 */
	void exitNodeInteractionStatement(ESQLParser.NodeInteractionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#otherStatement}.
	 * @param ctx the parse tree
	 */
	void enterOtherStatement(ESQLParser.OtherStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#otherStatement}.
	 * @param ctx the parse tree
	 */
	void exitOtherStatement(ESQLParser.OtherStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#caseStatement}.
	 * @param ctx the parse tree
	 */
	void enterCaseStatement(ESQLParser.CaseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#caseStatement}.
	 * @param ctx the parse tree
	 */
	void exitCaseStatement(ESQLParser.CaseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#beginEndStatement}.
	 * @param ctx the parse tree
	 */
	void enterBeginEndStatement(ESQLParser.BeginEndStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#beginEndStatement}.
	 * @param ctx the parse tree
	 */
	void exitBeginEndStatement(ESQLParser.BeginEndStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#iterateStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterateStatement(ESQLParser.IterateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#iterateStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterateStatement(ESQLParser.IterateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#leaveStatement}.
	 * @param ctx the parse tree
	 */
	void enterLeaveStatement(ESQLParser.LeaveStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#leaveStatement}.
	 * @param ctx the parse tree
	 */
	void exitLeaveStatement(ESQLParser.LeaveStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(ESQLParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(ESQLParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStatement(ESQLParser.RepeatStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStatement(ESQLParser.RepeatStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(ESQLParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(ESQLParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#attachStatement}.
	 * @param ctx the parse tree
	 */
	void enterAttachStatement(ESQLParser.AttachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#attachStatement}.
	 * @param ctx the parse tree
	 */
	void exitAttachStatement(ESQLParser.AttachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeleteStatement(ESQLParser.DeleteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeleteStatement(ESQLParser.DeleteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#detachStatement}.
	 * @param ctx the parse tree
	 */
	void enterDetachStatement(ESQLParser.DetachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#detachStatement}.
	 * @param ctx the parse tree
	 */
	void exitDetachStatement(ESQLParser.DetachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(ESQLParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(ESQLParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#deleteFromStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeleteFromStatement(ESQLParser.DeleteFromStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#deleteFromStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeleteFromStatement(ESQLParser.DeleteFromStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#tableReference}.
	 * @param ctx the parse tree
	 */
	void enterTableReference(ESQLParser.TableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#tableReference}.
	 * @param ctx the parse tree
	 */
	void exitTableReference(ESQLParser.TableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#tableClause}.
	 * @param ctx the parse tree
	 */
	void enterTableClause(ESQLParser.TableClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#tableClause}.
	 * @param ctx the parse tree
	 */
	void exitTableClause(ESQLParser.TableClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(ESQLParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(ESQLParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void enterInsertStatement(ESQLParser.InsertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void exitInsertStatement(ESQLParser.InsertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#passthruStatement}.
	 * @param ctx the parse tree
	 */
	void enterPassthruStatement(ESQLParser.PassthruStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#passthruStatement}.
	 * @param ctx the parse tree
	 */
	void exitPassthruStatement(ESQLParser.PassthruStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStatement(ESQLParser.UpdateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStatement(ESQLParser.UpdateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#rollbackStatement}.
	 * @param ctx the parse tree
	 */
	void enterRollbackStatement(ESQLParser.RollbackStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#rollbackStatement}.
	 * @param ctx the parse tree
	 */
	void exitRollbackStatement(ESQLParser.RollbackStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#commitStatement}.
	 * @param ctx the parse tree
	 */
	void enterCommitStatement(ESQLParser.CommitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#commitStatement}.
	 * @param ctx the parse tree
	 */
	void exitCommitStatement(ESQLParser.CommitStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#propagateStatement}.
	 * @param ctx the parse tree
	 */
	void enterPropagateStatement(ESQLParser.PropagateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#propagateStatement}.
	 * @param ctx the parse tree
	 */
	void exitPropagateStatement(ESQLParser.PropagateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#messageSources}.
	 * @param ctx the parse tree
	 */
	void enterMessageSources(ESQLParser.MessageSourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#messageSources}.
	 * @param ctx the parse tree
	 */
	void exitMessageSources(ESQLParser.MessageSourcesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#controls}.
	 * @param ctx the parse tree
	 */
	void enterControls(ESQLParser.ControlsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#controls}.
	 * @param ctx the parse tree
	 */
	void exitControls(ESQLParser.ControlsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#brokerSchemaStatement}.
	 * @param ctx the parse tree
	 */
	void enterBrokerSchemaStatement(ESQLParser.BrokerSchemaStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#brokerSchemaStatement}.
	 * @param ctx the parse tree
	 */
	void exitBrokerSchemaStatement(ESQLParser.BrokerSchemaStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#schemaPathList}.
	 * @param ctx the parse tree
	 */
	void enterSchemaPathList(ESQLParser.SchemaPathListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#schemaPathList}.
	 * @param ctx the parse tree
	 */
	void exitSchemaPathList(ESQLParser.SchemaPathListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#declareHandlerStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclareHandlerStatement(ESQLParser.DeclareHandlerStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#declareHandlerStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclareHandlerStatement(ESQLParser.DeclareHandlerStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(ESQLParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(ESQLParser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#logStatement}.
	 * @param ctx the parse tree
	 */
	void enterLogStatement(ESQLParser.LogStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#logStatement}.
	 * @param ctx the parse tree
	 */
	void exitLogStatement(ESQLParser.LogStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#options}.
	 * @param ctx the parse tree
	 */
	void enterOptions(ESQLParser.OptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#options}.
	 * @param ctx the parse tree
	 */
	void exitOptions(ESQLParser.OptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#resignalStatement}.
	 * @param ctx the parse tree
	 */
	void enterResignalStatement(ESQLParser.ResignalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#resignalStatement}.
	 * @param ctx the parse tree
	 */
	void exitResignalStatement(ESQLParser.ResignalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void enterSetStatement(ESQLParser.SetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#setStatement}.
	 * @param ctx the parse tree
	 */
	void exitSetStatement(ESQLParser.SetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#fieldReference}.
	 * @param ctx the parse tree
	 */
	void enterFieldReference(ESQLParser.FieldReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#fieldReference}.
	 * @param ctx the parse tree
	 */
	void exitFieldReference(ESQLParser.FieldReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#pathElement}.
	 * @param ctx the parse tree
	 */
	void enterPathElement(ESQLParser.PathElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#pathElement}.
	 * @param ctx the parse tree
	 */
	void exitPathElement(ESQLParser.PathElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ESQLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ESQLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#arraySubscript}.
	 * @param ctx the parse tree
	 */
	void enterArraySubscript(ESQLParser.ArraySubscriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#arraySubscript}.
	 * @param ctx the parse tree
	 */
	void exitArraySubscript(ESQLParser.ArraySubscriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#namespacePrefix}.
	 * @param ctx the parse tree
	 */
	void enterNamespacePrefix(ESQLParser.NamespacePrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#namespacePrefix}.
	 * @param ctx the parse tree
	 */
	void exitNamespacePrefix(ESQLParser.NamespacePrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#elementName}.
	 * @param ctx the parse tree
	 */
	void enterElementName(ESQLParser.ElementNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#elementName}.
	 * @param ctx the parse tree
	 */
	void exitElementName(ESQLParser.ElementNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#sourceExpression}.
	 * @param ctx the parse tree
	 */
	void enterSourceExpression(ESQLParser.SourceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#sourceExpression}.
	 * @param ctx the parse tree
	 */
	void exitSourceExpression(ESQLParser.SourceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(ESQLParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(ESQLParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#ifClause}.
	 * @param ctx the parse tree
	 */
	void enterIfClause(ESQLParser.IfClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#ifClause}.
	 * @param ctx the parse tree
	 */
	void exitIfClause(ESQLParser.IfClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#elseifClause}.
	 * @param ctx the parse tree
	 */
	void enterElseifClause(ESQLParser.ElseifClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#elseifClause}.
	 * @param ctx the parse tree
	 */
	void exitElseifClause(ESQLParser.ElseifClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void enterElseClause(ESQLParser.ElseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void exitElseClause(ESQLParser.ElseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(ESQLParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(ESQLParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(ESQLParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(ESQLParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(ESQLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(ESQLParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ESQLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ESQLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#routineCall}.
	 * @param ctx the parse tree
	 */
	void enterRoutineCall(ESQLParser.RoutineCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#routineCall}.
	 * @param ctx the parse tree
	 */
	void exitRoutineCall(ESQLParser.RoutineCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#databaseFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterDatabaseFunctionCall(ESQLParser.DatabaseFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#databaseFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitDatabaseFunctionCall(ESQLParser.DatabaseFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#dateTimeFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeFunctionCall(ESQLParser.DateTimeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#dateTimeFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeFunctionCall(ESQLParser.DateTimeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#currentTimeFunctions}.
	 * @param ctx the parse tree
	 */
	void enterCurrentTimeFunctions(ESQLParser.CurrentTimeFunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#currentTimeFunctions}.
	 * @param ctx the parse tree
	 */
	void exitCurrentTimeFunctions(ESQLParser.CurrentTimeFunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#numericFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterNumericFunctionCall(ESQLParser.NumericFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#numericFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitNumericFunctionCall(ESQLParser.NumericFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#stringManipulationFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterStringManipulationFunctionCall(ESQLParser.StringManipulationFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#stringManipulationFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitStringManipulationFunctionCall(ESQLParser.StringManipulationFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#fieldFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterFieldFunctionCall(ESQLParser.FieldFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#fieldFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitFieldFunctionCall(ESQLParser.FieldFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#complexFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterComplexFunctionCall(ESQLParser.ComplexFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#complexFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitComplexFunctionCall(ESQLParser.ComplexFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#caseFunction}.
	 * @param ctx the parse tree
	 */
	void enterCaseFunction(ESQLParser.CaseFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#caseFunction}.
	 * @param ctx the parse tree
	 */
	void exitCaseFunction(ESQLParser.CaseFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#simpleWhenClause}.
	 * @param ctx the parse tree
	 */
	void enterSimpleWhenClause(ESQLParser.SimpleWhenClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#simpleWhenClause}.
	 * @param ctx the parse tree
	 */
	void exitSimpleWhenClause(ESQLParser.SimpleWhenClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#searchedWhenClause}.
	 * @param ctx the parse tree
	 */
	void enterSearchedWhenClause(ESQLParser.SearchedWhenClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#searchedWhenClause}.
	 * @param ctx the parse tree
	 */
	void exitSearchedWhenClause(ESQLParser.SearchedWhenClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#castFunction}.
	 * @param ctx the parse tree
	 */
	void enterCastFunction(ESQLParser.CastFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#castFunction}.
	 * @param ctx the parse tree
	 */
	void exitCastFunction(ESQLParser.CastFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#selectFunction}.
	 * @param ctx the parse tree
	 */
	void enterSelectFunction(ESQLParser.SelectFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#selectFunction}.
	 * @param ctx the parse tree
	 */
	void exitSelectFunction(ESQLParser.SelectFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#selectClause}.
	 * @param ctx the parse tree
	 */
	void enterSelectClause(ESQLParser.SelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#selectClause}.
	 * @param ctx the parse tree
	 */
	void exitSelectClause(ESQLParser.SelectClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(ESQLParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(ESQLParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#rowFunction}.
	 * @param ctx the parse tree
	 */
	void enterRowFunction(ESQLParser.RowFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#rowFunction}.
	 * @param ctx the parse tree
	 */
	void exitRowFunction(ESQLParser.RowFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#miscellaneousFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterMiscellaneousFunctionCall(ESQLParser.MiscellaneousFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#miscellaneousFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitMiscellaneousFunctionCall(ESQLParser.MiscellaneousFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#passthruFunction}.
	 * @param ctx the parse tree
	 */
	void enterPassthruFunction(ESQLParser.PassthruFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#passthruFunction}.
	 * @param ctx the parse tree
	 */
	void exitPassthruFunction(ESQLParser.PassthruFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(ESQLParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(ESQLParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#callStatement}.
	 * @param ctx the parse tree
	 */
	void enterCallStatement(ESQLParser.CallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#callStatement}.
	 * @param ctx the parse tree
	 */
	void exitCallStatement(ESQLParser.CallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(ESQLParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(ESQLParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#brokerSchemaName}.
	 * @param ctx the parse tree
	 */
	void enterBrokerSchemaName(ESQLParser.BrokerSchemaNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#brokerSchemaName}.
	 * @param ctx the parse tree
	 */
	void exitBrokerSchemaName(ESQLParser.BrokerSchemaNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#qualifiers}.
	 * @param ctx the parse tree
	 */
	void enterQualifiers(ESQLParser.QualifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#qualifiers}.
	 * @param ctx the parse tree
	 */
	void exitQualifiers(ESQLParser.QualifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#databaseSchemaReference}.
	 * @param ctx the parse tree
	 */
	void enterDatabaseSchemaReference(ESQLParser.DatabaseSchemaReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#databaseSchemaReference}.
	 * @param ctx the parse tree
	 */
	void exitDatabaseSchemaReference(ESQLParser.DatabaseSchemaReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#databaseSchemaName}.
	 * @param ctx the parse tree
	 */
	void enterDatabaseSchemaName(ESQLParser.DatabaseSchemaNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#databaseSchemaName}.
	 * @param ctx the parse tree
	 */
	void exitDatabaseSchemaName(ESQLParser.DatabaseSchemaNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#databaseSourceClause}.
	 * @param ctx the parse tree
	 */
	void enterDatabaseSourceClause(ESQLParser.DatabaseSourceClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#databaseSourceClause}.
	 * @param ctx the parse tree
	 */
	void exitDatabaseSourceClause(ESQLParser.DatabaseSourceClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#databaseSourceName}.
	 * @param ctx the parse tree
	 */
	void enterDatabaseSourceName(ESQLParser.DatabaseSourceNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#databaseSourceName}.
	 * @param ctx the parse tree
	 */
	void exitDatabaseSourceName(ESQLParser.DatabaseSourceNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#databaseSourceExpr}.
	 * @param ctx the parse tree
	 */
	void enterDatabaseSourceExpr(ESQLParser.DatabaseSourceExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#databaseSourceExpr}.
	 * @param ctx the parse tree
	 */
	void exitDatabaseSourceExpr(ESQLParser.DatabaseSourceExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#schemaClause}.
	 * @param ctx the parse tree
	 */
	void enterSchemaClause(ESQLParser.SchemaClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#schemaClause}.
	 * @param ctx the parse tree
	 */
	void exitSchemaClause(ESQLParser.SchemaClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#schemaName}.
	 * @param ctx the parse tree
	 */
	void enterSchemaName(ESQLParser.SchemaNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#schemaName}.
	 * @param ctx the parse tree
	 */
	void exitSchemaName(ESQLParser.SchemaNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#schemaExpr}.
	 * @param ctx the parse tree
	 */
	void enterSchemaExpr(ESQLParser.SchemaExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#schemaExpr}.
	 * @param ctx the parse tree
	 */
	void exitSchemaExpr(ESQLParser.SchemaExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#declareStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStatement(ESQLParser.DeclareStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#declareStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStatement(ESQLParser.DeclareStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(ESQLParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(ESQLParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#declareReferenceStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclareReferenceStatement(ESQLParser.DeclareReferenceStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#declareReferenceStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclareReferenceStatement(ESQLParser.DeclareReferenceStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#createStatement}.
	 * @param ctx the parse tree
	 */
	void enterCreateStatement(ESQLParser.CreateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#createStatement}.
	 * @param ctx the parse tree
	 */
	void exitCreateStatement(ESQLParser.CreateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#qualifier}.
	 * @param ctx the parse tree
	 */
	void enterQualifier(ESQLParser.QualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#qualifier}.
	 * @param ctx the parse tree
	 */
	void exitQualifier(ESQLParser.QualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#asClause}.
	 * @param ctx the parse tree
	 */
	void enterAsClause(ESQLParser.AsClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#asClause}.
	 * @param ctx the parse tree
	 */
	void exitAsClause(ESQLParser.AsClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#aliasFieldReferenceVariable}.
	 * @param ctx the parse tree
	 */
	void enterAliasFieldReferenceVariable(ESQLParser.AliasFieldReferenceVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#aliasFieldReferenceVariable}.
	 * @param ctx the parse tree
	 */
	void exitAliasFieldReferenceVariable(ESQLParser.AliasFieldReferenceVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#domainClause}.
	 * @param ctx the parse tree
	 */
	void enterDomainClause(ESQLParser.DomainClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#domainClause}.
	 * @param ctx the parse tree
	 */
	void exitDomainClause(ESQLParser.DomainClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#repeatClause}.
	 * @param ctx the parse tree
	 */
	void enterRepeatClause(ESQLParser.RepeatClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#repeatClause}.
	 * @param ctx the parse tree
	 */
	void exitRepeatClause(ESQLParser.RepeatClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#valuesClauses}.
	 * @param ctx the parse tree
	 */
	void enterValuesClauses(ESQLParser.ValuesClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#valuesClauses}.
	 * @param ctx the parse tree
	 */
	void exitValuesClauses(ESQLParser.ValuesClausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#namesClauses}.
	 * @param ctx the parse tree
	 */
	void enterNamesClauses(ESQLParser.NamesClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#namesClauses}.
	 * @param ctx the parse tree
	 */
	void exitNamesClauses(ESQLParser.NamesClausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(ESQLParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(ESQLParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#parseClause}.
	 * @param ctx the parse tree
	 */
	void enterParseClause(ESQLParser.ParseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#parseClause}.
	 * @param ctx the parse tree
	 */
	void exitParseClause(ESQLParser.ParseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#parseOption}.
	 * @param ctx the parse tree
	 */
	void enterParseOption(ESQLParser.ParseOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#parseOption}.
	 * @param ctx the parse tree
	 */
	void exitParseOption(ESQLParser.ParseOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#bitStreamExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitStreamExpression(ESQLParser.BitStreamExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#bitStreamExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitStreamExpression(ESQLParser.BitStreamExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#repeatClauses}.
	 * @param ctx the parse tree
	 */
	void enterRepeatClauses(ESQLParser.RepeatClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#repeatClauses}.
	 * @param ctx the parse tree
	 */
	void exitRepeatClauses(ESQLParser.RepeatClausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#moveStatement}.
	 * @param ctx the parse tree
	 */
	void enterMoveStatement(ESQLParser.MoveStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#moveStatement}.
	 * @param ctx the parse tree
	 */
	void exitMoveStatement(ESQLParser.MoveStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(ESQLParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(ESQLParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#correlationName}.
	 * @param ctx the parse tree
	 */
	void enterCorrelationName(ESQLParser.CorrelationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#correlationName}.
	 * @param ctx the parse tree
	 */
	void exitCorrelationName(ESQLParser.CorrelationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#fieldReferenceIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldReferenceIdentifier(ESQLParser.FieldReferenceIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#fieldReferenceIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldReferenceIdentifier(ESQLParser.FieldReferenceIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(ESQLParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(ESQLParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#dateTimeType}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeType(ESQLParser.DateTimeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#dateTimeType}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeType(ESQLParser.DateTimeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#intervalQualifier}.
	 * @param ctx the parse tree
	 */
	void enterIntervalQualifier(ESQLParser.IntervalQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#intervalQualifier}.
	 * @param ctx the parse tree
	 */
	void exitIntervalQualifier(ESQLParser.IntervalQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType(ESQLParser.NumericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType(ESQLParser.NumericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ESQLParser#stringType}.
	 * @param ctx the parse tree
	 */
	void enterStringType(ESQLParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ESQLParser#stringType}.
	 * @param ctx the parse tree
	 */
	void exitStringType(ESQLParser.StringTypeContext ctx);
}