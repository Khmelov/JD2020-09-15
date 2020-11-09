package by.it.siarheikorbut.calc;

public class CalcException extends Exception {
    private static final Lang resource = Lang.LANG;

    public CalcException() {
    }

    public CalcException(String message) {
        super(resource.get(Error.ERR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(resource.get(Error.ERR) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}