package by.it.kolesnikov.jd02_01;

import java.util.*;

class Basket {

    static void basket() {
        StringBuffer sb =new StringBuffer();
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
            sb.append(delimiter);
            sb.append(basketGoods.get(i));
            delimiter=", ";
        }
        System.out.println(sb+": costs $"+sum);
    }
}
