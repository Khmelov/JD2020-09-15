package by.it.arhipova.jd02_06;

public class Runner {

    static class Th extends Thread{

        public Th(String name) {
            super(name);
        }

        @Override
        public void run() {
            by.it.arhipova.jd02_06.Logger.getLogger().log(this.getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            new Th("Thread " + i).start();
        }
    }
}
