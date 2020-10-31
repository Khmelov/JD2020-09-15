package by.it.yemialyanava.calcul;

public class CalcException extends Exception  {
    public CalcException(){
        super();
    }

    public CalcException(String message){
        super(ConsoleRunner.manager.get(MessagesNames.ERROR) + message);
    }

    public CalcException(Throwable cause){
        super(cause);
    }

    public CalcException(String message, Throwable cause){
        super(ConsoleRunner.manager.get(MessagesNames.ERROR) + message, cause);
    }
}
