package by.it.zubovich.jd02_04;

//@SuppressWarnings("SameParameterValue")
public class Calc {
    static int add(int a, int b) {
        return a + b;
    }

    static int sub(int a, int b) {
        return a - b;
    }

    static int mul(int a, int b) {
        return a * b;
    }

    static int div(int a, int b) {
        return a / b;
    }

    static int ost(int a, int b) {
        return a % b;
    }

    public static void main(String[] args) {
        System.out.println("1+2=" + add(1, 2));
        System.out.println("1-2=" + sub(1, 2));
        System.out.println("1*2=" + mul(1, 2));
        System.out.println("1/2=" + div(1, 2));
        System.out.println("1%2=" + ost(1, 2));

    }


}
