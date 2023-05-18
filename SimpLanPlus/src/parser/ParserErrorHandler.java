package parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static utils.Utils.writeInFile;

public class ParserErrorHandler extends BaseErrorListener {

    public static final ParserErrorHandler INSTANCE = new ParserErrorHandler();
    private ArrayList<String> errorList;
    public ParserErrorHandler() {
        this.errorList = new ArrayList<String>();
    }

    public int numErrori(){
        return errorList.size();
    }
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
        System.out.println("[!] An error occurred at line " + line + ", character " + charPositionInLine + " :" + msg);
        this.errorList.add("[!] An error occurred at line " + line + ", character " + charPositionInLine + " :" + msg);
        //System.out.println("line " + line + ":" + charPositionInLine + " " + msg);
    }

    public void scriviInFile(String filename) throws IOException {
        //BufferedWriter wr = new BufferedWriter(new FileWriter(filename));
        String errori = "";
        for (String event : this.errorList) {
            errori += event + "\n";
        }
        writeInFile(filename, errori);
//        wr.write(errori);
//        wr.close();
    }
}
