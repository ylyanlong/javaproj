package com.yl.generic;

/**
 * Created by yanlong on 2016/4/13.
 */
public class GenericFuncT1 {

    public static <E> void print(E obj){
        System.out.println(obj);
    }

    public static void main(String[] args){
        // 调用是没有传递类型参数，说明做了类型推导
       GenericFuncT1.print("hello, generic func");
        GenericFuncT1.<String>print("hello, generic func2");
    }

}
