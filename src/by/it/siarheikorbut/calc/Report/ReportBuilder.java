package by.it.siarheikorbut.calc.Report;

abstract class ReportBuilder {

    Report report;

    public Report getReport() {
        return report;
    }

    void createNewReportProduct() {
        report = new Report();
    }

    public abstract void buildHeader();

    public abstract void buildBody();

    public abstract void buildFooter();
}
