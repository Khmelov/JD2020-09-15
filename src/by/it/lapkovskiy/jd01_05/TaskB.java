package by.it.lapkovskiy.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
    private static void step1(){
        double y =0;
        for (double a = 0; a <= 2; a=a+0.2) {
            for  (int x = 1; x <= 6; x++){
                y=y+(Math.pow(7,a)-Math.cos(x));
            }
            System.out.printf("При a=%.2f Сумма y =%f\n",a,y);
        }
    }
    private static void  step2(){
        double A=0;
        double B=0;
        for (double x = -5.5; x < 2; x=x+0.5) {
            System.out.printf("При x/2=%.2f ",x/2);
            if(-2<x/2 && x/2<=-1){
               B = Math.sin(x*x);
            }
            else if(-1<x/2 && x/2<0.2){
                B= Math.cos(x*x);
            }
            else if(x/2==0.2){
                 B=Math.cos(x*x)/Math.sin(x*x);
            }
            else {
                System.out.println("вычисления не определены");
                continue;
            }
            A= Math.log10(Math.abs(B+2.74));
            System.out.printf("a = %e\n",A);

        }
    }
}
