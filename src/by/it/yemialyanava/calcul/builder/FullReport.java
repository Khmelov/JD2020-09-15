package by.it.yemialyanava.calcul.builder;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

/** "ConcreteBuilder" */
public class FullReport extends ReportBuilder {



    public void buildInformationOfError(Exception exception) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        String sStackTrace = sw.toString();
        report.setInformationOfError(sStackTrace);
    }
}
