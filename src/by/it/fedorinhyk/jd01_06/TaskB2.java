package by.it.fedorinhyk.jd01_06;

public class TaskB2 {
        public static void main(String[] args) {
            String poem = Poem.text;
            poem = poem.replaceAll("(\\.\\.\\.)", "");
            String[] sentences = poem.split("[.!?]");
            for (int i =0; i<sentences.length; i++) {
                sentences[i] = sentences[i].replaceAll("[^а-яА-ЯёЁ]+", " ")
                        .replaceAll("\\p{Punct}\\p{Blank}", "")
                        .replaceAll("\n", " ");
                sentences[i] = sentences[i].trim();
            }
            for (int i=sentences.length-1; i>0;i--){
                for (int j = 0; j<sentences.length-1;j++){
                    String temp;
                    if (sentences[j].length()>sentences[j+1].length()){
                        temp = sentences[j];
                        sentences[j] = sentences[j+1];
                        sentences[j+1] = temp;
                    }
                }
            }
            for (int i =0; i<sentences.length; i++) {
                System.out.print(sentences[i]+"\n");
            }
        }
}
