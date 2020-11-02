package by.it.kolesnikov.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner sc=new Scanner(System.in);
        for (;;){
            String expression =  sc.nextLine();
            if (expression.equals("end")) break;
            Var result = parser.calc(expression);
            printer.print(result);
        }
    }
}
