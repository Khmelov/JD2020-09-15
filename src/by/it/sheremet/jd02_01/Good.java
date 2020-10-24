package by.it.sheremet.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Good {
   static Map<String, Double> goods = new HashMap<>();
   static {
       goods.put("coffee",21.2);
       goods.put("bread",15.87);
       goods.put("sugar",14.52);
       goods.put("milk",12.9);
       goods.put("bacon",27.25);
       goods.put("magazine",10.99);
       goods.put("orange",14.7);
       goods.put("pasta",18.2);
       goods.put("rice",15.3);
       goods.put("newspaper",7.5);
   }
   public static Map<String, Double> getGoods(){
       return goods;
    }
}
