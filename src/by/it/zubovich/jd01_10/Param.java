package by.it.zubovich.jd01_10;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface Param {
    int a();
    int b();

}
