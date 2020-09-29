package by.it.siarheikorbut.jd01_02;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1BOB3Xi2qWYN9DxaTMQBwnlKQAJzOx1IK/view?usp=sharing">Задание JD01_02 ( C )</a>
 */

public class TaskC {
    public static void main(String[] args) {

        step1(5);
    }

    //Задание значений элементов матрицы в интервале значений от -n до n используя генератор случайных чисел.
    static int[][] step1(int n) {
        int[][] arr = new int[n][n];

        boolean minOk;
        boolean maxOk;
        do {
            maxOk = false;
            minOk = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                    if (arr[i][j] == n) {
                        maxOk = true;
                    }
                    if (arr[i][j] == -n) {
                        minOk = true;
                    }
                }
            }
        }
        while (!minOk || !maxOk);
        return arr;
    }
}