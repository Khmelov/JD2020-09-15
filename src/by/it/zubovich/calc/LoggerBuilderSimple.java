package by.it.zubovich.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LoggerBuilderSimple extends LoggerBuilder {

    private static final String LOG_NAME_SMALL = "logsmall.txt";
    private static final String FILENAMElOG = GetFileName.getFilename() + LOG_NAME_SMALL;
    @Override
    void timeEnter(LocalDateTime time) throws CalcException {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILENAMElOG,true))) {
            out.printf("Report SMALL\n");
            out.printf("Time Enter: %s\n", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(time));
        } catch (IOException e) {
            throw new CalcException("FILE ERROR: ");
        }
    }



    @Override
    void timeExit(LocalDateTime time) throws CalcException {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILENAMElOG,true))) {
            out.printf("Time Exit: %s\n", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(time));
        } catch (IOException e) {
            throw new CalcException("FILE ERROR: ");
        }
    }

    @Override
    void log(String text) throws CalcException {

        try (PrintWriter out = new PrintWriter(new FileWriter(FILENAMElOG,true))) {
            out.printf("Date: %s     Event:  %s\n",
                    DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(LocalDateTime.now()),
                    text);
        } catch (IOException e) {
            throw new CalcException("FILE ERROR: ");
        }
    }
}
