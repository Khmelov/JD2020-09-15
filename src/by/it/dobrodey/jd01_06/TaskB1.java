package by.it.dobrodey.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    /**
     *  TaskB1. Вывести в консоль все слова текста, начинающихся согласной и заканчивающихся
     *  гласной буквой (нужно сделать для проверки этого условия приватный метод без regex).
     */

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (checkWord(word)){
                System.out.println(word);
            }
        }
    }

    private static final String votes="уеэоаыяиюёУЕЭОАЫЯИЮЁ";

    private static boolean checkWord(String word) {
        char last = word.charAt(word.length() - 1);
        boolean firstOk=votes.indexOf(word.charAt(0))<0;
        boolean lastOk=votes.indexOf(last)>=0;
        return firstOk && lastOk;
    }
}




