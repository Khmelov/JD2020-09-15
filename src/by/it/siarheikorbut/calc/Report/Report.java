package by.it.siarheikorbut.calc.Report;

public class Report {

    private String headerReport = "";
    private String bodyReport = "";
    private String footerReport = "";

    public void setHeaderReport(String headerReport) {
        this.headerReport = headerReport;
    }

    public void setBodyReport(String bodyReport) {
        this.bodyReport = bodyReport;
    }

    public void setFooterReport(String footerReport) {
        this.footerReport = footerReport;
    }

    @Override
    public String toString() {
        return headerReport + bodyReport + footerReport;
    }
}
