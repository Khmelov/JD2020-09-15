package by.it.dobrodey.calc;


import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static Lang manager;

    public static void main(String[] args) throws CalcException {
        final LocalDateTime timeStart = LocalDateTime.now();
        Logger logger = Logger.GET;
        Report report = new Report();
        System.out.println("Inrut variant report small or dep:");
        Scanner sc1 = new Scanner(System.in);
        String reportvariant = sc1.nextLine();
        if (reportvariant.equals("small")){ report.setReport(new LoggerBuilderSimple());}
        else if(reportvariant.equals("dep")){report.setReport(new LoggerBuilderDeployed()); }
        else{
            report.setReport(new LoggerBuilderSimple());
            System.out.println("By default the report will be SMALL");
        }
        report.reportTimeEnter(timeStart);
        Lang manager1 = Lang.INS;
        Locale locale = Locale.getDefault();
        manager1.setLocale(locale);
        manager = manager1;

        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            Var.load();
        } catch (CalcException e) {
            System.out.println("File not found");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ведите ru/be/en");
        for (; ; ) {

            String expression = sc.nextLine();
            expression = expression.trim();
            report.reportExpression(expression);
            if (Lang.lang.containsKey(expression)) {
                System.out.println(expression + "  " + Lang.lang.get(expression));
                locale = new Locale(expression, Lang.lang.get(expression));
                manager.setLocale(locale);
                System.out.println(manager.get(Message.OPERASSION));
                logger.log(manager.get(Message.OPERASSION));
                System.out.println(manager.get(Message.input));
                logger.log(manager.get(Message.input));
                continue;
            }

            if (expression.equals("end")){ report.reportExitEnter(LocalDateTime.now());
                break;}
            if (expression.equals("printvar")) {
                printer.printvar(Var.getVarMap());
                report.reportExpression(Var.getVarMap().toString());
                continue;
            }
            if (expression.equals("sortvar")) {
                printer.printsort(Var.getVarMap());
                report.reportExpression(Var.getVarMap().toString());
                continue;
            }
            try {

                Var result = parser.calc(expression);
                printer.print(result);
                report.reportExpression(result.toString());
            } catch (CalcException e) {
                String message = e.getMessage();
                System.out.println(message);
                logger.log(message);
                report.reportExpression(message);
            }
        }
    }
}

