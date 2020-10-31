package by.it.lapkovskiy.calculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
          expression.replaceAll("\\s+", "");

          while (isHaveBracket(expression)){
              String line = expression.substring(findFirstBracket(expression)+1,findBracket(expression));
              String line2 = expression.substring(findFirstBracket(expression),findBracket(expression)+1);

              expression= expression.replace(line2,calc(line).toString());
          }

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

    boolean checkBracket(String line) throws CalcException {
        String newLine= line.replaceAll("[^{}\\[\\]{}()]+","");
        Stack<Character> stack = new Stack<>();
        char[] brackets = newLine.toCharArray();
        int i = 0;
        if(line.equals(newLine))
        while (true) {
            if (brackets[i] == '{' || brackets[i] == '(' || brackets[i] == '[') stack.push(brackets[i]);
            else {
                if (stack.isEmpty()) {
                    System.out.println("Bracket Error excess:"+(Character)brackets[i]+" in "+i);
                    return false;
                }
                if (brackets[i] == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (brackets[i] == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (brackets[i] == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    System.out.println("Bracket Error excess:"+(Character)brackets[i]+" in "+i);
                    return false;
                }
            }
            i++;
            if (i == brackets.length) {
                if(stack.isEmpty()) return true;
                else{
                    char b = stack.pop();
                    switch (b){
                        case '{' : b='}';
                            break;
                        case '(' : b=')';
                            break;
                        case '[' : b=']';
                            break;
                    }
                    System.out.println("Bracket Error excess:"+b);
                    return false;
                }
            }
        }
        else return true;
    }
    boolean isHaveBracket(String line){
        String newLine = line.replaceAll("[()]+","");
        return !line.equals(newLine);
    }
    int findFirstBracket(String line){
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='(') return i;
        }
        return -1;
    }
    int findBracket(String line){
        char[] chars = line.toCharArray();
        int left=0;
        int right=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='(') {
                left++;
            }
            if(chars[i]==')'){
                right++;
            }
            if(left>0 && left==right) return i;
        }
        return -1;
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
