package mainPackage;

import java.io.FileInputStream;


import ast.Node;
import ast.SimpLanPlusVisitorImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;


public class Main {
    public static void main(String[] args) throws Exception {

        String fileName = "./src/mainPackage/prova.simplan";
        FileInputStream is = new FileInputStream(fileName);
        ANTLRInputStream input = new ANTLRInputStream(is);
        SimpLanPlusLexer lexer = new SimpLanPlusLexer(input);
        //System.out.println(lexer.lexicalErrors); NON DOVREBBE DARE SUBITO GLI ERRORI PRIMA DI COSTRUIRE L'AST
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpLanPlusParser parser = new SimpLanPlusParser(tokens);

        SimpLanPlusVisitorImpl visitor = new SimpLanPlusVisitorImpl();
        Node ast = visitor.visit(parser.program()); //generazione AST

        //Create the parser error listenter
        //ParserErrorHandler handler = new ParserErrorHandler();
        //lexer.removeErrorListeners();
        //lexer.addErrorListener(handler);
        //parser.removeErrorListeners();
        //parser.addErrorListener(handler);

        //SimpLanPlusVisitorImpl visitor = new SimpLanPlusVisitorImpl();

//        if (handler.isError()) {
//            System.out.println(handler);
//            System.out.println(handler.getErrors());
//            //handler.dumpToFile(filename + ".log");
//            return;
//        }
    }
}