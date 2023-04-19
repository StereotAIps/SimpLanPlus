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

stm    : ID '=' exp ';'                                                                                      #asgStm
       | ID '(' (exp (',' exp)* )? ')' ';'                                                                   #callStm
       | 'if' '(' exp ')' '{' (stm)+ '}' ('else' '{' (stm)+ '}')?                                            #ifStm
	   ;



exp    :  INTEGER                                                                                            #intExp
       | ('true' | 'false')                                                                                  #boolExp
       | ID                                                                                                  #idExp
       | '!' exp                                                                                             #notExp
       | leftExp=exp ('*' | '/') rightExp=exp                                                                #numExp
       | leftExp=exp ('+' | '-') rightExp=exp                                                                #numExp
       | leftExp=exp  '==' rightExp=exp                                                                      #eqExp
       | leftExp=exp ('>' | '<' | '>=' | '<=' ) rightExp=exp                                                 #compExp
       | leftExp=exp ('&&' | '||') rightExp=exp                                                              #opExp
       | 'if' '(' cond=exp ')' '{' (thenStm=stm)* thenExp=exp '}' 'else' '{' (elseStm=stm)* elseExp=exp '}'  #ifExp
       | '(' exp ')'                                                                                         #baseExp
       | ID '(' (exp (',' exp)* )? ')'                                                                       #callExp
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
