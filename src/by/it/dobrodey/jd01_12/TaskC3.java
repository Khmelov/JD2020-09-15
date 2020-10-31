package by.it.dobrodey.jd01_12;
/*
TaskC3. В консоль вводится строка, состоящая из выражений и символов «(», «)», «[», «]», «{», «}».
 Проверьте и выведите в консоль корректность расстановки скобок (true или false) с помощью коллекций.
 */


import java.util.*;


public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char [] arr = input.toCharArray();


        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put('[', ']');
        bracketsMap.put('(', ')');
        bracketsMap.put('{', '}');
        System.out.println("bracketsPairs="+bracketsMap);

        Set<Character> openBrackets = bracketsMap.keySet();

        Set<Character> brackets = new HashSet<>();
        brackets.addAll(openBrackets);
        brackets.addAll(bracketsMap.values());
        System.out.println("brackets"+brackets);

        List<Character> check = new LinkedList<>();
        boolean result = true;

        for (char symbol : arr) {
            if (brackets.contains(symbol)) {
                if (openBrackets.contains(symbol)) {
                    check.add(symbol);
                    //    System.out.println(check);
                } else {
                    if (check.size() > 0) {
                        char lastOpen = check.get(check.size() - 1);
                        char bracketClose = bracketsMap.get(lastOpen);
                        System.out.println(bracketClose);
                        if (bracketClose == symbol) {
                            check.remove(check.size() - 1);
                        } else {
                            result = false;
                            break;
                        }
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }
        if (check.size()>0){
            result = false;
        }
        System.out.println(result);
    }
}
