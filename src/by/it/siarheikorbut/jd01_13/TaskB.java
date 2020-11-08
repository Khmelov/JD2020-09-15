package by.it.siarheikorbut.jd01_13;

import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1iSvqfSRLpPRwyPEKEaOLIa3-qSPVhXv5/view?usp=sharing">Задание JD01_13</a>
 */

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double sum = 0;
            for (; ; ) {
                String s = sc.nextLine();
                if (s.equals("END")) {
                    break;
                }
                double v = Double.parseDouble(s);
                System.out.println(v);
                sum = sum + v;
                if (sum <= 0) {
                    throw new ArithmeticException();
                }
                double sqrt;
                sqrt = Math.sqrt(sum);
                System.out.println(sqrt);
            }
        } catch (NumberFormatException | ArithmeticException e) {
            printException(e);
        }
    }

    private static void printException(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        String nameException = e.getClass().getName();
        for (StackTraceElement element : stackTrace) {
            String methodName = element.getMethodName();
            if (methodName.equals("main")) {
                String className = element.getClassName();
                int lineNumber = element.getLineNumber();
                System.out.printf("  name: %s\n class: %s\n  line: %d", nameException, className, lineNumber);
                break;
            }
        }
    }
}