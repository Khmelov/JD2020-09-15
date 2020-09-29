package by.it.fedorinhyk.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] counters = new int[0];

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            int p=OneWord(word);
            if (p>=0){
                counters[p]++;
            }
            else {
                int last=words.length;
                words= Arrays.copyOf(words, last+1);
                words[last]=word;
                counters=Arrays.copyOf(counters, last+1);
                counters[last]=1;
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]+"="+counters[i]);
        }
    }

    private static int OneWord(String word) {
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i]))
                return i;
            }
            return -1;
        }

}


