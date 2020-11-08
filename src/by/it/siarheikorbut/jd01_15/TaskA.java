package by.it.siarheikorbut.jd01_15;

import java.io.*;
import java.util.Random;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1fFm7gNQmkZDkGzNKxCvW1mcL5un0ceFg/view?usp=sharing">Задание JD01_15</a>
 */

public class TaskA {
    public static void main(String[] args) {
        int[][] array = new int[6][4];
        Random r = new Random();
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -15 + r.nextInt(31);
            }
        }
        String path = getPath() + "matrix.txt";
        try (PrintWriter writer = new PrintWriter(path)) {
            for (int[] row : array) {
                for (int i : row) {
                    writer.printf("%3d ", i);
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPath() {
        String rootProject = System.getProperty("user.dir");
        String relativePath = TaskA.class
                .getName()
                .replace(TaskA.class.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}
