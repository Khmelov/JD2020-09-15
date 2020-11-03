package by.it.yemialyanava.calcul;

import by.it.yemialyanava.calcul.builder.FullReport;
import by.it.yemialyanava.calcul.builder.Report;
import by.it.yemialyanava.calcul.builder.ReportBuilder;

import java.util.Scanner;

public class ConsoleRunner {
    public static Lang manager = Lang.UK;

    public static void main(String[] args) {
        ReportBuilder reportBuilder = new FullReport();
        reportBuilder.createNewReport();
        reportBuilder.buildHead();
        reportBuilder.buildTimeOfRun();
        Scanner scan = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            Var.load();
        } catch (CalcException e) {
            Logger.INSTANCE.log(ConsoleRunner.manager.get(MessagesNames.MISSING_FILE));
        }
        for (; ; ) {
            String expression = scan.nextLine();
            Logger.INSTANCE.log(expression);
            if (expression.equals("end")) {
                break;
            }
            if (expression.equals("ru")) {
                manager = Lang.RU;
            } else if (expression.equals("be")) {
                manager = Lang.RB;
            } else if (expression.equals("en")) {
                manager = Lang.UK;
            } else {
                if (expression.equals("printvar")) {
                    printer.printVar(Var.getVarMap());
                    continue;
                }
                if (expression.equals("sortvar")) {
                    printer.sortVar(Var.getVarMap());
                    continue;
                }
                try {
                    Var result = parser.calcWithBrackets(expression);
                    printer.print(result);
                    reportBuilder.buildInformationPart(expression, result.toString());
                } catch (CalcException e) {
                    String message = e.getMessage();
                    System.out.println(message);
                    Logger.INSTANCE.log(message);
                    reportBuilder.buildInformationOfError(e);
                } finally {
                    reportBuilder.buildTimeOfEnd();
                    Report report = reportBuilder.getReport();
                    report.toString();
                    Logger.INSTANCE.log(report.toString());
                }
            }
        }
    }
}
