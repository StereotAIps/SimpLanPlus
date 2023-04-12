package mainPackage;

import java.io.FileInputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.SimpLanPlusLexer;
import parser.SimpLanPlusParser;


public class Main {
    public static void main(String[] args) throws Exception {

        String fileName = "./src/mainPackage/prova.simplan";

        FileInputStream is = new FileInputStream(fileName);
        ANTLRInputStream input = new ANTLRInputStream(is);
        SimpLanPlusLexer lexer = new SimpLanPlusLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SimpLanPlusParser parser = new SimpLanPlusParser(tokens);
        //SimpLanPlusVisitor visitor = new SimpLanPlusVisitor();
        //Node ast = visitor.visit(parser.prog()); //generazione AST

        //SIMPLE CHECK FOR LEXER ERRORS
        if (lexer.lexicalErrors > 0) {
            System.out.println("The program was not in the right format. Exiting the compilation process now");
        }
//        else {
//            SymbolTable ST = new SymbolTable();
//            ArrayList<SemanticError> errors = ast.checkSemantics(ST, 0);
//            if(errors.size()>0){
//                System.out.println("You had: " + errors.size() + " errors:");
//                for(SemanticError e : errors)
//                    System.out.println("\t" + e);
//            } else {
//                System.out.println("Visualizing AST...");
//                System.out.println(ast.toPrint(""));
//
//                Node type = ast.typeCheck(); //type-checking bottom-up
//                if (type instanceof ErrorType)
//                    System.out.println("Type checking is WRONG!");
//                else
//                    System.out.println(type.toPrint("Type checking ok! Type of the program is: "));
//
//
//            }
    }
}