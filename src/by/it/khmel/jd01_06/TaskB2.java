package by.it.khmel.jd01_06;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    private static int ArrayList;


    // private static final String signs=(",:;");

    //  private static boolean check(String word){


    //  }

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[,:;\\-\\n]");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            int pos = matcher.start();
            text.setCharAt(pos, ' ');
        }


        //System.out.println(signs);

        String newtext = text.toString();
        String[] sentences = newtext.split("[\\.!]");
         // int [] index0 = new int[5];
        int index0=0;
        int k=0;
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].trim();
            System.out.println(sentences[i]+   sentences[i].length());
        }


     //   for (int i = 0; i < index0.length; i++) {
     //       System.out.println(index0[i]);
        }


    }




