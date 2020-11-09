package by.it.siarheikorbut.calc.Report;

public class ReportCreator {
    private ReportBuilder reportBuilder;

    public void setReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    Report report() {
        return reportBuilder.getReport();
    }

    Report getReport() {
        return reportBuilder.getReport();
    }

    void constructReport() {
        reportBuilder.createNewReportProduct();
        reportBuilder.buildHeader();
        reportBuilder.buildBody();
        reportBuilder.buildFooter();
    }
}
