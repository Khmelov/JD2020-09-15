package by.it.hutnik.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintMath {
    public static void main(String[] args) {
        Class<?> mClass = Math.class;
        Method[] dMethods = mClass.getDeclaredMethods();
        for (Method method : dMethods) {
            StringBuilder sb = new StringBuilder();
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC){
                sb.append("public ");
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC){
                    sb.append("static ");
                    Class<?> rType = method.getReturnType();
                    sb.append(rType.getSimpleName());
                    sb.append(' ');
                    sb.append(method.getName());
                    sb.append('(');

                    int pCount = method.getParameterCount();
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    for (int i = 0; i < parameterTypes.length; i++) {
                        if (pCount == 1) {
                            sb.append(parameterTypes[i].getSimpleName());
                        } else if (pCount >= 2) {
                            sb.append(parameterTypes[i].getSimpleName());
                            sb.append(',');
                            sb.append(parameterTypes[i+1].getSimpleName());
                            break;
                        }
                    }
                    sb.append(')');
                    System.out.println(sb);
                }
            }
        }
        Field[] dFields = mClass.getFields();
        StringBuilder sb = new StringBuilder();
        for (Field field : dFields) {
            Class<?> returnType = field.getType();
            sb.append(returnType.getSimpleName());
            sb.append(' ');
            sb.append(field.getName());
            sb.append("\n");
        }

        Field[] fields = mClass.getDeclaredFields();
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                sb.append(field.getName());
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
