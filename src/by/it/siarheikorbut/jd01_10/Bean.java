package by.it.siarheikorbut.jd01_10;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1NWv3k35f7iqw1vwxeZLH85PcjVS1L_6X/view?usp=sharing">Задание JD01_10</a>
 */

public class Bean {
    @Param(a = 4, b = 6)
    static double sum(int a, int b) {
        return a + b;
    }

    double max(int a, int b) {
        return (Math.max(a, b));
    }

    @Param(a = 30, b = 60)
    double min(int a, int b) {
        return Math.min(a, b);
    }

    @Param(a = 25, b = 59)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}