package generated;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.ArrayList;
import java.util.List;


public class ThrowingErrorListener extends BaseErrorListener {
    public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();
    private List<String> errorMessages = new ArrayList<String>();

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(String errorMessage) {
        this.errorMessages.add(errorMessage);
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
            throws ParseCancellationException {
        String error = "Line " + line + ":" + charPositionInLine + " --|> " + msg;
        setErrorMessages(error);
        //System.out.println(error);
        //throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
    }
}