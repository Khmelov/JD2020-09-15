package by.it.zubovich.calc;

import java.time.LocalDateTime;

public class CalcException extends Exception {
    public CalcException(String s, Var var, Var other) {
    }

    public CalcException(String message) {
        super("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: " + message, cause, enableSuppression, writableStackTrace);
    }
    //    public CalcException() {
//        super();}
//
//    public CalcException(String message) {
//        super(ConsoleRunner.manager.get(Message.error)+" "+message);}
//
//    public CalcException(String message, Throwable cause) {
//        super((ConsoleRunner.manager.get(Message.error)+" "+message+"  "), cause);
//    }
//
//    public CalcException(Throwable cause) {
//        super(cause);
//    }
}
