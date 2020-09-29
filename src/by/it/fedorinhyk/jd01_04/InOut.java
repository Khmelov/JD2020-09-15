package by.it.fedorinhyk.jd01_04;

public class InOut {
    //"1.342 40 60 99 10000"
    static double[ ] getArray(String line){
        line=line.trim();
        String[] strArray= line.split(" ");
        double[] array= new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i]=Double.parseDouble(strArray[i]);
        }
        return array;
    }

    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element+" ");

        }
        System.out.println();
    }
    static void printArray(double[ ] arr, String name, int columnCount){
        // d 4
        //d[ 0 ]= 1.1  d[ 1 ]= 2.2 d[ 2 ]= 2.5
        //d[ 3 ]= 1.4  d[ 4 ]= 2.2
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-6.2f",name,i,arr[i]);
            if((i+1)%columnCount==0 || i+1==arr.length)
                System.out.println();

        }


    }
}
