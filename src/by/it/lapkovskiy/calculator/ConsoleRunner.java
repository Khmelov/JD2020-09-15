package by.it.lapkovskiy.calculator;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner  {
    public static Locale locale;
    public static ResMan rasMan;

    public static void main(String[] args) {
        locale =new Locale("en","US");
        rasMan =ResMan.INSTANCE;

        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();

        for (; ;) {
            String expression = sc.nextLine();
            if (expression.equals("end")) break;
            if(expression.equals("ru") || expression.equals("be")|| expression.equals("en"))
            {
                switch (expression){
                    case "ru":
                        locale  = new Locale("ru","RU");
                        break;
                    case "be":
                        locale  = new Locale("be","BY");
                        break;
                    default:
                        locale = new Locale("en","US");

                }
                rasMan.setLocale(locale);
            }
            else try {
                if(parser.checkBracket(expression)){
                Var result = parser.calc(expression);
                printer.print(result);
                }
            } catch (CalcException e) {
                String message = e.getMessage();
                System.out.println(message);
            }
        }
    }
}
