package by.it.lapkovskiy.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String str = Poem.text;
        str = str.replaceAll("\\n", " ").replaceAll("[\\s]{2,}"," ");
        String[] arr = str.split("\\.+");
        int[] countArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            StringBuilder text = new StringBuilder(arr[i]);
            Pattern pattern = Pattern.compile("[\\,:;!?-]{1}");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                int pos = matcher.start();
                text.setCharAt(pos, ' ');
               // countArr[i]++;
            }
            arr[i] = text.toString().replaceAll("[\\s]{2,}"," ");
            arr[i] = arr[i].trim();

        }
        /*countArr[10] = 4;
        for (int i = countArr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (countArr[j] > countArr[j+1]) {
                    int t = countArr[j];
                    countArr[j] =countArr[j+1];
                    countArr[j+1] = t;

                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }*/

        for (int i = countArr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].length() > arr[j+1].length()) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\n");
        }
    }
}
