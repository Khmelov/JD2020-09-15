package by.it.arhipova.jd02_03;

    public interface IBuyer {

        void enterToTheShop(); //вошел в магазин (мгновенно)

        void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)

        void goToQueue(); // пошел в очередь

        void goOut(); //отправился на выход(мгновенно)
    }

