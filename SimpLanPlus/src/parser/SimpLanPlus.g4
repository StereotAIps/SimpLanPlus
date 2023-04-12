grammar SimpLanPlus;

@lexer::members {
   //there is a much better way to do this, check the ANTLR guide
   public int lexicalErrors=0;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

//* ci sono i comandi: un programma o il corpo di una funzione può essere stm oppure let dec in stm
//in questo modo le dichiarazioni di funzioni possono essere fatte solo in radice
program : (dec | stm )* ;

stm: asg ';'
    | ite
    | let (stm | dec)
    | call ';';

dec : decFun    #funDec
    | decVar ';'   #varDec;

//* i tipi includono anche il tipo void ;
//* le funzioni possono essere ricorsive (ma non mutuamente ricorsive) - non è possibile definire una funzione all'interno del corpo di una funzione
//* ci sono i comandi: un programma o il corpo di una funzione può essere stm oppure let dec in stm
decFun : (type | 'void') ID '(' (decVar (',' decVar)*)? ')' body ;

//* le dichiarazioni di variabili sono:  type ID (senza inizializzazione) ;
decVar : type ID ;

asg  : ID '=' exp ;

call : ID '(' (exp(',' exp)*)? ')' ;

ite : 'if' '(' exp ')' body ('else' body)? ;

//* ci sono i comandi: un programma o il corpo di una funzione può essere stm oppure let dec in stm
//* sono ammessi corpi di funzioni del tipo { stm ; exp }. In tal caso la funzione, dopo aver valutato stm, ritorna il valore di exp.
//in questo modo posso anche solo ritornare exp senza nessuno stm
body : '{' (((decVar ';') | stm ( exp)? )*| exp)  '}'
        | (stm | exp ';');

//block : '{' (dec | stm | (let stm ';'))* '}' ;

let    : 'let' (dec)+ 'in';
//let int x = 5 in x+1 - non consentito perché assegnamento?

type   : 'int'  
       | 'bool'
       ;

exp	    : '(' exp ')'				                        #baseExp
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
