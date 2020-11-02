package by.it.fedorinhyk.jd02_04;

public class CalcException extends Exception {
    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super("ERROR: "+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    protected CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: "+message, cause, enableSuppression, writableStackTrace);
    }
}
