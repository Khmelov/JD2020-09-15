package by.it.siarheikorbut.jd02_04;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

    static Map<String, Var> vars = new HashMap<>();

    static TreeMap<String, Var> sortMap() {
        return new TreeMap<>(vars);
    }

    static Var saveVar(String name, Var var) throws CalcException {
        vars.put(name, var);
        saveToTxt();
        return var;
    }

    static void load() throws CalcException {
        String path = getPath() + "vars.txt";
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                lines.add(br.readLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException("error read vars", e);
        }
        Parser parser = new Parser();
        for (String line : lines) {
            parser.calc(line);
        }
    }

    private static void saveToTxt() throws CalcException {
        String path = getPath() + "vars.txt";
        try (PrintWriter writer = new PrintWriter(path)) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                writer.printf("%s=%s\n", pair.getKey(), pair.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new CalcException(e);
        }
    }

    private static String getPath() {
        String rootProject = System.getProperty("user.dir");
        String relativePath = Var.class
                .getName()
                .replace(Var.class.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s + %s невозможна\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s - %s невозможна\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s * %s невозможна\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s / %s невозможна\n", this, other));
    }

    @Override
    public String toString() {
        return "Это класс Var{}";
    }

    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else if (vars.containsKey(strVar)) {
            return vars.get(strVar);
        } else {
            throw new CalcException("Незвестная переменная " + strVar);
        }
    }

    protected abstract int getSize();
}