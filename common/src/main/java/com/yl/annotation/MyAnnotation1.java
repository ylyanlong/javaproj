package com.yl.annotation;

/**
 * Created by Administrator on 2016/5/20.
 */
public class MyAnnotation1 {

    // @MyAnnotation(value1 = "abc")
    @MyAnnotation
    public void execute(){
        System.out.println("method");
    }

    public static void main(String[] args){
        MyAnnotation1 myAnnotation1 = new MyAnnotation1();
        myAnnotation1.execute();
    }
}
