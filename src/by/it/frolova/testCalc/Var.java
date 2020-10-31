package by.it.frolova.testCalc;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Var implements Operation {
    private static Lang manager = Lang.INSTANCE;

    private static Map<String,Var> varMap = new HashMap<>();

    public static Var save(String name, Var value) throws CalcExceptions {
        varMap.put(name, value);
        saveMap();
        return value;

    }

    private static void saveMap() throws CalcExceptions {
        try (PrintWriter writer = new PrintWriter(FILENAME)) {
            for (Map.Entry<String, Var> entry : varMap.entrySet()) {
                writer.printf("%s=%s\n", entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            throw new CalcExceptions("FILE ERROR: ", e);
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

    static void load() throws CalcExceptions {
        try {
            List<String> lines = Files
                    .lines(Paths.get(FILENAME))
                    .collect(Collectors.toList());
            Parser parser = new Parser();
            for (String line : lines) {
                parser.calc(line);
            }
        } catch (IOException | CalcExceptions e) {
            throw new CalcExceptions(e);
        }

    }
    @Override
    public Var add(Var other) throws CalcExceptions {
        throw new CalcExceptions(String.format(manager.get(Error.ERROR_IMPOSSIBLE) + " " + this + other + "\n"));
    }

    @Override
    public Var sub(Var other) throws CalcExceptions {
        throw new CalcExceptions(String.format(manager.get(Error.ERROR_IMPOSSIBLE) + " " + this + other + "\n"));
    }

    @Override
    public Var mul(Var other) throws CalcExceptions {
        throw new CalcExceptions(String.format(manager.get(Error.ERROR_IMPOSSIBLE) + " " + this + other + "\n"));
    }

    @Override
    public Var div(Var other) throws CalcExceptions {
        throw new CalcExceptions(String.format(manager.get(Error.ERROR_IMPOSSIBLE) + " " + this + other + "\n"));
    }

    @Override
    public String toString() {
        return "from abstract";
    }
}
