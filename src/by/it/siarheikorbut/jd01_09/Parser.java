package by.it.siarheikorbut.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1C-wHpUcHtxb-Qq0lfyExNQsYeKr3yIPh/view?usp=sharing">Задание JD01_09</a>
 */

class Parser {
    Var calc(String expression) {
        String[] parts = expression.split(Patterns.OPERATIONS, 2);
        if (parts.length != 2) {
            //TODO expression
            return null;
        }
        Var left = Var.createVar(parts[0]);
        Var right = Var.createVar(parts[1]);
        if (left == null || right == null) {
            return null;
        }

        Pattern patternOperation = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcherOperation = patternOperation.matcher(expression);
        if (matcherOperation.find()) {
            String operation = matcherOperation.group();
            return switch (operation) {
                case "+" -> left.add(right);
                case "-" -> left.sub(right);
                case "*" -> left.mul(right);
                case "/" -> left.div(right);
                default -> null;
            };
        }
        return null;
    }
}