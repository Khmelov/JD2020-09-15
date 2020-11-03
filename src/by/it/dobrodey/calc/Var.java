package by.it.dobrodey.calc;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        SaveOnDemandHolderIdiom.saveMap();
        return value;
    }

    static void load() throws CalcException {
        try {

            List<String> lines = Files
                    .lines(Paths.get(GetFileName.getFilename()))
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




