package by.it.siarheikorbut.jd01_13;

import java.util.HashMap;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1iSvqfSRLpPRwyPEKEaOLIa3-qSPVhXv5/view?usp=sharing">Задание JD01_13</a>
 */

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
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
}