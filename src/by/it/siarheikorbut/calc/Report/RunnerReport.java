package by.it.siarheikorbut.calc.Report;

public class RunnerReport {
    public static void main(String[] args) {

        ReportCreator reportCreator = new ReportCreator();
        ReportBuilder reportBuilder = Math.random() > 0.5 ? new LongReport() : new ShortReport();
        reportCreator.setReportBuilder(reportBuilder);
        reportCreator.constructReport();
        Report report = reportCreator.getReport();
        System.out.println(report.toString());
    }
}
