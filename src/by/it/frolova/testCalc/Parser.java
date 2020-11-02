package by.it.frolova.testCalc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static Lang manager = Lang.INSTANCE;
    private final Map<String, Var> varMap;
    private final VarCreator varCreator;

    public Parser() {
        varMap = new HashMap<>();
        varCreator = new VarCreator(varMap);
    }

    private Var save(String name, Var value) {
        varMap.put(name, value);
        return value;
    }

    Var calc(String expression) throws CalcExceptions {
        String expr = expression.replaceAll("\\s+", "");
        return calcExpr(expr);
    }

    private Var calcExpr(String expression) throws CalcExceptions {
        if (!Pattern.compile(Patterns.PARENTHESES_REGEX).matcher(expression).matches()) {
            return calcSimpleExpr(expression);
        } else {
            Matcher matcher = Pattern.compile(Patterns.SINGLE_PARENTHESES_REGEX).matcher(expression);
            if (matcher.find()) {
                String group = matcher.group();
                group = group.substring(1, group.length() - 1);
                String value = calcSimpleExpr(group).toString();
                expression = matcher.replaceFirst(value);
                System.out.println(expression);
            }
            return calcExpr(expression);
        }
    }

    private Var calcSimpleExpr(String expression) throws CalcExceptions {

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Pattern patterns = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = patterns.matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }

        while (!operations.isEmpty()) {
            int index = getIndex(operations);
            String operation = operations.remove(index);
            String leftOperand = operands.remove(index);
            String rightOperand = operands.remove(index);
            Var interResult = calcValue(leftOperand, operation, rightOperand);
            operands.add(index, interResult.toString());
        }
        return varCreator.createVar(operands.get(0));
    }

    private int getIndex(List<String> operations) {
        int index = -1;
        int priority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (PRIORITY.get(operation) > priority) {
                index = i;
                priority = PRIORITY.get(operation);
            }
        }
        return index;
    }

    private Var calcValue(String leftOperand, String operation, String rightOperand) throws CalcExceptions {
        Var right = varCreator.createVar(rightOperand);
        if (operation.equals("=")) {
            return save(leftOperand, right);
        }

        Var left = varCreator.createVar(leftOperand);

        switch (operation) {
            case "-":
                return left.sub(right);
            case "+":
                return left.add(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }
        throw new CalcExceptions("hope, that never occurs");
    }

    private static final Map<String, Integer> PRIORITY = new HashMap<>();

    static {
        PRIORITY.put("=", 0);
        PRIORITY.put("+", 1);
        PRIORITY.put("-", 1);
        PRIORITY.put("*", 2);
        PRIORITY.put("/", 2);
    }
}

