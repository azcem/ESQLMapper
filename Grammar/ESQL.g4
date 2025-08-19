grammar ESQL;

options { caseInsensitive=true; }

program: brokerSchemaStatement? (module | statement)+ ; //to parse ESQl file at any level; module, procedure or statement

module
    : 'CREATE' ('COMPUTE' | 'DATABASE' | 'FILTER' | 'DATABASEEVENT') 'MODULE' moduleName (routineDeclaration ';')* 'END' 'MODULE' ';' ;

moduleName: fieldReferenceIdentifier ;

routineDeclaration
    : 'CREATE' routineType routineName '(' parameterList? ')' returnType? language? resultSet? routineBody ;

routineType: 'FUNCTION' | 'PROCEDURE' ;

routineName: fieldReferenceIdentifier;

parameterList: parameter (',' parameter)* ;

parameter: ('IN' | 'OUT' | 'INOUT') parameterName ('CONSTANT'? dataType | 'NAMESPACE' | 'NAME') ('NULLABLE' | 'NOT' 'NULL')? ;

parameterName: fieldReferenceIdentifier ;

returnType: 'RETURNS' dataType ('NULLABLE' | 'NOT' 'NULL')? ;

language: 'LANGUAGE' ('ESQL' | 'DATABASE' | 'CLR' | 'JAVA') ;

resultSet: 'DYNAMIC RESULT SETS' INT;

routineBody
    :'BEGIN' statement* 'END'
    | 'EXTERNAL' 'NAME' DOUBLEQUOTESTRING ('CLASSLOADER' DOUBLEQUOTESTRING)? ;

statement
    : (basicStatement
    | messageTreeManipulationStatement
    | databaseUpdateStatement
    | nodeInteractionStatement
    | otherStatement
    ) ';'
    ;

basicStatement
    : callStatement
    | beginEndStatement
    | caseStatement
    | routineDeclaration
    | declareStatement
    | declareReferenceStatement
    | ifStatement
    | iterateStatement
    | leaveStatement
    | loopStatement
    | repeatStatement
    | returnStatement
    | setStatement
    | throwStatement
    | whileStatement
    ;

messageTreeManipulationStatement
    : attachStatement
    | createStatement
    | deleteStatement
    | detachStatement
    | forStatement
    | moveStatement
    ;

databaseUpdateStatement
    : deleteFromStatement
    | insertStatement
    | passthruStatement
    | updateStatement
    | commitStatement
    | rollbackStatement
    ;

nodeInteractionStatement
    : propagateStatement;

otherStatement
    : declareHandlerStatement
    | logStatement
    | resignalStatement
    ;

caseStatement
    : 'CASE' expression? ('WHEN' condition 'THEN' statement*)+ ('ELSE' statement*)? 'END' 'CASE';

beginEndStatement
    : (fieldReferenceIdentifier ':')? 'BEGIN' 'NOT'? 'ATOMIC'? statement* 'END' fieldReference? ;

iterateStatement
    : 'ITERATE' label;

leaveStatement
    : 'LEAVE' label;

loopStatement
    : (label ':')? 'LOOP' statement* 'END' 'LOOP' label? ;

repeatStatement
    : (label ':')? 'REPEAT' statement* 'UNTIL' condition 'END' 'REPEAT' label? ;

throwStatement
    : 'THROW' 'USER'? 'EXCEPTION' ('SEVERITY' expression)? ('CATALOG' expression)? ('MESSAGE' expression)? ('VALUES' '(' expressionList ')')? ;

attachStatement
    : 'ATTACH' correlationName 'TO' fieldReference 'AS' ('FIRSTCHILD' | 'LASTCHILD' | 'PREVIOUSSIBLING' | 'NEXTSIBLING') ;

deleteStatement
    : 'DELETE' ('FIELD' | ('FIRSTCHILD' | 'LASTCHILD' | 'PREVIOUSSIBLING' | 'NEXTSIBLING') 'OF') fieldReference ;

detachStatement
    : 'DETACH' correlationName ;

forStatement
    : 'FOR' correlationName 'AS' fieldReference 'DO' statement* 'END' 'FOR' ;

