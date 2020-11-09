package by.it.zubovich.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

enum Logger {
    GET;

    private static final String LOG_NAME = "log.txt";

    @SuppressWarnings("SameParameterValue")
    void log(String text) throws CalcException {
        String filename = GetFileName.getFilename() + LOG_NAME;

        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.printf("Date: %s     Event:  %s\n",
                    DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(LocalDateTime.now()),
                    text);
        } catch (IOException e) {
            throw new CalcException("FILE ERROR: ", e);
        }
    }
}

