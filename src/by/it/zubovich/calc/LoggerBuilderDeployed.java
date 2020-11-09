package by.it.zubovich.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LoggerBuilderDeployed extends LoggerBuilder {


    private static final String LOG_NAME_DEPLOYED= "logdeployed.txt";
    private static final String FILENAMElOGDEP = GetFileName.getFilename() + LOG_NAME_DEPLOYED;


    @Override
    void timeEnter(LocalDateTime time) throws CalcException {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILENAMElOGDEP,true))) {
            out.printf("Report DEPLOYED\n");
            out.printf("Time Enter: %s\n", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(time));
        } catch (IOException e) {
            throw new CalcException("FILE ERROR: ",e);
        }
    }

    @Override
    void timeExit(LocalDateTime time) throws CalcException {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILENAMElOGDEP,true))) {
            out.printf("Time Exit: %s\n", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(time));
        } catch (IOException e) {
            throw new CalcException("FILE ERROR: ",e);
        }
    }

    @Override
    void log(String text) throws CalcException {
        String filename = GetFileName.getFilename() + LOG_NAME_DEPLOYED;
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.printf("Date: %s     Event:  %s\n",
                    DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(LocalDateTime.now()),
                    text);
        } catch (IOException e) {
            throw new CalcException("FILE ERROR: ", e);

        }
    }
}
