package by.it.hutnik.jd02_06;

import by.it._examples_.jd01_10.sample_proxylog.logger.Log;

public class Runner {

    private static final String ONE = "one";
    private static final String TH = "th";

    static class Th extends Thread {
        public Th(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger logger = Logger.getInstance();
            Logger.log(getName());
        }
    }

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Logger.log(ONE);
        for (int i = 0; i < 10; i++) {
            new Th (TH + i).start();
        }
    }
}
