grammar SimpLanPlus ;

prog   : exp                  EOF                                       #expProg
       | (dec)+ (stm)* (exp)? EOF                                       #letProg
       ;

dec    : type ID ';'                                                    #varDec
       | type ID '(' ( param ( ',' param)* )? ')' '{' body '}'          #funDec
       ;

param  : type ID
       ;

body   : (dec)* (stm)* (exp)?
	   ;

type   : 'int'
       | 'bool'
       | 'void'
       ;

stm    : ID '=' exp ';'                                                                                      #asgStm
       | ID '(' (exp (',' exp)* )? ')' ';'                                                                   #callStm
       | 'if' '(' exp ')' '{' left=stms '}' ('else' '{' right=stms '}')?                                     #ifStm
	   ;

stms   : (stm)+
       ;

stme   : (stm)* exp
       ;


exp    :  INTEGER                                                                                            #intExp
       | ('true' | 'false')                                                                                  #boolExp
       | ID                                                                                                  #idExp
       | '!' exp                                                                                             #notExp
       | leftExp=exp (op='*' | op='/') rightExp=exp                                                          #numExp
       | leftExp=exp (op='+' | op='-') rightExp=exp                                                          #numExp
       | leftExp=exp  '==' rightExp=exp                                                                      #eqExp
       | leftExp=exp (op='>' | op='<' | op='>=' | op='<=' ) rightExp=exp                                     #compExp
       | leftExp=exp (op='&&' | op='||') rightExp=exp                                                        #opExp
       | 'if' '(' cond=exp ')' '{' left=stme '}' 'else' '{' right=stme '}'                                   #ifExp
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

//ERR             : .  -> channel(HIDDEN);
