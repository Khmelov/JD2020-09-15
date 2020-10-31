package by.it.hutnik.jd02_01;

import java.util.Random;

class Helper {
    private static Random random = new Random(); // создание обработчика случайных чисел
    static int getRandom(int start, int finish) { // создание диапазона случайных чисел

        return start + random.nextInt(finish - start + 1); // вoзвращение случайного челого числа int
    }
    static int getRandom(int max) {

        return getRandom(0, max);
    }
    static void mySleep(int milisek) {
        try {
            Thread.sleep(milisek/ Supervisor.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}