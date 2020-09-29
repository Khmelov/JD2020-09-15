package by.it.lapkovskiy.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String str = Poem.text;
        String[] arr = str.split("\\n+");
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i].length()){
                max = arr[i].length();
            }
        }
        for (int i = 0; i < arr.length; i++) {
           arr[i]= add(arr[i],max);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\n");
        }
    }
    private static String add(String str, int le){
        StringBuilder sb =  new StringBuilder(str);
        int point = 0;
        while (sb.length() < le) {
            int index = sb.indexOf(" ", point);
            if (index == -1) {
                point = 0;
                continue;
            }
            point = index +1;
            if (point == sb.indexOf(" ", point)) {
                continue;
            }
            sb.replace(point, point, " ");
            point += 1;
        }
        return sb.toString();
    }
}
