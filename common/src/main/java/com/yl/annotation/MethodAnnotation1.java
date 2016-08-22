package com.yl.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2016/6/15.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation1 {
    String author() default "tom";
    String date();
    int revision() default 1;
    String comments();
}
