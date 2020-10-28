package by.it.lapkovskiy.jd02_01;

import java.util.HashMap;

public class Goods {
    public static void getGood(HashMap<String,Integer> basket,String name){
        switch (Helper.getRandom(5)) {
            case 0:
                basket.put("CHEESE", 67);
                System.out.println(name+" take:CHEESE:"+basket.get("APPLE"));
                break;
            case 1:
                basket.put("APPLE", 1);
                System.out.println(name+" take:APPLE:"+basket.get("APPLE"));
                break;
            case 2:
                basket.put("ORANGE", 3);
                System.out.println(name+" take:ORANGE:"+basket.get("ORANGE"));
                break;
            case 3:
                basket.put("SALT", 2);
                System.out.println(name+" take:SALT:"+basket.get("SALT"));
                break;
            case 4:
                basket.put("WATER", 5);
                System.out.println(name+" take:WATER:"+basket.get("WATER"));
                break;
            case 5:
                basket.put("JOY", 8);
                System.out.println(name+" take:JOY:"+basket.get("JOY"));
                break;

        }
    }

}
