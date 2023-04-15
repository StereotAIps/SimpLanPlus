package mainPackage;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class ThrowingErrorListener extends BaseErrorListener {

    public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
        System.out.println("line " + line + ":" + charPositionInLine + " " + msg);
    }
           // throws ParseCancellationException {
        //throw new ParseCancellationException
            //("line " + line + ":" + charPositionInLine + " " + msg);
    //}
}