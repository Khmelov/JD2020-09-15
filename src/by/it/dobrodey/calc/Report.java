package by.it.dobrodey.calc;

import java.time.LocalDateTime;

public class Report {
    private LoggerBuilder logBuild;

    void setReport(LoggerBuilder loggerBuilder) {
        logBuild = loggerBuilder;
    }

    void reportTimeEnter(LocalDateTime time) throws CalcException {
        logBuild.timeEnter(time);
            }

    void reportExpression(String text) throws CalcException {
        logBuild.log(text);

    }

    void reportExitEnter(LocalDateTime time) throws CalcException {
        logBuild.timeExit(time);


    }
}


