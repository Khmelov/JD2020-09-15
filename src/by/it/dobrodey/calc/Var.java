package by.it.dobrodey.calc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

abstract class Var implements Operation {

    private static Map<String, Var> varMap = new HashMap<>();

    public static Map<String, Var> getVarMap() {
        return varMap;
    }

    public static Var save(String name, Var value) throws CalcException {
        varMap.put(name, value);
        saveMap();
        return value;

    }



    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            Var var = varMap.get(strVar);
            if (Objects.isNull(var)) {
                throw new CalcException(ConsoleRunner.manager.get(Message.unknowVariable) + strVar);
            }
            return var;
        }
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

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String VARS_TXT = "vars.txt";
    private static final String FILENAME = getPath(Var.class) + VARS_TXT;

    @SuppressWarnings("SameParameterValue")
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

    static void load() throws CalcException {
        try {

            List<String> lines = Files
                    .lines(Paths.get(FILENAME))
                    .collect(Collectors.toList());
            Parser parser = new Parser();
            for (String line : lines) {
                parser.calc(line);
            }
        } catch (IOException e) {
            throw new CalcException(e);
        }

    }

    public String toString() {
        return ConsoleRunner.manager.get(Message.abstractVar);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(ConsoleRunner.manager.get(Message.OperationAddImpossible), this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(ConsoleRunner.manager.get(Message.OperationSubImpossible), this, other));

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(ConsoleRunner.manager.get(Message.OperationMultImpossible), this, other));

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(ConsoleRunner.manager.get(Message.OperationDivImpossible), this, other));
            }
}




