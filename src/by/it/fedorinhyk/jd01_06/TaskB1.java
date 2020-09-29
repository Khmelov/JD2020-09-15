package by.it.fedorinhyk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static  String[] words=new String[0];
    private static  String[] counters=new String[0];
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String word= matcher.group();
            if (CheckWord(word)){
                System.out.println(word);
            }
        }
    }
    private static final String votes="аяоёэеыиуюАЯОЁЭЕЫИУЮ";

    private static boolean CheckWord(String word) {
        char first=word.charAt(0);
        char last=word.charAt(word.length()-1);
        boolean firstok=votes.indexOf(first)<0;
        boolean lastok=votes.indexOf(last)>=0;
        return firstok && lastok;
    }
}

