package com.yl.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2016/6/17.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation1 {
    /**
     * 供应商编号
     * @return
     */
    public int id() default -1;

    /**
     * 供应商名字
     * @return
     */
    public String name() default "";

    /**
     * 供应商地址
     * @return
     */
    public String address() default "";

}
