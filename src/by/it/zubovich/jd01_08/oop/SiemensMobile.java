package by.it.zubovich.jd01_08.oop;

abstract class SiemensMobile implements Mobile {

    @Override
    public boolean available() {
        return true;
    }

    @Override
    public boolean notAvailable() {
        return false;
    }

    @Override
    public void color(int n) {
        String colorMobile;
        switch (n){
            case 1: colorMobile = "Black";
            break;
            case 2: colorMobile = "White";
            break;
            case 3: colorMobile = "Red";
            break;
            case 4: colorMobile = "Silver";
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }
        System.out.println(colorMobile);
    }

    @Override
    public void clamshell() {
        System.out.println("clamshell");
    }

}
