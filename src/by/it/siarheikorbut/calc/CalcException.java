package by.it.siarheikorbut.calc;

public class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR:" + message);
        System.out.println("ERROR:" + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR:" + message, cause);
        System.out.println("ERROR:" + message);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR:" + message, cause, enableSuppression, writableStackTrace);
        System.out.println("ERROR:" + message);
    }
}