package by.it.kolesnikov.jd02_04;

import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static final Map<String, Integer> prior = new HashMap<>();
    static {
        prior.put("+", 1);
        prior.put("-", 1);
        prior.put("*", 2);
        prior.put("/", 2);
    }

    Var calc(String expression){
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        expression=expression.replace(" ", "");
        Matcher match = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (match.find()){
            operations.add(match.group());
        }
        while (!operations.isEmpty()) {
            int index = getCurrentIndexOperation(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = oneOperation(left, operation, right);
            operands.add(index,result.toString());
        }
return Var.createVar(operands.get(0));
    }

    private Var oneOperation(String strLeft, String operation, String strRight) {
        Var right = Var.createVar(strRight);
        if (operation.equals("=")) {
            return right;
        }
        Var left = Var.createVar(strLeft);
            switch(operation){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        return right;
    }

    private int getCurrentIndexOperation(List<String> operations){
        int index=-1;
        int pr=-1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            if(prior.get(op)>pr) {
                pr = prior.get(op);
                index = i;
            }
        }
        return index;
    }
}
