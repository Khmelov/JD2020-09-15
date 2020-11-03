package by.it.lapkovskiy.calculator;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner  {
    public static Locale locale;
    public static ResMan rasMan;

    public static void main(String[] args) {
        locale =new Locale("en","US");
        rasMan =ResMan.INSTANCE;

        Report shortReport = new Report();
        Report detailedReport = new Report();

        shortReport.name = ShortReport.getName();
        shortReport.startTime = ShortReport.getTime();

        detailedReport.name = DetailedReport.getName();
        detailedReport.startTime = DetailedReport.getTime();

        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();

        Logger logger = Logger.GET;

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
                logger.log(expression);
                shortReport.operations.append(expression+"\n");
                detailedReport.operations.append(expression+"\n");

                if(parser.checkBracket(expression)){
                Var result = parser.calc(expression);
                printer.print(result);

                logger.log(result.toString());

                shortReport.operations.append(result+"\n");
                detailedReport.operations.append(result+"\n");
                }
            } catch (CalcException e) {
                String message = e.getMessage();

                shortReport.addMessage(ShortReport.getOperation(message));
                detailedReport.addMessage(DetailedReport.getOperation(message));

                logger.log(rasMan.get(Message.error) +": "+message);
                System.out.println(rasMan.get(Message.error) +": "+message);
            }
        }
        shortReport.endTime= ShortReport.getTime();
        detailedReport.endTime = DetailedReport.getTime();
        shortReport.EndReport();
        detailedReport.EndReport();
    }
}
