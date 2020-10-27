package by.it.fedorinhyk.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        for (; ; ) {
            String expression = sc.nextLine();
            if (expression.equals("end")) break;
            else if (expression.equals("printvar")) {
                printer.printvar(Var.getVarMap());
                continue;
            }
            try {
                Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


