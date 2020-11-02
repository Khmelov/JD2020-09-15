package by.it.dobrodey.calc;


import java.time.LocalDateTime;

abstract class LoggerBuilder {

    abstract void timeEnter(LocalDateTime time) throws CalcException;
    abstract void log(String text) throws CalcException;
    abstract void timeExit(LocalDateTime time) throws CalcException;

        }


