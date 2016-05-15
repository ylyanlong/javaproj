package com.yl.spring.beans;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Administrator on 2016/3/12.
 */
@Qualifier("cppqualifier")
public class CppLanguage implements ILanguage {
    @Override
    public void sayHello() {
        System.out.println("hello, l am C++");
    }
}
