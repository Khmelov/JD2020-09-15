package by.it.kolesnikov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder text= new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("([^.!?]+(.{2,}[а-яё])?[^.!?]+)[.!?]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String sentence = matcher.group();
            sentence = sentence.replaceAll("\n", " ");
            sentence = sentence.replaceAll("\\s*[.,;:?!-]+\\s*", " ");
            sentence=sentence.trim();
            System.out.println(sentence);
        }
    }
}
