package by.it.yemialyanava.calcul.builder;


/**
 * "ConcreteBuilder"
 */
class ShortReport extends ReportBuilder {

    public void buildInformationOfError(Exception exception) {

        report.setInformationOfError(exception.getMessage());
    }


}
