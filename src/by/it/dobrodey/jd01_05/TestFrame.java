package by.it.dobrodey.jd01_05;

import java.awt.Dimension;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestFrame extends JFrame {

    public static void createGUI(String[][] data, String name) {
        JFrame frame = new JFrame("Array " + name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"1", "2", "3", "4", "5"};


        JTable table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(500, 250));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        int sizeA = 31;
        int[] arrA = new int[sizeA];
        int line = (int) (Math.ceil(sizeA / 5.0));
        String[][] arrayA = new String[line][5];
        for (int j = 0; j < sizeA; j++) {
            arrA[j] = (int) (Math.random() * (450 - 103)) + 103;
        }

        int indexArrA = 0;

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < 5; j++) {
                if (indexArrA < sizeA) {
                    arrayA[i][j] = "A[" + Integer.toString(indexArrA) + "] = " + Integer.toString(arrA[indexArrA]);
                }
                if (sizeA <= indexArrA) {
                    arrayA[i][j] = null;
                }
                indexArrA = indexArrA + 1;
            }
        }

        int sizeB = 0;                                  // size for arrayB, when A[i]*10%> i
        for (int i = 0; i < sizeA; i++) {
            if ((double) i < (arrA[i] / 10.0)) {
                sizeB = sizeB + 1;
            }
        }
        int[] arrB = new int[sizeB];
        int elementB = 0;                               //item number for array B
        for (int i = 0; i < sizeA; i++) {
            if ((double) i < (arrA[i] / 10.0)) {
                arrB[elementB] = arrA[i];
                elementB = elementB + 1;
            }
        }
        Arrays.sort(arrB);
        System.out.println(sizeB);
        int lineArrB = (int) (Math.ceil(sizeB / 5.0));              //the number of lines in arrayB(for table)
        int sizeStringB = 5*lineArrB;                               // the number of elements in arrayB (for table)
        String [][]arrayB = new String [lineArrB][5];


        for (int i = 0; i < lineArrB; i++) {
            int indexArrB = i;
            for (int j = 0; j < 5; j ++) {
                if  (indexArrB < sizeB){
                    arrayB[i][j]= "B["+Integer.toString(indexArrB)+"] = "+Integer.toString(arrB[indexArrB]);
                }
                if (indexArrB > sizeB){arrayB[i][j]=null;}
                indexArrB = indexArrB+5;
            }

            }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI(arrayA, "A");
                createGUI(arrayB, "B");
            }
        });
    }

}
