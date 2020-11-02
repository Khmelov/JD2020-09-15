package by.it.hutnik.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) {
        String[] maker = expression.split(Patterns.OPERATION, 2);
        if (maker.length != 2){
            return null;
        }
        Var start = Var.createVar(maker[0]);
        Var finish = Var.createVar(maker[1]);
        if (start == null || finish == null)
            return null;
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+": return start.add(finish);
                case "-": return start.sub(finish);
                case "*": return start.mul(finish);
                case "/": return start.div(finish);
                default: return null;
            }
        }
        return null;
    }
}

