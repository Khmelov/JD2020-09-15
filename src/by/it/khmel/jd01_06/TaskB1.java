package by.it.khmel.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static final String vowels = "аоуыэяёюиеАОУЫЭЯЁЮИЕ";


    private static boolean check(String word) {

        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        int f = vowels.indexOf(first);
        int l = vowels.indexOf(last);
        boolean a = (f < 0 && l >= 0);
        return a;
    }


    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (check(word) == true) {
                System.out.println(word);

            }
        }
    }
}

