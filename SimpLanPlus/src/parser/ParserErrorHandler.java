package parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;

public class ParserErrorHandler extends BaseErrorListener {

    public static final ParserErrorHandler INSTANCE = new ParserErrorHandler();
    private ArrayList<String> errorList;
    public ParserErrorHandler() {
        this.errorList = new ArrayList<String>();
    }
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
        System.out.println("line " + line + ":" + charPositionInLine + " " + msg);
        this.errorList.add("line " + line + ":" + charPositionInLine + " " + msg);
        //System.out.println("line " + line + ":" + charPositionInLine + " " + msg);
    }
           // throws ParseCancellationException {
        //throw new ParseCancellationException
            //("line " + line + ":" + charPositionInLine + " " + msg);
    //}

    public String getErrors (){
        String res = "";
        for (String event : this.errorList) {
            res += event + "\n";
        }
        return res;
    }

    public boolean isError(){
        return errorList.size() > 0;
    }
}
