package by.it.khmel.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {

        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[^а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){

            int pos=matcher.start();
            text.setCharAt(pos, '#');
            //if (matcher.end()-matcher.start()>6){
             //   text.setCharAt();
            }










            //String word=matcher.group();
            //System.out.println();
        }


    }

