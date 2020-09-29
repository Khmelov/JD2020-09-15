package by.it.lapkovskiy.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static final  String votes ="уеыаоэяиюёЁУЕЫАОЭЯИЮ";
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if(checkWord(word)){
                System.out.println(word);
            }
        }
    }

    private static boolean checkWord(String word) {
        char last = word.charAt((word.length()-1));
        boolean firstOK =votes.indexOf(word.charAt(0))<0;
        boolean lastOK = votes.indexOf(last)>=0;
        return firstOK && lastOK;
    }
}
