package com.yl.spring.beans;

/**
 * Created by Administrator on 2016/5/15.
 */
public class AutowiringBeanBytype2 {
    private ILanguage iLanguage;

    public ILanguage getiLanguage() {
        return iLanguage;
    }

    public void setiLanguage(ILanguage iLanguage) {
        this.iLanguage = iLanguage;
    }

    public void show(){
        iLanguage.sayHello();
    }
}