deleteFromStatement
    : 'DELETE' 'FROM' tableReference ('AS' correlationName)? ('WHERE' condition)? ;

tableReference
    : 'Database.' (databaseSourceClause '.')? (schemaClause '.')? (tableClause) ;

tableClause
    : tableName | '{' expression '}' ;

tableName: IDENTIFIER ;

insertStatement
    : 'INSERT' 'INTO' tableReference ('(' fieldReferenceIdentifier (',' fieldReferenceIdentifier)* ')')? 'VALUES' '(' expressionList ')' ;

passthruStatement
    : 'PASSTHRU' ('(' expressionList ')') | expression ('TO' databaseSchemaReference)? ('VALUES' '(' expressionList ')')? ;

updateStatement
    : 'UPDATE' tableReference ('AS' correlationName)? 'SET' (fieldReferenceIdentifier '=' expression (',' fieldReferenceIdentifier '=' expression)*) 'WHERE' condition ;

rollbackStatement
    : 'ROLLBACK' databaseSchemaReference;

commitStatement
    : 'COMMIT' databaseSchemaReference;

propagateStatement
    : 'PROPAGATE' ('TO' ('TERMINAL' | 'LABEL') expression)? messageSources? controls? ;

messageSources
    : ('ENVIRONMENT' expression)? ('MESSAGE' expression)? ('EXCEPTION' expression)? ;

controls
    : ('FINALIZE' ('DEFAULT' | 'NONE'))? ('DELETE' ('DEFAULT' | 'NONE'))? ;

brokerSchemaStatement
    : ('BROKER' 'SCHEMA' brokerSchemaName)? ('PATH' schemaPathList)? ;

schemaPathList: brokerSchemaName (',' brokerSchemaName)* ;

declareHandlerStatement
    : 'DECLARE' ('CONTINUE' | 'EXIT') 'HANDLER' 'FOR' state statement+ ;

state
    : 'SQLSTATE' ('VALUE' | 'LIKE') STRING ('ESCAPE' STRING)? (',' state)* ;

logStatement
    : 'LOG' ('EVENT' | 'USER' 'TRACE') 'FULL'? 'EXCEPTION'? options? 'VALUES' '(' expressionList ')' ;

options: ('SEVERITY' expression)? ('CATALOG' expression)? ('MESSAGE' expression)? ;

resignalStatement: 'RESIGNAL' ;

setStatement: 'SET' fieldReference ('TYPE' | 'NAMESPACE' | 'NAME' | 'VALUE')? '=' sourceExpression ;

fieldReference
    : correlationName ('.' pathElement)* ;

pathElement
    : ( '(' type ')' )? namespacePrefix? elementName? arraySubscript? ;

type
    : ('XML' | 'XMLNS' | 'XMLNSC' | fieldReferenceIdentifier) '.' fieldReferenceIdentifier ;

arraySubscript
    : '[' '<'?'>'? expression? ']' ;

namespacePrefix
    : elementName? ':' ;


elementName
    : fieldReferenceIdentifier |  '{' expression '}' |  '*' ;

sourceExpression
    : expression | condition ;


ifStatement
    : ifClause (elseifClause)* (elseClause)? 'END' 'IF' ;

ifClause
    : 'IF' condition 'THEN'  statement*;

elseifClause
    : 'ELSEIF' condition 'THEN' statement*;

elseClause
    : 'ELSE' statement*
    ;

whileStatement
    : (label ':')? 'WHILE' condition 'DO' statement* 'END' 'WHILE' label? ;

label: IDENTIFIER ;

//expression that returns true or false
condition
    : '(' condition ')'
    | 'NOT' condition
    | condition 'AND' condition
    | condition 'OR' condition
    | expression ('='|'<>'|'<'|'>'|'>='|'<=') expression
    | expression 'NOT'? 'BETWEEN' ('ASYMMETRIC' | 'SYMMETRIC')? expression 'AND' expression
    | expression 'NOT'? 'IN' '(' expressionList ')'
    | expression 'IS' 'NOT'?   ('TRUE'
                             | 'FALSE'
                             | ('+' | '-')? 'INF'
                             | ('+' | '-')? 'INFINITY'
                             | 'NAN'
                             | 'NULL'
                             | 'NUM'
                             | 'NUMBER'
                             | 'UNKNOWN')
    | expression 'NOT'? 'LIKE' expression ('ESCAPE' expression)?
    | expression
    ;

