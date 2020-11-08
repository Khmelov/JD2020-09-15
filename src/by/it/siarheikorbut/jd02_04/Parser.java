package by.it.siarheikorbut.jd02_04;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private final Map<String, Integer> priority = new HashMap<>();

    {
        priority.put("(", -1);
        priority.put(")", -1);
        priority.put("=", 0);
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("*", 2);
        priority.put("/", 2);
    }

    Var calc(String expression) throws CalcException {
        expression = expression.replace(" ", "").trim();
        List<String> operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATIONS))
        );
        Pattern patternOperation = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcherOperation = patternOperation.matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcherOperation.find()) {
            operations.add(matcherOperation.group());
        }
        while (operations.size() > 0) {
            int index = getIndexOperation(operations);
            boolean brackets = false;
            if (index != 0 && operations.get(index - 1).equals("(") && operations.get(index + 1).equals(")")) {
                int numberBracketsInEnd = 0;
                for (int i = operations.size() - 1; i >= 0; i--) {
                    if (operations.get(i).equals(")")) numberBracketsInEnd++;
                    else break;
                }
                operations.remove(index + 1);
                if (index < operations.size() - numberBracketsInEnd) operands.remove(index + 2);
                brackets = true;
            }
            String removeOperation = operations.remove(index);
            String leftOperand = operands.remove(index);
            String rightOperand = operands.remove(index);
            Var result = calcOneOperation(leftOperand, removeOperation, rightOperand);
            operands.add(index, result.toString());
            if (brackets) {
                operations.remove(index - 1);
                operands.remove(index - 1);
            }
        }
        return Var.createVar(operands.get(0));
    }

    private Var calcOneOperation(String leftOperand, String operation, String rightOperand) throws CalcException {
        Var right = Var.createVar(rightOperand);
        if (operation.contains("=")) {
            return Var.saveVar(leftOperand, right);
        }
        Var left = Var.createVar(leftOperand);

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
        throw new CalcException("неизвестная операция: " + leftOperand + operation + rightOperand);
    }

    private int getIndexOperation(List<String> operations) {
        int index = -1;
        int priorityCurrent = -1;
        for (int i = 0; i < operations.size(); i++) {
            Integer priorityTemp = priority.get(operations.get(i));
            if (i != 0 && operations.get(i - 1).equals("(") && operations.get(i + 1).equals(")")) {
                return index = i;
            }
            if (priorityTemp > priorityCurrent) {
                priorityCurrent = priorityTemp;
                index = i;
            }
        }
        return index;
    }
}