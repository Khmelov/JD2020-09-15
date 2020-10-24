package by.it.sheremet.jd01_06;

public class TaskB2 {
   public static void main(String[] args) {
      String text=Poem.text;
      text=text.replaceAll("\\.\\.\\.","");
     // System.out.println(text);
      String [] sent=text.split("[.!?]");


        for (int i = 0; i < sent.length; i++) {
           sent[i]=sent[i].replaceAll("[^А-ЯЁа-яё]+"," ");
           sent[i]=sent[i].trim();
           //System.out.println(sent[i]);
       }
       for (int i = sent.length-1; i > 0; i--) {
           for (int j = 0; j <sent.length-1 ; j++) {
                String save;
           if (sent[j].length()>sent[j+1].length()) {

               save=sent[j];
               sent[j]=sent[j+1];
               sent[j+1]=save;
           }
           }
       }
       for (int i = 0; i < sent.length; i++) {
          System.out.print(sent[i]+"\n");
       }

   }
}