expression
    : '(' expression ')'
    | expression ('*' | '/') expression
    | expression ('+' | '-') expression
    | '(' expression '-' expression ')' intervalQualifier
    | expression NEGATIVEINT
    | expression CONCAT expression
    | routineCall
    | IDENTIFIER
    | fieldReference
    | STRING
    | NEGATIVEINT
    | INT
    | NUMBER
    | 'TRUE'
    | 'FALSE'
    | 'INTERVAL' STRING intervalQualifier
    ;

routineCall
    : routineName '(' expressionList? ')'
    | databaseFunctionCall
    | dateTimeFunctionCall
    | numericFunctionCall
    | stringManipulationFunctionCall
    | fieldFunctionCall
    | complexFunctionCall
    | miscellaneousFunctionCall
    ;

databaseFunctionCall
    : 'SQLCODE'
    | 'SQLERRORTEXT'
    | 'SQLNATIVEERROR'
    | 'SQLSTATE'
    ;

dateTimeFunctionCall
    : 'EXTRACT' '(' ('YEAR' | 'MONTH' | 'DAY' | 'HOUR' | 'MINUTE' 
                  | 'SECOND' | 'DAYS' | 'DAYOFYEAR' | 'DAYOFWEEK'
                  | 'MONTHS' | 'QUARTEROFYEAR' | 'QUARTERS' | 'WEEKS'
                  | 'WEEKOFYEAR' | 'WEEKOFMONTH' | 'ISLEAPYEAR')
                  'FROM' (currentTimeFunctions | STRING | fieldReference) ')'
    | currentTimeFunctions;

currentTimeFunctions
    : 'CURRENT_DATE'
    | 'CURRENT_TIME'
    | 'CURRENT_TIMESTAMP'
    | 'CURRENT_GMTDATE'
    | 'CURRENT_GMTTIME'
    | 'CURRENT_GMTTIMESTAMP'
    | 'LOCALTIMEZONE'
    ;

numericFunctionCall
    : 'ROUND' '(' expression ',' expression ('MODE' ('ROUND_UP' | 'ROUND_DOWN' | 'ROUND_CEILING' 
                                                    | 'ROUND_FLOOR' | 'ROUND_HALF_UP' | 'ROUND_HALF_EVEN' 
                                                    | 'ROUND_HALF_DOWN'))?
              ')'
    ;

stringManipulationFunctionCall
    : 'OVERLAY' '(' expression 'PLACING' expression 'FROM' expression ('FOR' expression)? ')'
    | 'POSITION' '(' expression 'IN' expression ('FROM' expression)? ('REPEAT' expression)? ')'
    | 'SUBSTRING' '(' expression ('FROM' | 'BEFORE' | 'AFTER') expression ('FOR' expression)? ')'
    | 'TRIM' '(' (('BOTH' | 'LEADING' | 'TRAILING')? expression 'FROM')? expression ')'
    | 'URLENCODE' '(' expression ('MODE' ('RFC3986' | 'RFC1798')?)? ')'
    ;

fieldFunctionCall
    : 'ASBITSTREAM' '(' fieldReference parseOption* ')'
    | 'ASBITSTREAM' '(' expressionList ')' 
    | 'FOR' ('ALL' | 'ANY' | 'SOME')? fieldReference ('AS' IDENTIFIER)? (',' fieldReference ('AS' IDENTIFIER)?)* '(' expression ')'
    ;

complexFunctionCall
    : caseFunction
    | castFunction
    | selectFunction
    | rowFunction
    ;

caseFunction
    : 'CASE' (simpleWhenClause | searchedWhenClause) ('ELSE' ('NULL' | expression)?)? 'END';

simpleWhenClause
    : expression ('WHEN' expression 'THEN' (expression | 'NULL'))*;

searchedWhenClause
    : ('WHEN' condition 'THEN' (expression | 'NULL'))*;

