package by.it.siarheikorbut.jd02_04;

public class Runner {
    private static void print(Var var) {
        System.out.println(var);
    }

    public static void main(String[] args) throws CalcException {
        Var s = new Scalar(3.0);
        Var s2 = new Scalar(5.0);
        Var v = new Vector(new double[]{1, 2, 3});
        Var v2 = new Vector(new double[]{5, 2, 3});

        Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");
        Var m2 = new Matrix("{{3,2,1},{4,0,6},{7,8,9}}");

        print(s.add(s2));
        print(s.sub(s));
        print(s.mul(s));
        print(s.div(s));
        System.out.println(v);
        System.out.println(v2);
        System.out.println(m);

        print(v.add(v2));
        print(v.sub(v));
        print(v.mul(v));
        print(v.div(v));

        print(m.add(m2));
        print(m.sub(m2));
        print(m.mul(m2));
        print(m.mul(v));
    }
}