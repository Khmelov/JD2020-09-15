package by.it.siarheikorbut.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> structBeanClass = Bean.class;
        Constructor<Bean> constructorBean = structBeanClass.getConstructor();
        Bean bean = constructorBean.newInstance();
        Method[] methods = structBeanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param param = method.getAnnotation(Param.class);
                double invoke = (double) method.invoke(bean, param.a(), param.b());
                System.out.println(method.getName() + " " + invoke);
            }
        }
    }
}