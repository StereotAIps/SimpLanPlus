package mainPackage;

import java.io.FileInputStream;


import ast.Node;
import ast.SimpLanPlusVisitorImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.ParserErrorHandler;
import parser.SimpLanPlusLexer;
import parser.SimpLanPlusParser;


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
        System.out.println("Parsing");
        Node ast = visitor.visit(parser.prog());
        //Controllo se ci sono errori
        if (handler.numErrori() != 0) {
            //Ci sono errori
            System.out.println(handler);
            handler.scriviInFile("./src/mainPackage/errori.log");
            return;
        }
        System.out.println("[L] Parse completed without issues!");
        System.out.println("[L] Checking for semantic errors...");
    }
}