package by.it.yemialyanava.calcul.builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Report {
    /**
     * "Product"
     */

    private String head;
    private LocalDateTime timeOfStart;
    private LocalDateTime timeOfEnd;
    private String informationPart;
    private String exception;

    void setHead(String head) {
        this.head = head;
    }

    void setTimeOfStart(LocalDateTime timeOfStart) {
        this.timeOfStart = timeOfStart;
    }

    void setTimeOfEnd(LocalDateTime timeOfEnd) {
        this.timeOfEnd = timeOfEnd;
    }

    void setInformationPart(String information) {

        this.informationPart = information;
    }

    public void setInformationOfError(String exception) {
        this.exception =  exception;
    }

    @Override
    public String toString() {
        return
                "\n\t head= " + head + "\n" +
                "\t timeOfRun='" + timeOfStart.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss ")) + "\n" +
                "\t timeOfEnd='" + timeOfEnd.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss "))+ "\n" +
                "\t informationPart='" + informationPart + "\n" +
                "\t informationOfError= " + exception + "\n";
    }
}
