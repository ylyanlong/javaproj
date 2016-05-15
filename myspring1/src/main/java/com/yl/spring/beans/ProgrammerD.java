package com.yl.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Administrator on 2016/5/15.
 */
public class ProgrammerD {
    @Autowired
    @Qualifier("cpp")
    // @Qualifier("cppqualifier")
    // @Qualifier("cppqualifier2")
    private ILanguage iLanguage;

    public void show(){
        iLanguage.sayHello();
    }
}
