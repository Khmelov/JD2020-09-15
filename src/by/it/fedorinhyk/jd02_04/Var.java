package by.it.fedorinhyk.jd02_04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

abstract class Var implements Operation {

    private static Map<String, Var> varMap= new HashMap<>();

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String VARS_TXT = "vars.txt";
    private static final String FILENAME = getPath(Var.class) + VARS_TXT;

    static Var createVar(String strVar) throws CalcException{
        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }
        else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }
        else if (strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }
        else{
            Var var=varMap.get(strVar);
            if (Objects.isNull(var)) {
                throw new CalcException("Cant create:" + strVar);
            }
            return var;
        }
    }

    public static Var save(String name, Var value){
        varMap.put(name, value);
        return value;
    }

    private static void saveMap() throws CalcException {
        try (PrintWriter writer = new PrintWriter(FILENAME)) {
            for (Map.Entry<String, Var> entry : varMap.entrySet()) {
                writer.printf("%s=%s\n", entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            throw new CalcException("FILE ERROR: ", e);
        }
    }

    private static String getPath(Class<?> aClass) {
        String packageName = aClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC +
                File.separator + packageName;
    }

    public static Map <String, Var> getVarMap(){
        return varMap;
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Error "+this+"+"+other+" operation");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Error "+this+"-"+other+" operation");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Error "+this+"*"+other+" operation");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Error "+this+"/"+other+" operation");
    }

    @Override
    public String toString() {
        return "abstract var";
    }
}