castFunction
    : 'CAST' '(' expression (',' expression)* 'AS' dataType ('CCSID' expression)? ('ENCODING' expression)? ('FORMAT' expression)? ('DEFAULT' expression)? ')';

selectFunction
    : 'SELECT' selectClause (',' selectClause)* fromClause whereClause?;

selectClause
    : ('ITEM'? expression | '*'| ('COUNT' | 'MAX' | 'MIN' | 'SUM') '(' (expression | '*')')') ('AS' fieldReference | 'INSERT')? ;
//    : (((expression | '*') ('AS' fieldReference | 'INSERT')?) | ('ITEM' expression) | (('COUNT' | 'MAX' | 'MIN' | 'SUM') '(' expression ')')) ;


whereClause
    : 'WHERE' condition;

rowFunction
    : 'ROW' '(' expression ('AS' fieldReference)? (',' expression ('AS' fieldReference)?)* ')' ;

miscellaneousFunctionCall
    : passthruFunction;

passthruFunction
    : 'PASSTHRU' '(' expression ('TO' 'Database.' (fieldReferenceIdentifier | '{' expression '}'))? ('VALUES' '(' expressionList ')')? ')';

expressionList
    : expression (',' expression?)* ;

callStatement
    : 'CALL' (brokerSchemaName '.')? routineCall qualifiers? ('INTO' target)? ;

target
    : fieldReference
    | IDENTIFIER
    ;

brokerSchemaName
    : fieldReferenceIdentifier ('.' fieldReferenceIdentifier)* ;

qualifiers
    : ('IN' databaseSchemaReference
      |'EXTERNAL' 'SCHEMA' databaseSchemaName)
      ;

databaseSchemaReference
    : 'Database.' (databaseSourceClause '.')? schemaClause ;

databaseSchemaName: IDENTIFIER ;

databaseSourceClause
    : databaseSourceName
    | '{' databaseSourceExpr '}'
    ;

databaseSourceName: IDENTIFIER ;

databaseSourceExpr: expression ;

schemaClause
    : schemaName | '{' schemaExpr '}'
    ;

schemaName: IDENTIFIER ;

schemaExpr: expression ;

declareStatement
    : 'DECLARE' varList ('SHARED' | 'EXTERNAL')? (('CONSTANT'? dataType) | 'NAMESPACE' | 'NAME') condition? ;

varList: fieldReferenceIdentifier (',' fieldReferenceIdentifier)* ;

declareReferenceStatement
    : 'DECLARE' varList 'REFERENCE' 'TO' fieldReference ;

createStatement
    : 'CREATE' qualifier target asClause? domainClause? (repeatClauses | valuesClauses | fromClause | parseClause)? ;

qualifier
    : 'FIELD'
    | ( 'PREVIOUSSIBLING'
      | 'NEXTSIBLING'
      | 'FIRSTCHILD'
      | 'LASTCHILD'
      ) 'OF'
    ;

asClause: 'AS' aliasFieldReferenceVariable ;

aliasFieldReferenceVariable: fieldReference ;

domainClause: 'DOMAIN' expression ;

repeatClause: 'REPEAT' ('VALUE' expression) ;

valuesClauses: namesClauses? ('VALUE' expression)? ;

namesClauses
    : ('TYPE' expression)? ('NAMESPACE' (expression | '*'))? ('NAME' expression)?
    | 'IDENTITY' pathElement
    | 'REPEAT' 'TYPE'? 'NAME'?
    ;

fromClause: 'FROM' (fieldReference | tableReference) ('AS' correlationName)? ;

parseClause
    : 'PARSE' '(' ((bitStreamExpression parseOption*) | expressionList)')'
    ;

parseOption
    : 
    ( 'ENCODING' expression
    | 'CCSID' expression
    | 'SET' expression
    | 'TYPE' expression
    | 'FORMAT' expression
    | 'OPTIONS' expression)
    ;

bitStreamExpression: expression ;

repeatClauses: 'REPEAT' ('VALUE' expression)? ;

