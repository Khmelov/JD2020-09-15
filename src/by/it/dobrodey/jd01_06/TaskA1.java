package by.it.dobrodey.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        System.out.println(Poem.text);
        Pattern pt = Pattern.compile("[а-яёА-ЯЁ]{4,}");
        Matcher mt = pt.matcher(text);
        while(mt.find()){
            String word = mt.group();
            System.out.println(word+" "+mt.start());
            int pos = mt.start();
            text.setCharAt(pos+3,'#');
            if(mt.end()-mt.start()>6)
            text.setCharAt(pos+6,'#');



        }
        System.out.println(text);
}}
