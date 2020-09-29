package by.it.lapkovskiy.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class TaskC2 {
    String pText = Poem.text;

    public static void main(String[] args) {
        /*long start = System.nanoTime();
        slow("мывола выа ыва ваолрывло вылаорывло  аырвлоарыв");
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println(elapsedTime +" seconds");*/
        System.out.println(slow(Poem.text));
        System.out.println(fast(Poem.text));
    }

    static String slow(String poem) {
        String st = "";
        StringBuilder text = new StringBuilder(poem);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        int cof =0;
        while (st.length() < 100000) {
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                int pos = matcher.start();
                String word = matcher.group();
                if(random(word.length()+cof)){
                    st=st+word+" ";
                    cof=0;
                }else if(cof<1) cof++;
                else cof =0;
            }
        }
        Matcher matcher = pattern.matcher(text);
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            st+=word+" ";
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return st;
    }

    static String fast(String poem) {
        String st = "";
        StringBuilder text = new StringBuilder(poem);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        int cof = 0;
        while (st.length() < 100000) {
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                int pos = matcher.start();
                String word = matcher.group();
                if(random(word.length()+cof)){
                    st=st+word+" ";
                    cof=0;
                }else if(cof<1) cof++;
                else cof =0;
            }
        }
        Matcher matcher = pattern.matcher(text);
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            st+=word+" ";
        }
        return st;
    }

    static boolean random(int a){
        return a%2==0;
    }
}
