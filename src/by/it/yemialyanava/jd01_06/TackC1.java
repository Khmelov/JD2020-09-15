package by.it.yemialyanava.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TackC1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern p = Pattern.compile("(\\n)");
        String[] array = p.split(sb.toString());
        int i = 0;
        int maxLength = array[i].length();
        for (i = 0; i < array.length; i++) {
            if (array[i].length() > maxLength) {
                maxLength = array[i].length();
            }
        }
        System.out.println(maxLength);

        for (int j = 0; j < array.length; j++) {
          while (array[j].length() < maxLength) {
                Pattern pattern = Pattern.compile(" +");
                Matcher matcher = pattern.matcher(array[j]);
                StringBuilder newLine = new StringBuilder(array[j]);
                while (matcher.find()) {
                    int start = matcher.start();
                    if (newLine.length()<maxLength) {
                        newLine.append(" ", start, start+1);
                        //newLine.replace(start, "  ");
                    }
                }
              array[j] = newLine.toString();
          }
        }
        System.out.println(Arrays.toString(array));

    }

}
