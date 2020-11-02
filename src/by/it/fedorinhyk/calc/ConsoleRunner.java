package by.it.fedorinhyk.calc;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Calendar calendar=Calendar.getInstance();
        Date moment=calendar.getTime();
        for (; ; ) {
            String expression = sc.nextLine();
            if (expression.equals("end")){
                System.out.println(moment);
                break;}
            if (expression.equals("printvar")) {
                printer.printvar(CreateVar.getVarMap());
                System.out.println(moment);
                continue;
            }
            try {
                CreateVar result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage()+moment);
            }
        }
    }
}


