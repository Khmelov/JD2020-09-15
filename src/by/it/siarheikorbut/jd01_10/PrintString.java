package by.it.siarheikorbut.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;


public class PrintString {
    public static void main(String[] args) {
        Class<?> structStringClass = String.class;
        Method[] methods = structStringClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            int modifiers = method.getModifiers();
            if (Modifier.isStatic(modifiers)) {
            } else System.out.println(method.getName());
        });
    }
}