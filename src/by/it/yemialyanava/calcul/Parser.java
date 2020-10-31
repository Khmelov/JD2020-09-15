package by.it.yemialyanava.calcul;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calcWithBrackets(String expression) throws CalcException {
        Map.Entry<Integer, Integer> expresionInBreacktsIndexes = findExpressionInBreackets(expression);
        Var result = null;
        while(expresionInBreacktsIndexes!=null){
            String expresionInBreackts = expression.substring(expresionInBreacktsIndexes.getKey()+ 1,expresionInBreacktsIndexes.getValue());
            Var calculatedExpression = calc(expresionInBreackts);
            String newExpression = expression.substring(0,expresionInBreacktsIndexes.getKey())
                    + calculatedExpression.toString() +  expression.substring(expresionInBreacktsIndexes.getValue()+1);
            expression = newExpression;
            expresionInBreacktsIndexes = findExpressionInBreackets(expression);
        }
        return  calc(expression);
    }

    private Map.Entry<Integer, Integer> findExpressionInBreackets(String expression) {
        char [] charArray = expression.toCharArray();
        int start = -1;
        int finish = -1;
        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            if(currentChar == '('){
                start = i;
            } else if (currentChar == ')'){
                finish = i;
                return new AbstractMap.SimpleEntry<Integer, Integer>(start, finish);
            }
        }
        return null;
    }


    Var calc(String expression) throws CalcException {
        //2*2  scalar=4
        //if (expression.isEmpty() == true) {
          //  throw new CalcException("expression is empty");
        //}
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

        switch (operation){
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
            }
            throw new CalcException("buzzzz");
    }
    private int getIndex(List<String> operations) {
        int index = -1;
        int pr = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            if(PR.get(op) > pr){
                index = i;
                pr = PR.get(op);
            }
        }
        return index;
    }

    private static final Map<String, Integer> PR = new HashMap<>();
    static {
        PR.put("=",0);
        PR.put("+",1);
        PR.put("-",1);
        PR.put("*",2);
        PR.put("/",2);
    }

}
