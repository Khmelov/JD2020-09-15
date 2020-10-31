package by.it.frolova.testCalc;

public class CalcExceptions extends Exception {
   private static Lang manager = Lang.INSTANCE;

    public CalcExceptions() {
        super();
    }

    public CalcExceptions(String message) {
        super(manager.get(Error.ERROR_MESSAGE) + message);
    }

    public CalcExceptions(String message, Throwable cause) {
        super(manager.get(Error.ERROR_MESSAGE) + message, cause);
    }

    public CalcExceptions(Throwable cause) {
        super(cause);
    }
}
