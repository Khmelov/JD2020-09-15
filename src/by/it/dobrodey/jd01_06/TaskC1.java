package by.it.dobrodey.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    /**
     * TaskC1. Отформатировать исходный текст с выравниванием по обоим краям. Для этого
     * добавить дополнительные пробелы между словами, так чтобы ширина строк стала равной, а
     * число пробелов между словами отличалось не более чем на единицу внутри каждой строки,
     * причем на единицу большие последовательности пробелов должны идти с начала строки.
     */
    public static void main(String[] args) {
        String text = Poem.text;
        String[] line = text.split("\\n+");
        int maxLengh = Integer.MIN_VALUE;
        for (int i = 0; i < line.length; i++) {
            if (maxLengh < line[i].length()) {
                maxLengh = line[i].length();
            }
        }
        //System.out.println(maxLengh);
        for (int i = 0; i < line.length; i++) {
            newLine(line[i], maxLengh);
        }

    }
    private static void newLine(String line, int maxLengh) {
        StringBuilder stroka = new StringBuilder(line);

        int poz = 0;
        while (stroka.length() < maxLengh) {
            int space = stroka.indexOf(" ", poz);
            if (space < 0) {
                poz = 0;
                continue;}
        stroka.insert(space+1, " ");
        poz = space+2;
        }
        System.out.println(stroka);

    }


}

