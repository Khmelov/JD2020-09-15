package by.it.kolesnikov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String [] words={};
    private static int [] count = {};
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String word = matcher.group();
            processOneWord(word);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]+"="+count[i]);
        }
    }
    private static void processOneWord(String word){
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word))
                count[i]++;
        }
        words=Arrays.copyOf(words,words.length+1);
        count=Arrays.copyOf(count,count.length+1);
        words[words.length-1]=word;
        count[count.length-1]=1;
    }
}