moveStatement
    : 'MOVE' target ('TO' fieldReference
                    | 'PARENT'
                    | ('FIRSTCHILD' | 'LASTCHILD' | 'PREVIOUSSIBLING' | 'NEXTSIBLING') namesClauses) ;

returnStatement
    : 'RETURN' condition ;

correlationName
    : 'InputRoot'
    | 'OutputRoot'
    | 'Environment'
    | fieldReferenceIdentifier
    ;

fieldReferenceIdentifier
    : IDENTIFIER
    | DOUBLEQUOTESTRING
    | dataType
    | 'ALL'
    | 'InputRoot'
    | 'OutputRoot'
    | 'PARENT'
    | 'ASYMMETRIC'
    | 'Attribute'
    | 'BOTH'
    | 'CASE'
    | 'DISTINCT'
    | 'FROM'
    | 'ITEM'
    | 'LEADING'
    | 'NOT'
    | 'SYMMETRIC'
    | 'TRAILING'
    | 'WHEN'
    | 'AND'
    | 'ANY'
    | 'AS'
    | 'ATOMIC'
    | 'ATTACH'
    | 'BEGIN'
    | 'BETWEEN'
    | 'BIT'
    | 'BLOB'
    | 'BOOLEAN'
    | 'BY'
    | 'CALL'
    | 'CATALOG'
    | 'CCSID'
    | 'CHAR'
    | 'CHARACTER'
    | 'COMMIT'
    | 'COMPUTE'
    | 'CONDITION'
    | 'CONSTANT'
    | 'CONTINUE'
    | 'COORDINATED'
    | 'COUNT'
    | 'CREATE'
    | 'CURRENT_DATE'
    | 'CURRENT_GMTDATE'
    | 'CURRENT_GMTTIME'
    | 'CURRENT_GMTTIMESTAMP'
    | 'CURRENT_TIME'
    | 'CURRENT_TIMESTAMP'
    | 'DATA'
    | 'DATABASE'
    | 'DATE'
    | 'DAY'
    | 'DAYOFWEEK'
    | 'DAYOFYEAR'
    | 'DAYS'
    | 'DECIMAL'
    | 'DECLARE'
    | 'DEFAULT'
    | 'DELETE'
    | 'DETACH'
    | 'DO'
    | 'DOMAIN'
    | 'DYNAMIC'
    | 'ELSE'
    | 'ELSEIF'
    | 'ENCODING'
    | 'END'
    | 'ENVIRONMENT'
    | 'ESCAPE'
    | 'ESQL'
    | 'EVAL'
    | 'EVENT'
    | 'EXCEPTION'
    | 'EXISTS'
    | 'EXIT'
    | 'EXTERNAL'
    | 'FALSE'
    | 'FIELD'
    | 'FILTER'
    | 'FINALIZE'
    | 'FIRSTCHILD'
    | 'FLOAT'
    | 'FOR'
    | 'FORMAT'
    | 'FOUND'
    | 'FULL'
    | 'FUNCTION'
    | 'GMTTIME'
    | 'GMTTIMESTAMP'
    | 'GROUP'
    | 'HANDLER'
    | 'HAVING'
    | 'HOUR'
    | 'IDENTITY'
    | 'IF'
    | 'IN'
    | 'INF'
    | 'INFINITY'
    | 'INOUT'
    | 'INSERT'
    | 'INT'
    | 'INTEGER'
    | 'INTERVAL'
    | 'INTO'
    | 'IS'
    | 'ISLEAPYEAR'
    | 'ITERATE'
    | 'JAVA'
    | 'LABEL'
    | 'LANGUAGE'
    | 'LAST'
    | 'LASTCHILD'
    | 'LEAVE'
    | 'LIKE'
    | 'LIST'
    | 'LOCALTIMEZONE'
    | 'LOG'
    | 'LOOP'
    | 'MAX'
    | 'MESSAGE'
    | 'MIN'
    | 'MINUTE'
    | 'MODE'
    | 'MODIFIES'
    | 'MODULE'
    | 'MONTH'
    | 'MONTHS'
    | 'MOVE'
    | 'NAME'
    | 'NAMESPACE'
    | 'NAN'
    | 'NEXTSIBLING'
    | 'NONE'
    | 'NULL'
    | 'NUM'
    | 'NUMBER'
    | 'OF'
    | 'OPTIONS'
    | 'OR'
    | 'ORDER'
    | 'OUT'
    | 'ROLLBACK'
    | 'PARSE'
    | 'PASSTHRU'
    | 'PATH'
    | 'PLACING'
    | 'PREVIOUSSIBLING'
    | 'PROCEDURE'
    | 'PROPAGATE'
    | 'QUARTEROFYEAR'
    | 'QUARTERS'
    | 'READS'
    | 'REFERENCE'
    | 'REPEAT'
    | 'RESIGNAL'
    | 'RESULT'
    | 'RETURN'
    | 'RETURNS'
    | 'ROW'
    | 'SAMEFIELD'
    | 'SCHEMA'
    | 'SECOND'
    | 'SELECT'
    | 'SET'
    | 'SETS'
    | 'SEVERITY'
    | 'SHARED'
    | 'SHORT'
    | 'SOME'
    | 'SQL'
    | 'SQLCODE'
    | 'SQLERRORTEXT'
    | 'SQLEXCEPTION'
    | 'SQLNATIVEERROR'
    | 'SQLSTATE'
    | 'SQLWARNING'
    | 'SUM'
    | 'TERMINAL'
    | 'THE'
    | 'THEN'
    | 'THROW'
    | 'TIME'
    | 'TIMESTAMP'
    | 'TO'
    | 'TRACE'
    | 'TRUE'
    | 'TYPE'
    | 'UNCOORDINATED'
    | 'UNKNOWN'
    | 'UNTIL'
    | 'UPDATE'
    | 'USER'
    | 'UUIDASBLOB'
    | 'UUIDASCHAR'
    | 'VALUE'
    | 'VALUES'
    | 'WEEKOFMONTH'
    | 'WEEKOFYEAR'
    | 'WEEKS'
    | 'WHERE'
    | 'WHILE'
    | 'XML'
    | 'XMLNS'
    | 'XMLNSC'
    | 'YEAR'
    ;


