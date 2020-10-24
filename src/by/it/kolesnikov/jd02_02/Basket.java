package by.it.kolesnikov.jd02_02;


import java.util.*;

class Basket {
    /*
    Метод, который из класса Good (в котором лежит HashMap с продуктами)
    добавляет в ArrayList basketGoods (наша корзина) от 1 до 4 случайных наименований товаров.
    И в ArrayList price цены на товары. В переменную sum добавляем всю стоимость случайно добавленных товаров
    */
    static void basket() {
        List<String> goods = new ArrayList<>();
        List<String> basketGoods = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();
        List<Integer> price = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : Good.goods().entrySet()){
            String el = entry.getKey();
            Integer pr = entry.getValue();
            goods.add(el);
            prices.add(pr);
        }
        int count = Helper.getRandom(1,4);
        String delimiter = "";
        int sum=0;
        for (int i = 0; i < count; i++) {
            int rnd = Helper.getRandom(3);
            String good = goods.get(rnd);
            int pr = prices.get(rnd);
            basketGoods.add(good);
            price.add(pr);
            sum=sum+price.get(i);
            System.out.print(delimiter);
            System.out.print(basketGoods.get(i));
            delimiter=", ";
        }
        System.out.println(": costs $"+sum);
    }
}
