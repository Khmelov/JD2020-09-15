package by.it.frolova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (check(word)) {
                System.out.println(word);
            }

        }
    }

    private static final String vowels = "ауоыиэяюёеАУОЫИЭЯЮЁЕ";

    private static boolean check(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        boolean firstOk = vowels.indexOf(first) < 0;
        boolean lastOk = vowels.indexOf(last) >= 0;
        return firstOk && lastOk;
    }
}
