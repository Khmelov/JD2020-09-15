package by.it.frolova.jd01_06;

/* Вывести через \n все предложения текста в порядке возрастания количества символов
(!) в каждом из них. В предложениях нужно сначала заменить все небуквенные символы и их
последовательности на один пробел и выполнить trim() для каждого предложения.*/

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    private static String[] sentences = {};

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("([^//.//.]+(.+[а-яёА-ЯЁ])?[^.!?]+)[//.!?]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String sentence = matcher.group();
            sentence = sentence.replaceAll("[^а-яёА-ЯЁ]+", " ");
            sentence = sentence.trim();
            //System.out.println(sentence);
            sentencesFillIn(sentence);
        }
        sentencesSort(sentences);
        for (int i = 0; i < sentences.length; i++) {
            System.out.print(sentences[i] + "\n");
        }
    }

    private static void sentencesFillIn(String sentence) {
        sentences = Arrays.copyOf(sentences, sentences.length + 1);
        sentences[sentences.length - 1] = sentence;
    }

    private static void sentencesSort(String[] sentences) {
        boolean swap;
        int lastElem = sentences.length - 1;
        do {
            swap = false;
            for (int i = 0; i < lastElem; i++) {
                if (sentences[i].length() > sentences[i + 1].length()) {
                    String temp = sentences[i];
                    sentences[i] = sentences[i + 1];
                    sentences[i + 1] = temp;
                    swap = true;
                }
            }
            lastElem--;

        } while (swap);
    }

}

