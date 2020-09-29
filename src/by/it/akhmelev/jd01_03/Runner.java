package by.it.akhmelev.jd01_03;

public class Runner {
    public static void main(String[] args) {
        double[] array = InOut.getArray(" 1.1234 2 3 4 600  ");
        double[] arr={1,2,3.0};
        Helper.sort(arr);
        InOut.printArray(array);
        InOut.printArray(array,"A",3);
    }
}
