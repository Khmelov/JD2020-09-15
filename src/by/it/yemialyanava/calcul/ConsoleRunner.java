package by.it.yemialyanava.calcul;

import java.util.Scanner;

public class ConsoleRunner {
    public static Lang manager = Lang.UK;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            Var.load();
        } catch (CalcException e) {
            System.out.println(ConsoleRunner.manager.get(MessagesNames.MISSING_FILE));
        }
        for (; ; ) {
            String expression = scan.nextLine();
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
            if (expression.equals("sortvar")){
                printer.sortVar(Var.getVarMap());
                continue;
            }
                try {
                    Var result = parser.calcWithBrackets(expression);
                    printer.print(result);
                } catch (CalcException e) {
                    String message = e.getMessage();
                    System.out.println(message);
                }
            }
        }
    }
}
