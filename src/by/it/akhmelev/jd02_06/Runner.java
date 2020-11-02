package by.it.akhmelev.jd02_06;

public class Runner {

    static class Th extends Thread{

        public Th(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger.getLogger().log(this.getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 2001; i++) {
            new Th("Thread"+i).start();
        }



    }




}
