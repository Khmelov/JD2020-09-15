package by.it.fedorinhyk.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Goods<goodsCost> {
    static HashMap<Buyer, HashMap<String, Double>> Goods = new HashMap<>();
    static Map<String, Double> getMap() {
        Map<String, Double> goodsCost = new HashMap<>();
            goodsCost.put("Молоко", 2.0);
            goodsCost.put("Хлеб", 1.2);
            goodsCost.put("Мясо", 7.5);
            goodsCost.put("Сыр", 3.2);
            goodsCost.put("Пельмени", 3.1);
            goodsCost.put("Маска", 1.1);
            goodsCost.put("Антисептик", 2.5);
            goodsCost.put("Боярышник", 3.8);
            goodsCost.put("Яйца", 2.0);
            goodsCost.put("Рыба", 5.3);
            goodsCost.put("Клей", 2.7);
            goodsCost.put("Нарцыс", 4.6);
        return goodsCost;
    }
}