dataType
    : 'BOOLEAN'
    | 'REFERENCE'
    | dateTimeType
    | 'NULL'
    | numericType
    | 'ROW'
    | stringType;

dateTimeType
    : 'DATE'
    | 'TIME'
    | 'GMTTIME'
    | 'TIMESTAMP'
    | 'GMTTIMESTAMP'
    | 'INTERVAL' intervalQualifier?
    ;

intervalQualifier
    : 'YEAR'
    | 'YEAR TO MONTH'
    | 'MONTH'
    | 'DAY'
    | 'DAY TO HOUR'
    | 'DAY TO MINUTE'
    | 'DAY TO SECOND'
    | 'HOUR'
    | 'HOUR TO MINUTE'
    | 'HOUR TO SECOND'
    | 'MINUTE'
    | 'MINUTE TO SECOND'
    | 'SECOND'
    ;

numericType
    : 'DECIMAL'
    | 'FLOAT'
    | 'INTEGER'
    | 'INT'
    ;

stringType
    : 'BIT'
    | 'BLOB'
    | 'CHARACTER'
    | 'CHAR'
    ;

/** lexer rules */

IDENTIFIER : (LETTER|UNDERSCORE) (LETTER|DIGIT|UNDERSCORE)* ;
fragment LETTER: [a-z] ;
fragment UNDERSCORE: '_';
fragment DIGIT: [0-9];

STRING
 : ('X' | 'B')? '\'' ( ~'\'' | '\'\'' )* '\''
 ;

DOUBLEQUOTESTRING
 : '"' (~'"')* '"'
 ;

CONCAT: '||' ;

NEGATIVEINT : '-' INT ;
INT : '-'? ('0x'[0-9a-f]+) | [0-9]+ ;

NUMBER : 'DECIMAL'? '\''? INT  ('.' INT)? ('e' ('+' | '-') INT)? '\''?;

WS : [ \t\r\n]+ -> channel(HIDDEN) ;

COMMENT : '--' ~'\n'* -> skip ;

BLOCKCOMMENT: '/*' .*? '*/' -> skip ;
