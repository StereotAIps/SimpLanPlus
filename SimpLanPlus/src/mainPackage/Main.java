package mainPackage;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;


import ast.Node;
import ast.SVMVisitorImpl;
import ast.SimpLanPlusVisitorImpl;
import evaluator.ExecuteVM;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.ParserErrorHandler;
import parser.SimpLanPlusLexer;
import parser.SimpLanPlusParser;
import semanticanalysis.ErrorType;
import semanticanalysis.SemanticError;
import svm.SVMLexer;
import svm.SVMParser;
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

        // CODE GENERATION  prova.SimpLan.asm
        String code=ast.codeGeneration();
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm"));
        out.write(code);
        out.close();
        System.out.println("Code generated! Assembling and running generated code.");

//        FileInputStream isASM = new FileInputStream(fileName+".asm");
//        ANTLRInputStream inputASM = new ANTLRInputStream(isASM);
//        SVMLexer lexerASM = new SVMLexer(inputASM);
//        CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
//        SVMParser parserASM = new SVMParser(tokensASM);
//
//        //parserASM.assembly();
//
//        SVMVisitorImpl visitorSVM = new SVMVisitorImpl();
//        visitorSVM.visit(parserASM.assembly());
//
////        System.out.println("You had: "+lexerASM.lexicalErrors+" lexical errors and "+parserASM.getNumberOfSyntaxErrors()+" syntax errors.");
////        if (lexerASM.lexicalErrors>0 || parserASM.getNumberOfSyntaxErrors()>0) System.exit(1);
//
//          System.out.println("Starting Virtual Machine...");
//          ExecuteVM vm = new ExecuteVM(visitorSVM.code);
//          vm.cpu();

    }
}