package by.it.fedorinhyk.jd02_06;

import java.util.Calendar;
import java.util.Date;

public class Runner {
    static class Build extends Thread {

        public Build(String name){
            super(name);
        }

        @Override
        public void run() {
            Logger.getLogger().log(this.getName());
        }
    }

    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        Date moment=calendar.getTime();
        for (int i = 1; i < 10; i++) {
            new Build("Exception № "+i+" "+moment).start();
        }
    }

}
