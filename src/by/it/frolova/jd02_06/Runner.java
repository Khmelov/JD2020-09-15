package by.it.frolova.jd02_06;

import java.util.Date;

public class Runner {

    static class Th extends Thread {

        public Th(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger.getLogger().log(this.getName());
        }
    }

    public static void main(String[] args) {
        Date date = new Date();
        for (int i = 1; i < 11; i++) {
            new Th("log " + i + " " + Logger.printDate(date)).start();
        }
    }
}
