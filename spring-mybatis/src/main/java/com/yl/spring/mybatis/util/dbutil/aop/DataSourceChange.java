package com.yl.spring.mybatis.util.dbutil.aop;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceChange {
    String value() default "";
}
