package mainPackage;

import java.io.FileInputStream;
import java.util.ArrayList;


import ast.Node;
import ast.SimpLanPlusVisitorImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.ParserErrorHandler;
import parser.SimpLanPlusLexer;
import parser.SimpLanPlusParser;
import semanticanalysis.ErrorType;
import semanticanalysis.SemanticError;
import symboltable.SymbolTable;

/**
 * param  : type ID
 * */
public class Main {
    public static void main(String[] args) throws Exception {

        String fileName = "./src/mainPackage/prova.simplan";
        FileInputStream is = new FileInputStream(fileName);
        ANTLRInputStream input = new ANTLRInputStream(is);
        SimpLanPlusLexer lexer = new SimpLanPlusLexer(input);
        ParserErrorHandler handler = new ParserErrorHandler();
        lexer.removeErrorListeners();
        lexer.addErrorListener(handler);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpLanPlusParser parser = new SimpLanPlusParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(handler);
        SimpLanPlusVisitorImpl visitor = new SimpLanPlusVisitorImpl();
        // Faccio il parsing
        System.out.println("Parsing in progress....");
        Node ast = visitor.visit(parser.prog());
        //Controllo se ci sono errori
        if (handler.numErrori() != 0) {
            //Ci sono errori
            System.out.println(handler);
            handler.scriviInFile("./src/mainPackage/errori.log");
            return;
        }
        System.out.println("Parse completed!");
        System.out.println("Checking semantic errors...");
        SymbolTable ST = new SymbolTable();
        ArrayList<SemanticError> errors = ast.checkSemantics(ST, 0);
        if(errors.size()>0) {
            System.out.println("You had: " + errors.size() + " errors:");
            for (SemanticError e : errors)
                System.out.println("\t" + e);
            return;
        }
        System.out.println("Visualizing AST...");
        System.out.println(ast.toPrint(""));
        System.out.println("Checking type errors...");
        Node type = ast.typeCheck(); //type-checking bottom-up
        if (type instanceof ErrorType)
            System.out.println("Type checking is WRONG!");
        else
            System.out.println(type.toPrint("Type checking ok! Type of the program is: "));
    }
}