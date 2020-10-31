package by.it.lapkovskiy.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Bean bean = (Bean) Class.forName("by.it.lapkovskiy.jd01_10.Bean").newInstance();
        Method[] methods = bean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Param.class))
            try{
                double d=  (double)method.invoke(bean,3,6);
                System.out.println(method.getName());
                System.out.println(d);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
