package by.it.siarheikorbut.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1NWv3k35f7iqw1vwxeZLH85PcjVS1L_6X/view?usp=sharing">Задание JD01_10</a>
 */

public class PrintString {
    public static void main(String[] args) {
        Class<String> structString = java.lang.String.class;
        Method[] methods = structString.getDeclaredMethods();
        StringBuilder out = new StringBuilder();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (!Modifier.isStatic(modifiers)) {
                if (out.indexOf(method.getName()) < 0 && !method.getName().equals("formatted")) {
                    out.append(method.getName()).append(" ");
                    System.out.println(method.getName());
                }
            }
        }
    }
}