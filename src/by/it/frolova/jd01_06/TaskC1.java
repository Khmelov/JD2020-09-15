package by.it.frolova.jd01_06;

/* Отформатировать исходный текст с выравниванием по обоим краям. Для этого
добавить дополнительные пробелы между словами, так чтобы ширина строк стала равной, а
число пробелов между словами отличалось не более чем на единицу внутри каждой строки,
причем на единицу большие последовательности пробелов должны идти с начала строки.*/

public class TaskC1 {

    public static void main(String[] args) {
        String[] lines = Poem.text.split("\n");
        int bigLine = findBiggest(lines);

        for (int i = 0; i < lines.length; i++) {
            StringBuilder line = new StringBuilder(lines[i]);
            int position = 0;
            int count = 0;
            while (line.length() < bigLine) {
                position = line.indexOf(" ", position);
                if (position < 0) {
                    position = 0;
                    count++;
                    continue;
                }
                line.insert(position, " ");
                position += count + 2;
            }
            System.out.println(line);
        }
    }

    private static int findBiggest(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length - 1; i++) {
            if (sentences[i].length() > max) {
                max = sentences[i].length();
            }
        }
        return max;
    }
}
