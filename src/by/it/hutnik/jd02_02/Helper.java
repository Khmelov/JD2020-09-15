package by.it.hutnik.jd02_02;

import java.util.Random;

class Helper {
    private static Random random = new Random(); // создание обработчика случайных чисел
    static int getRandom(int min, int max) { // создание диапазона случайных чисел
        return min + random.nextInt(max - min + 1); // вoзвращение случайного челого числа int
    }
    static int getRandom(int max) {

        return getRandom(0, max);
    }
    static void vremyaStop(int milisek) {
        try {
            Buyer.sleep(milisek/ Supervisor.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
