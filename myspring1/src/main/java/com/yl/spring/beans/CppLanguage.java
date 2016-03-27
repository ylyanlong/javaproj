package com.yl.spring.beans;

/**
 * Created by Administrator on 2016/3/12.
 */
public class CppLanguage implements ILanguage {
    @Override
    public void sayHello() {
        System.out.println("hello, l am C++");
    }
}
