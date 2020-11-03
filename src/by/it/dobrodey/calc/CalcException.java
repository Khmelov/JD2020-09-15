package by.it.dobrodey.calc;

import java.time.LocalDateTime;

public class CalcException extends Exception {

    public CalcException() {super();}

    public CalcException(String message) {super(ConsoleRunner.manager.get(Message.error)+" "+message);}

    public CalcException(String message, Throwable cause) {
        super((ConsoleRunner.manager.get(Message.error)+" "+message+"  "), cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

}
