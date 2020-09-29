package by.it.dobrodey.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    /**
     * TaskB2. Вывести через \n все предложения текста в порядке возрастания количества символов
     * (!) в каждом из них. В предложениях нужно сначала заменить все небуквенные символы и их
     * последовательности на один пробел и выполнить trim() для каждого предложения.
     */

    private static String[] uniqueSentence = {};
    private static int[] counters = {};


    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pt = Pattern.compile("([^.!?]+(.{2,}[а-яё])?[^.!?]+)[.!?]");
        Matcher mt = pt.matcher(text);

        while (mt.find()) {
            String sentence = mt.group();
            sentence = sentence.replaceAll("\n"," ");
            sentence = sentence.replaceAll("\\s*[.,;:?!-]+\\s*", " ");

            sentence = sentence.trim();
            lengthSentence(sentence);
        }

        Arrays.sort(counters);

        for (int i = 0; i < counters.length; i++) {
            for (int i1 = 0; i1 < uniqueSentence.length; i1++) {

                if (counters[i]==uniqueSentence[i1].length()){
                    System.out.printf(uniqueSentence[i1]+"\n");
                    uniqueSentence[i1] = "a";i1 = uniqueSentence.length-1;
                }
            }

            }
    }

    private static void lengthSentence(String sentence) {
        counters = Arrays.copyOf(counters, counters.length + 1);
        counters[counters.length - 1] = sentence.length();
        uniqueSentence = Arrays.copyOf(uniqueSentence, uniqueSentence.length + 1);
        uniqueSentence[uniqueSentence.length - 1] = sentence;

    }


}








