package by.it.arhipova.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Supervisor {
    private Supervisor() {
    }
        private static final AtomicInteger buyersEnterToTheShop = new AtomicInteger(0);
        private static final AtomicInteger buyersLeaveTheShop = new AtomicInteger(0);

        private static final int buyerTotal = 100;

        static void addBuyer() {
            buyersEnterToTheShop.getAndIncrement();

        }
        static void leaveBuyer() {
                buyersLeaveTheShop.getAndIncrement();
            }

        static boolean shopOpened() {

            return buyersEnterToTheShop.get() < buyerTotal;
        }

        static boolean shopClosed() {

            return buyersLeaveTheShop.get() == buyerTotal;
        }

}
