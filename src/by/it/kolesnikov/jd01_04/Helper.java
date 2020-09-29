package by.it.kolesnikov.jd01_04;

class Helper {
    static double findMin(double [] arr){
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min>arr[i]) min=arr[i];
        }
        System.out.println(min);
        return min;

    }
    static double findMax(double [] arr){
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max<arr[i]) max=arr[i];
        }
        System.out.println(max);
        return max;

    }
    static void sort(double[ ] arr){
        printMas(arr);
        boolean swap;
        int last = arr.length-1;
        do {
            swap=false;
            for (int j = 0; j < last; j++) {
                if (arr[j]>arr[j+1]) {
                    double buffer = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=buffer;
                    swap=true;
                }
            }
            last--;
        }
        while (swap);
        printMas(arr);
    }

    public static void printMas(double[] massive) {
        for (double arr: massive){
            System.out.print(arr+" ");
        }
        System.out.println();
    }
}
