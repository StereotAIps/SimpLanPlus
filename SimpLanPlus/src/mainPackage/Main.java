package mainPackage;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;


import ast.Node;
import ast.SimpLanPlusVisitorImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.ParserErrorHandler;
import parser.SimpLanPlusLexer;
import parser.SimpLanPlusParser;
import ast.Types.ErrorType;
import symboltable.SemanticError;
import symboltable.SymbolTable;

import static utils.Utils.createFile;
import static utils.Utils.writeInFile;

/**
 * param  : type ID
 * */
public class Main {
    public static void main(String[] args) throws Exception {

        String fileinput = "./src/mainPackage/prova.simplan";
        String fileError = "./src/mainPackage/errori.log";
        createFile(fileError);
        FileInputStream is = new FileInputStream(fileinput);
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
            handler.scriviInFile(fileError);
            return;
        }
        System.out.println("Parse completed without errors!");
        System.out.println("Checking semantic errors...");
        SymbolTable ST = new SymbolTable();
        ArrayList<SemanticError> errors = ast.checkSemantics(ST, 0);
        if(errors.size()>0) {
            //Bisogna scrivere questi errori nel file prova.simplan e bisogna assicurarsi che il file sia vuoto
            // all'inizio del main così che ogni volta che si esugue codice sia vuto se non ci sono errori
            System.out.println("You had: " + errors.size() + " errors:");
            String semError = "";
            for (SemanticError e : errors) {
                semError += "[!] A semantic error occurred: " + e + "\n";
                System.out.println("[!] A semantic error occurred: " + e + "\t");
                writeInFile(fileError, semError);
            }
            return;
        }
        System.out.println("Visualizing AST...");
        //System.out.println(ast.toPrint(""));
        System.out.println("Checking type errors...");
        Node type = ast.typeCheck(); //type-checking bottom-up
        if (type instanceof ErrorType)
            System.out.println("Type checking is WRONG!");
        else
            System.out.println(type.toPrint("Type checking ok! Type of the program is: "));

        // CODE GENERATION  prova.SimpLan.asm
        String code=ast.codeGeneration();
        BufferedWriter out = new BufferedWriter(new FileWriter(fileinput+".asm"));
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