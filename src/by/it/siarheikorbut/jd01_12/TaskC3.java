package by.it.siarheikorbut.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Ryp9d5F9tODmNRVG6-eStmPl4TFplV3-/view?usp=sharing">Задание JD01_12</a>
 */

public class TaskC3 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        Pattern p1=Pattern.compile("[{}()\\[\\]]");
        Matcher m1= p1.matcher(s);
        while (m1.find()){
            arrayList.add(m1.group());
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).equals("(")&&arrayList.get(i+1).equals(")")){
                arrayList.add(i+1,0);
            }
        }
        boolean result= bracketsRightOrNot(arrayList);

        System.out.println(result);
    }

    private static boolean bracketsRightOrNot(ArrayList<?> arrayList) {
        while (arrayList.contains(0)) {
            int i1= arrayList.indexOf(0);
            if (i1==0&&arrayList.size()==1) return true;
            if (i1 == 0) return false;
            if (arrayList.get(i1-1).equals("(")&& arrayList.get(i1+1).equals(")")) {
                arrayList.remove(i1+1);
                arrayList.remove(i1-1);
            }
            else if (arrayList.get(i1-1).equals("[")&& arrayList.get(i1+1).equals("]")) {
                arrayList.remove(i1+1);
                arrayList.remove(i1-1);
            }
            else if (arrayList.get(i1-1).equals("{")&& arrayList.get(i1+1).equals("}")) {
                arrayList.remove(i1+1);
                arrayList.remove(i1-1);
            }
            else if(arrayList.size()==1&& arrayList.get(0).equals(0)) return true;
            else arrayList.remove(i1);
        }
        return false;
    }
}