package by.it.hutnik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String sb = Poem.text;
        sb = sb.replaceAll("\\n", " ").replaceAll("[\\.]{3,}", " ").replaceAll("[\\s]{3,}", " ");
        String[] strArr = sb.split("\\.");
        int[] numb = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            StringBuilder sbNew = new StringBuilder(strArr[i]);
            Pattern pattern = Pattern.compile("\\p{Punct}");
            Matcher matcher = pattern.matcher(sbNew);
            while (matcher.find()) {
                int pos = matcher.start();
                sbNew.setCharAt(pos, ' ');
            }
            strArr[i] = sbNew.toString().replaceAll("[\\s]{2,}", " ");
            strArr[i] = strArr[i].trim();
        }
        for (int i = numb.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (strArr[j].length() > strArr[j + 1].length()) {
                    String temp = strArr[j];
                    strArr[j] = strArr[j + 1];
                    strArr[j + 1] = temp;
                }

            }

        }
        for (int i = 0; i < strArr.length; i++) {
            System.out.println(strArr[i]);
            
        }

    }
}
