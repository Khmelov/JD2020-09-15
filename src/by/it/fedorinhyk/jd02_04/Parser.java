package by.it.fedorinhyk.jd02_04;

import by.it.akhmelev.jd01_11.ListA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) throws CalcException {
        expression.replaceAll("\\s+", "");
        ArrayList<String> members = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        ArrayList<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);

        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (!operations.isEmpty()) {
            int Index = getIndex(operations);
            String operation = operations.remove(Index);
            String left = members.remove(Index);
            String right = members.remove(Index);
            Var result = oneCalc(left, operation, right);
            members.add(Index, result.toString());
        }
        return Var.createVar(members.get(0));
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
        throw new CalcException("ERROR");
    }


    private int getIndex(ArrayList<String> operations) {
        int index=-1;
        int cashe=-1;
        for (int i = 0; i < operations.size(); i++) {
            String str=operations.get(i);
            if (CASHE.get(str)>cashe){
                index=i;
                cashe=CASHE.get(str);
            }
        }
        return index;
    }
    private static final Map<String,Integer> CASHE =new HashMap<>();
    static {
        CASHE.put("=",0);
        CASHE.put("+",1);
        CASHE.put("-",1);
        CASHE.put("*",2);
        CASHE.put("/",2);
    }
}
