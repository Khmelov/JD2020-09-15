package by.it.zubovich.jd01_08.oop;

public class Model {
    public static void main(String[] args) {
        Mobile phoneMobile = new SiemensMobile() {
            @Override
            public boolean available() {
                return super.available();
            }

            @Override
            public boolean notAvailable() {
                return super.notAvailable();
            }

            @Override
            public void color(int n) {
                super.color(4);
            }

            @Override
            public void clamshell() {
                super.clamshell();
            }
        };
        phoneMobile.color(1);
        phoneMobile.available();
        phoneMobile.notAvailable();
        phoneMobile.clamshell();

    }
}
