package by.it.frolova.testCalc;

import java.util.Scanner;

public class ConsoleRunner {
    private static final Logger logger = Logger.INSTANCE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        LangRunner langRunner = new LangRunner();
        for (; ; ) {
            String expression = sc.nextLine();
            try {
                if (expression.equals("en") || expression.equals("be") || expression.equals("ru")) {
                    langRunner.printAll(expression);
                } else if (expression.equals("end")) {
                    break;
                } else {
                    Var result = parser.calc(expression);
                    printer.print(result);
                }
            }catch (CalcExceptions e){
                String message = e.getMessage();
                System.out.println(message);
                logger.log(message);
            }
        }
    }
}
