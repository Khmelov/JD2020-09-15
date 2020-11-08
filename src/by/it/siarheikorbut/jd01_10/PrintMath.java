package by.it.siarheikorbut.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1NWv3k35f7iqw1vwxeZLH85PcjVS1L_6X/view?usp=sharing">Задание JD01_10 ( B )</a>
 */

public class PrintMath {
    public static void main(String[] args) {
        Class<?> structClassMatch = Math.class;
        Method[] methods = structClassMatch.getDeclaredMethods();
        for (Method method : methods) {
            int modifies = method.getModifiers();
            StringBuilder out = new StringBuilder();
            if (Modifier.isPublic(modifies)) {
                out.append("public ");
                if (Modifier.isStatic(modifies)) {
                    out.append("static ");
                }
                out.append(method.getReturnType()).append(" ");
                out.append(method.getName()).append("(");
                Class<?> returnType = method.getReturnType();
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    out.append(parameterType.getSimpleName());
                    if (i < parameterTypes.length - 1) {
                        out.append(",");
                    }
                }
                out.append(")");
                System.out.println(out);
            }

            Field[] fields = structClassMatch.getFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                out = new StringBuilder();
                if (Modifier.isPublic(modifiers)) {
                    out.append(field.getType()).append(" ");
                    out.append(field.getName());
                }
                System.out.println(out);
            }
        }
    }
}