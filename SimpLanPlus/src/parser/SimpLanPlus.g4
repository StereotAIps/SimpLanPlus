grammar SimpLanPlus ;

prog   : exp                                                            #expProg
       | (dec)+ (stm)* (exp)?                                           #letProg
       ;

dec    : type ID ';'                                                    #varDec
       | type ID '(' ( param ( ',' param)* )? ')' '{' body '}'          #funDec
       ;

param  : type ID ;

body   : (dec)* (stm)* (exp)?
	   ;

type   : 'int'
       | 'bool'
       | 'void'
       ;

stm    : ID '=' exp ';'                                                 #asgStm
       | call ';'                                                       #callStm
       | 'if' '(' exp ')' '{' (stm)+ '}' ('else' '{' (stm)+ '}')?       #ifStm
	   ;

call   : ID '(' (exp (',' exp)* )? ')' ;

exp    :  INTEGER                                                       #intExp
       | ('true' | 'false')                                             #boolExp
       | ID                                                             #idExp
       | '!' exp                                                        #binExp
       | exp ('*' | '/') exp                                            #numExp
       | exp ('+' | '-') exp                                            #numExp
       | exp ('>' | '<' | '>=' | '<=' | '==') exp                       #binExp
       | exp ('&&' | '||') exp                                          #binExp
       | 'if' '(' exp ')' '{' (stm)* exp '}' 'else' '{' (stm)* exp '}'  #ifExp
       | '(' exp ')'                                                    #baseExp
       | call                                                           #callExp
       ;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

//Numbers
fragment DIGIT  : '0'..'9';
INTEGER         : DIGIT+;

//IDs
fragment CHAR   : 'a'..'z' |'A'..'Z' ;
ID              : CHAR (CHAR | DIGIT)* ;

//ESCAPE SEQUENCES
WS              : (' '|'\t'|'\n'|'\r')-> skip;
LINECOMENTS     : '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip;

ERR             : .  -> channel(HIDDEN);
