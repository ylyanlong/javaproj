package com.yl.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Administrator on 2016/6/17.
 */
public class FieldAnnotationParse1 {
    public static void main(String[] args){
        FieldAnnotationParse1.fieldAnnotationParse(FieldAnnotationCase1.class);
    }

    public static void fieldAnnotationParse(Class<?> clazz){
        // Field[] fields = clazz.getFields();  // 只包含 public 属性
        Field[] fields = clazz.getDeclaredFields();  // 所有属性都包含
        for(Field field: fields){
            if(field.isAnnotationPresent(FieldAnnotation1.class)){
                FieldAnnotation1 annotation = field.getAnnotation(FieldAnnotation1.class);
                System.out.println("id: " + annotation.id() + " , name: " + annotation.name() + " , address: " + annotation.address());
            }
        }

    }


}
