package by.it.zubovich.calc;

public class Runner {
    public static void main(String[] args) {
        /////////////////////////////////////////
        Scalar sNum = new Scalar(3.1415);
        System.out.println("\n" + sNum.toString());
        Scalar sVar = new Scalar(sNum);
        System.out.println(sVar.toString());
        Scalar sStr = new Scalar("3.1415");
        System.out.println(sStr.toString() + "\n");
        /////////////////////////////////////////
        Vector vArr = new Vector(new double[]{1.0, 2.0, 4.0});
        System.out.println(vArr.toString());
        Vector vVar = new Vector(vArr);
        System.out.println(vVar.toString());
        Vector vStr = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(vStr.toString() + "\n");
        ///////////////////////////////////////
        Matrix mArr = new Matrix(new double[][]{
                {1.0,2.0},
                {3.0,4.0}
        });
        System.out.println(mArr.toString());
        Matrix mVar = new Matrix(mArr);
        System.out.println(mVar.toString());
        Matrix mStr = new Matrix("{{ 1.0, 2.0 },{ 3.0, 4.0 }}");
        System.out.println(mStr.toString());

    }
}
