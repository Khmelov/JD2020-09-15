package by.it.yemialyanava.calcul.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** "Abstract Builder" */
public abstract class ReportBuilder {

    Report report;

     public Report getReport() {
        return report;
    }

    public void createNewReport() {
        report = new Report();
    }

    public void buildHead(){
        report.setHead("Report");
    };

    public  void buildTimeOfRun() {
        report.setTimeOfStart(LocalDateTime.now());
    }

    public void buildInformationPart(String expression, String result) {
        report.setInformationPart(expression + " = " + result);
    }

    public abstract void buildInformationOfError(Exception exception);

    public void buildTimeOfEnd() {
        report.setTimeOfEnd(LocalDateTime.now());
    };
}