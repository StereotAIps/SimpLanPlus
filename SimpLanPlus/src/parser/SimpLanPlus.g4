grammar SimpLanPlus;
//
//@lexer::members {
//   //there is a much better way to do this, check the ANTLR guide
//   public int lexicalErrors=0;
//}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
program :  dec* stm* ;

//prog   : exp ';'                 #singleExp
//       | let exp ';'             #letInExp
//       ;

stm: exp
    | asg
    | dec
    | let
    | ite
    | call
    | block ;


dec : decFun
    | decVar ;

decFun : (type | 'void') ID '(' (arg (',' arg)*)? ')' block ;

arg : type ID;

asg  : ID '=' exp ';' ;

block : '{' dec* stm* '}' ;

decVar : type ID ';' ;
//dec    : type ID '=' exp                                         #idInit
//       | type ID '(' ( param ( ',' param)* )? ')' '=' (let)? exp     #funDec
//       ;

call : ID '(' (exp(',' exp)*)? ')' ';';
//param  : type ID ;

ite : 'if' '(' exp ')' block ('else' block)? ;

let    : 'let' (dec )+ 'in' stm;

type   : 'int'  
       | 'bool'
       ;  



//exp    :  ('-')? left=term ((plus='+' | sub='-') right=exp)?
//       ;
//
//term   : left=factor ((mul='*' | div='/') right=term)?
//       ;
//
//factor : left=value ('==' right=value)?
//       ;

exp	    : '(' exp ')'				        #baseExp
	    //| '-' exp					        #negExp
	    //| '!' exp                                           #notExp
	    | ID						                        #varExp
	    | left=exp op=('*' | '/')               right=exp   #binExp
	    | left=exp op=('+' | '-')               right=exp   #binExp
	    | left=exp op=('<' | '<=' | '>' | '>=') right=exp   #binExp
	    | left=exp op=('=='| '!=')              right=exp   #binExp
	    | left=exp op='&&'                      right=exp   #binExp
	    | left=exp op='||'                      right=exp   #binExp
	    | call                                              #callExp
	    | BOOL                                              #boolExp
	    | INTEGER					        #valExp;

//value  :  INTEGER							#intVal
//       | BOOL                               #boolVal
//       | '(' exp ')'                      	#baseExp
//       | 'if' cond=exp 'then' '{' thenBranch=exp '}' 'else' '{' elseBranch=exp '}'  #ifExp
//       | ID                                  #varExp
//       | ID '(' (exp (',' exp)* )? ')'       #funExp
//       ;
 
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

//Booleans
BOOL        : 'true'|'false';

//Numbers
fragment DIGIT : '0'..'9';    
INTEGER       : DIGIT+;

//IDs
fragment CHAR  : 'a'..'z' |'A'..'Z' ;
ID              : CHAR (CHAR | DIGIT)* ;

//ESCAPE SEQUENCES
WS              : (' '|'\t'|'\n'|'\r')-> skip;
LINECOMENTS    : '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip;

 //VERY SIMPLISTIC ERROR CHECK FOR THE LEXING PROCESS, THE OUTPUT GOES DIRECTLY TO THE TERMINAL
 //THIS IS WRONG!!!!
ERR     : . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN); 
