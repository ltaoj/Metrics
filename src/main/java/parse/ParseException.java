package parse;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by ltaoj on 2018/05/24 12:30.
 *
 * @version : 1.0
 */
public class ParseException extends Exception {

    private Throwable nestedException;

    public ParseException() {
        super("Error occurred in parse process.");
    }

    public ParseException(String message) {
        super(message);
    }

    public ParseException(Throwable nestedException) {
        super(nestedException.getMessage());
        this.nestedException = nestedException;
    }

    public ParseException(String message, Throwable nestedException) {
        super(message);
        this.nestedException = nestedException;
    }

    public Throwable getNestedException() {
        return nestedException;
    }

    public String getMessage() {
        if (nestedException != null) {
            return super.getMessage() + " Nested exception: "
                    + nestedException.getMessage();
        } else {
            return super.getMessage();
        }
    }

    public void printStackTrace() {
        super.printStackTrace();

        if (nestedException != null) {
            System.err.print("Nested exception: ");
            nestedException.printStackTrace();
        }
    }

    public void printStackTrace(PrintStream out) {
        super.printStackTrace(out);

        if (nestedException != null) {
            out.println("Nested exception: ");
            nestedException.printStackTrace(out);
        }
    }

    public void printStackTrace(PrintWriter writer) {
        super.printStackTrace(writer);

        if (nestedException != null) {
            writer.println("Nested exception: ");
            nestedException.printStackTrace(writer);
        }
    }
}
