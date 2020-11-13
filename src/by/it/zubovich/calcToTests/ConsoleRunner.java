package by.it.zubovich.calcToTests;

import java.util.Scanner;

public class ConsoleRunner {

    static class Th extends Thread {
        public Th(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger logger = Logger.getInstance();
            try {
                logger.log(getName());
            } catch (CalcException e) {
                e.printStackTrace();
            }
        }
    }

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
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = sc.nextLine()).equals("end")) {
            try {
                Var result = parser.calc(line);
                printer.print(result);

            } catch (CalcException e) {
                String message = e.getMessage();
                System.out.println(message);
            }
        }

        Logger logger = Logger.getInstance();
        logger.log("one");
        Report report = new Report();
        for (int i = 0; i < 10; i++) {
            new Th("th" + i).start();
            try {
                String expression = sc.nextLine();
                expression = expression.trim();
                report.reportExpression(expression);
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
