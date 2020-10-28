package by.it.siarheikorbut.jd01_09;

import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1C-wHpUcHtxb-Qq0lfyExNQsYeKr3yIPh/view?usp=sharing">Задание JD01_09 ( A, B, C )</a>
 */

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        for (; ;) {
            String line = scanner.nextLine();
            Var result = parser.calc(line);
            printer.print(result);
            if (line.equals("end")){
                break;
            }

        }
    }
}