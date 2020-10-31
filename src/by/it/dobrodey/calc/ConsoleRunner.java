package by.it.dobrodey.calc;



import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static Lang manager;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ведите ru/be/en");
        Lang manager1 = Lang.INS;
        Locale locale = Locale.getDefault();
        manager1.setLocale(locale);
        manager=manager1;

        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            Var.load();
        } catch (CalcException e) {
            System.out.println("File not found");
        }
        for (; ; ) {
            String expression = sc.nextLine();

            if (Lang.lang.containsKey(expression)) {
                System.out.println(expression+"  "+Lang.lang.get(expression));
                locale = new Locale(expression, Lang.lang.get(expression));
                manager.setLocale(locale);
                System.out.println(manager.get(Message.OPERASSION));
                System.out.println(manager.get(Message.input));
                continue;
            }

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
            } catch (CalcException e) {
                String message = e.getMessage();
                System.out.println(message);
            }
        }
    }
}

