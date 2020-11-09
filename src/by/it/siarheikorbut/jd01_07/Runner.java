package by.it.siarheikorbut.jd01_07;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1TJnuaS3yKKmJURuLfRdT_3q1cc7uf8oU/view?usp=sharing">Задание JD01_07</a>
 */

//Создание проверочного класса.
public class Runner {
    public static void main(String[] args) {

        //Создание обьектов класса Scalar с соответствующими конструкторами.
        Var v1 = new Scalar(3.1415);
        System.out.println(v1);
        Var v2 = new Scalar(new Scalar(3.1415));
        System.out.println(v2);
        Var v3 = new Scalar("3.1415");
        System.out.println(v3);

        //Создание обьектов класса Vector с соответствующими конструкторами.
        Var v4 = new Vector(new double[]{1.0, 2.0, 4.0});
        System.out.println(v4);
        Var v5 = new Vector(new Vector(new double[]{1.0, 2.0, 4.0}));
        System.out.println(v5);
        Var v6 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(v6);

        //Создание обьектов класса Matrix с соответствующими конструкторами.
        Var v7 = new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        System.out.println(v7);
        Var v8 = new Matrix(new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}}));
        System.out.println(v8);
        Var v9 = new Matrix("{ { 1.0, 2.0 }, { 3.0, 4.0 } }");
        System.out.println(v9);
    }
}
