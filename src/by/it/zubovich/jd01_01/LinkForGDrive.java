package by.it.zubovich.jd01_01;

public class LinkForGDrive {
    public static void main(String[] args) {
        for (byte month = 1; month <= 12; month++) {
            for (byte day = 1; day <= 31; day++){
//                System.out.print("https://bit.ly/jd2020-");
//                System.out.printf("%02d", month);
//                System.out.print("-");
//                System.out.printf("%02d", day);
//                System.out.println();
                System.out.printf("https://bit.ly/jd2020-" + "%02d%s%02d\n", month, "-", day);
            }
        }
    }
}

/*
            bit.ly/jd2020-03-18
            bit.ly/jd2020-01-20

            bit.ly/jd2020-09-07
            bit.ly/jd2020-09-15
*/


