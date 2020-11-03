package by.it.hutnik.calculator;

abstract class Var implements Operation {
    static Var createVar(String maker){
        if (maker.matches(Patterns.SCALAR)){
            return new Scalar(maker);
        }
        else if (maker.matches(Patterns.VECTOR)){
            return new Vector(maker);
        }
//        else if (maker.matches(Patterns.MATRIX)){
//            return new Matrix(maker);
//        }
        else {
            System.err.println("Незвестная переменная "+maker);
            return null;
        }
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения "+ this+"+"+ other +" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания "+ this+"-"+other+" невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения "+ this+"*"+other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления "+ this+"/"+other+" невозможна");
        return null;
    }

    @Override
    public String toString() {
        return "Это класс Var{}";
    }

}