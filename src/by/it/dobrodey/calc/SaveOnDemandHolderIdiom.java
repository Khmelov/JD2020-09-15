package by.it.dobrodey.calc;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;




public class SaveOnDemandHolderIdiom {
    private static final String VARS_TXT = "vars.txt";
    public static class SingletonHolder {
        private static void save() throws CalcException {
            try (PrintWriter writer = new PrintWriter(GetFileName.getFilename()+ VARS_TXT)) {
                for (Map.Entry<String, Var> entry : Var.getVarMap().entrySet()) {
                    writer.printf("%s=%s\n", entry.getKey(), entry.getValue());
                }
            } catch (IOException e) {
                throw new CalcException("FILE ERROR: ", e);
            }
        }
    }

    public static void saveMap() throws CalcException {
        SingletonHolder.save();
    }





}
