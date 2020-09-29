package by.it.yemialyanava.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern p = Pattern.compile("(\\s|,|-|:)");
        Matcher matcher = p.matcher(Poem.text);
        while (matcher.find()){
            int start = matcher.start();
            sb.setCharAt(start,' ');
        }
        Pattern pat = Pattern.compile("(\\.{3})");
        Matcher match = pat.matcher(Poem.text);
        while (match.find()){
            int starter = match.start();
            int finish = match.end();
            sb.replace(starter, finish," ");
        }
        Pattern pattern = Pattern.compile("(\\.|\\?|!)");
        String[] array = pattern.split(sb.toString());
        String[] trimledArray = new String[array.length];
        int j =0;
        for (int i = 0; i < array.length; i++) {
            String newstr = array[i].trim().replaceAll(" +", " ");
            if (!(newstr.equals(""))) {
                trimledArray[j] = newstr;
                j++;
            }
        }
        trimledArray = Arrays.copyOfRange(trimledArray, 0, j);

        for (int k=0; k < trimledArray.length; k++) {
            int minLength = trimledArray[k].length();
            int minIndex = k;
            for (int l = k; l <  trimledArray.length; l++) {
                if (trimledArray[l].length() < minLength){
                    minLength = trimledArray[l].length();
                    minIndex = l;
                }
            }
            String temp = trimledArray[k];
            trimledArray[k] = trimledArray[minIndex];
            trimledArray[minIndex] = temp;
        }

        for (int x = 0; x< trimledArray.length; x++){
            System.out.print(trimledArray[x] + "\n");
        }
    }
}
