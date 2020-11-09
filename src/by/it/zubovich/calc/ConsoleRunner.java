package by.it.zubovich.calc;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static Lang manager;

    public static void main(String[] args) throws CalcException {
        System.out.print(
                "For examples for calculations in console, also division on 0\n" +
                        "3.8+26.2  " +
                        "87.4-23.1  " +
                        "1.04*5.9  " +
                        "12.7*5  " +
                        "6+12  " +
                        "7*3.1  " +
                        "4/8  " +
                        "9-0.9  \n" +
                        "{2,3,4}*2  " +
                        "{2,3,4}/3  " +
                        "{2,3,4}-5  " +
                        "4+{2,3,4}  " +
                        "{2,3,4}+{5,6,7} {2,3,4}-{5,6,7}\n" +
                        "{{1,2},{8,3}}-2  " +
                        "{{1,2},{8,3}}*{1,2}  " +
                        "{{1,2},{8,3}}*{{1,2},{8,3}}  " +
                        "{{1,2},{8,3}}+{{1,2},{8,3}}\n" +
                        "You can copy/insert/input examples, for finish write \"end\":\n");
        Scanner sc = new Scanner(System.in);
        String line;
//        final LocalDateTime timeStart = LocalDateTime.now();
        Logger logger = Logger.GET;
//        Report report = new Report();
//        Scanner sc1 = new Scanner(System.in);
//        String reportVariant = sc1.nextLine();
//        if (reportVariant.equals("small")){ report.setReport(new LoggerBuilderSimple());}
//        else if(reportVariant.equals("dep")){report.setReport(new LoggerBuilderDeployed()); }
//        else{
//            report.setReport(new LoggerBuilderSimple());
//            System.out.println("By default the report will be SMALL");
//        }
//        report.reportTimeEnter(timeStart);
//        Lang manager1 = Lang.INS;
//        Locale locale = Locale.getDefault();
//        manager1.setLocale(locale);
//        manager = manager1;
        Parser parser = new Parser();
        Printer printer = new Printer();
//        try {
//            Var.load();
//        } catch (CalcException e) {
//            System.out.println("File not found");
//        }
        while (!(line = sc.nextLine()).equals("end")) {
            try {
                Var result = parser.calc(line);
                printer.print(result);
                //report.reportExpression(result.toString());
            } catch (CalcException e) {
                String message = e.getMessage();
                System.out.println(e.getMessage());
                System.out.println(message);
                logger.log(message);
                //report.reportExpression(message);
            }
        }
    }
}
