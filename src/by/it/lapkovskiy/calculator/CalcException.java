package by.it.lapkovskiy.calculator;

public class CalcException extends Exception {

    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super(ConsoleRunner.rasMan.get(Message.error) +":"+message);
    }

    public CalcException(String message, Throwable cause) {
        super(ConsoleRunner.rasMan.get(Message.error) +":"+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

}
