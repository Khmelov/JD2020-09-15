package by.it.fedorinhyk.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    CreateVar calc(String expression) throws CalcException{
        expression.replaceAll("\\s+","");

        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length==1) return CreateVar.createVar(parts[0]);

        CreateVar right= CreateVar.createVar(parts[1]);
        if (expression.contains("=")){
            return CreateVar.save(parts[0],right);
        }

        CreateVar left= CreateVar.createVar(parts[0]);
        if (right==null || left==null) return null;

        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expression);
        if (matcherOperation.find()){
            String operation = matcherOperation.group();
            switch (operation) {
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        }
        return null;
    }
}
