package by.it.frolova.testCalc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcExceptions {

        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();

        for (; ; ) {
            String expression = sc.nextLine();
            if (expression.equals("end")) {
                break;
            } else {
                Var result = parser.calc(expression);
                printer.print(result);
            }
        }
    }
}
