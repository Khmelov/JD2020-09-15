package by.it.siarheikorbut.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1NWv3k35f7iqw1vwxeZLH85PcjVS1L_6X/view?usp=sharing">Задание JD01_10 ( B )</a>
 */

public class PrintMath {
    public static void main(String[] args) {
        Class<?> structMathClass = Math.class;
        Method[] methods = structMathClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
                    int modifiers = method.getModifiers();
                    StringBuilder out = new StringBuilder();
                    if (Modifier.isPublic(modifiers)) {
                        out.append("public ");
                        if (Modifier.isStatic(modifiers)) {
                            out.append("static ");
                        }
                        out.append(method.getReturnType()).append(" ");
                        out.append(method.getName()).append("(");
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        IntStream.range(0, parameterTypes.length).forEach(i -> {
                                    Class<?> parameterType = parameterTypes[i];
                                    out.append(parameterType.getSimpleName());
                                    if (i < parameterTypes.length - 1) out.append(",");
                                }
                        );
                        out.append(")");
                        System.out.println(out);
                    }
                }
        );
        Field[] fields = structMathClass.getFields();
        Arrays.stream(fields).forEach(field -> {
                    int modifiers = field.getModifiers();
                    StringBuilder out = new StringBuilder();
                    if (Modifier.isPublic(modifiers)) {
                        out.append(field.getType()).append(" ");
                        out.append(field.getName());
                    }
                    System.out.println(out);
                }
        );
    }
}