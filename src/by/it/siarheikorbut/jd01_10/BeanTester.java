package by.it.siarheikorbut.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1NWv3k35f7iqw1vwxeZLH85PcjVS1L_6X/view?usp=sharing">Задание JD01_10</a>
 */
public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Constructor<Bean> beanClassConstructor = beanClass.getConstructor();
        Bean bean = beanClassConstructor.newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param param = method.getAnnotation(Param.class);
                double v = (double) method.invoke(bean, param.a(), param.b());
                System.out.println(method.getName() + " " + v);
            }
        }
    }
}