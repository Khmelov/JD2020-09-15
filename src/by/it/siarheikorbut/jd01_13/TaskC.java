package by.it.siarheikorbut.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1iSvqfSRLpPRwyPEKEaOLIa3-qSPVhXv5/view?usp=sharing">Задание JD01_13</a>
 */

public class TaskC {
    private static final ArrayList<Double> arrayList = new ArrayList<>();
    private static Scanner sc;
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        TaskC.sc = new Scanner(System.in);
        readData();
    }

    static void readData() throws NumberFormatException, InterruptedException {
        for (; ; ) {
            try {
                String s = TaskC.sc.nextLine();
                if (s.equals("end")) return;
                double v = Double.parseDouble(s);
                TaskC.arrayList.add(v);
            } catch (NumberFormatException e) {
                Thread.sleep(100);
                if (i < 4) {
                    for (int i1 = arrayList.size() - 1; i1 >= 0; i1--) {
                        System.out.print(arrayList.get(i1) + " ");
                    }
                    i++;
                    readData();
                } else throw new RuntimeException(e);
            }
        }
    }
}