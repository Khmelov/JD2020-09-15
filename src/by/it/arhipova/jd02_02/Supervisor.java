package by.it.arhipova.jd02_02;

class Supervisor {
    private Supervisor() {
    }
        private static volatile int buyersEnterToTheShop = 0;
        private static volatile int buyersLeaveTheShop = 0;

        private static final int buyerTotal = 100;
        static synchronized void addBuyer() {
            buyersEnterToTheShop++;

        }
        static void leaveBuyer() {
            synchronized (Supervisor.class) {
                buyersLeaveTheShop++;
            }

        }
        static boolean shopIsOpened() {
            return buyersEnterToTheShop != buyerTotal;
        }

        static boolean shopIsClosed() {
            return buyersLeaveTheShop == buyerTotal;
        }

}
