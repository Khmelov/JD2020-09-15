package by.it.hutnik.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> str = java.lang.String.class;
        Method[]methods = str.getDeclaredMethods();
        StringBuilder strring = new StringBuilder();
        for (Method method: methods){
            int m = method.getModifiers();
            if (! Modifier.isStatic(m)) {
                if(strring.indexOf(method.getName())<0 && method.getName() != "formatted") {
                    strring.append(method.getName());
                    System.out.println(method.getName());
                }
            }
        }
    }
}
