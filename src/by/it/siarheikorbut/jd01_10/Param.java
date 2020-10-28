package by.it.siarheikorbut.jd01_10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1NWv3k35f7iqw1vwxeZLH85PcjVS1L_6X/view?usp=sharing">Задание JD01_10 ( A )</a>
 */

//Создание аннотации которая описывает параметры для процедуры тестирования произвольного метода.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Param {
    int a();

    int b();
}