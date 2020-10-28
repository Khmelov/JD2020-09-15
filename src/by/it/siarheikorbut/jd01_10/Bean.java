package by.it.siarheikorbut.jd01_10;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1NWv3k35f7iqw1vwxeZLH85PcjVS1L_6X/view?usp=sharing">Задание JD01_10 ( A )</a>
 */

public class Bean {
    @Param(a = 22, b = 5)
    double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 25, b = 50)
    double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 22, b = 55)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    static double min(int a, int b) {
        return Math.min(a, b);
    }
}