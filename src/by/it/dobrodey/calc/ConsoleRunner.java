package by.it.dobrodey.calc;




import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            Var.load();
        } catch (CalcException e) {
            System.out.println("File not found");
        }
        for (; ; ) {
            String expression = sc.nextLine();
            if (expression.equals("end")) break;
            if (expression.equals("printvar")) {
                printer.printvar(Var.getVarMap());
                continue;
            }
            if (expression.equals("sortvar")) {
                printer.printsort(Var.getVarMap());
                continue;
            }
            try {
                Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException e ) {
                String message = e.getMessage();
                System.out.println(message);
            }

        }
    }
}
