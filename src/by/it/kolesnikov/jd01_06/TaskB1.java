package by.it.kolesnikov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
            while (matcher.find()){
                String word = matcher.group();
                 if (checkWord(word))
                     System.out.println(word);
            }
    }
    private static final String votes = "УЕЭОАЫЯИЮЁуеэоаыяиюё";

    private static boolean checkWord(String word){
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);
        boolean firstOk=votes.indexOf(first)<0;
        boolean lastOk=votes.indexOf(last)>=0;
        return firstOk && lastOk;
    }
}
