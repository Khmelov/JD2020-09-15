package by.it.kolesnikov.jd02_01;

import java.util.HashMap;
import java.util.Map;

  class Good {
      //Просто метод возвращающий HashMap с продуктами, которые есть в магазине
    static Map<String, Integer> goods (){
        Map<String, Integer> good = new HashMap<>();
        good.put("bread", 5);
        good.put("potato", 2);
        good.put("meat", 10);
        good.put("tomato", 3);
        return good;
    }
}
