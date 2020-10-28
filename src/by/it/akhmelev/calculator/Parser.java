package by.it.akhmelev.calculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
        //2*2 -> scalar==4
        expression.replaceAll("\\s+", "");
        List<String> operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION))
        );
        List<String> operations = new ArrayList<>();

        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (!operations.isEmpty()) {
            int index = getIndex(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var res = oneCalc(left, operation, right);
            operands.add(index, res.toString());
        }
        return Var.createVar(operands.get(0));

    }

    private Var oneCalc(String strLeft, String operation, String strRight) throws CalcException {
        Var right = Var.createVar(strRight);
        if (operation.equals("=")) {
            return Var.save(strLeft, right);
        }
        Var left = Var.createVar(strLeft);

        switch (operation) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }
        throw new CalcException("buu!!");
    }

    private int getIndex(List<String> operations) {
        int index = -1;
        int pr = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            if (PR.get(op) > pr) {
                index = i;
                pr = PR.get(op);
            }
        }
        return index;
    }

    private static final Map<String, Integer> PR = new HashMap<>();

    static {
        PR.put("=", 0);
        PR.put("+", 1);
        PR.put("-", 1);
        PR.put("*", 2);
        PR.put("/", 2);
    }

}
