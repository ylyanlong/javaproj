package com.yl.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/6/15.
 */
public class MethodAnnotationParse1 {

    public static void main(String[] args){
        MethodAnnotationParse1.parseMethodAnnotation(MethodAnnotationCase1.class);
    }

    public static void parseMethodAnnotation(Class<?> classobj){
        Method[] methods = classobj.getMethods();
        for(Method method: methods){
            if(method.isAnnotationPresent(com.yl.annotation.MethodAnnotation1.class)){
                // Annotation[] annotations = method.getDeclaredAnnotations();
                MethodAnnotation1 methodAnnotation1 = method.getAnnotation(MethodAnnotation1.class);
                System.out.println("author: " + methodAnnotation1.author() +
                        " , comments:" + methodAnnotation1.comments() +
                        " , date:" + methodAnnotation1.date() +
                        " , revision" + methodAnnotation1.revision());
            }
        }
    }

}
