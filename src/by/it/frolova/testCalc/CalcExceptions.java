package by.it.frolova.testCalc;

public class CalcExceptions extends Exception {

    public CalcExceptions() {
        super();
    }

    public CalcExceptions(String message) {
        super("ERROR: " + message);
    }

    public CalcExceptions(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcExceptions(Throwable cause) {
        super(cause);
    }
}
