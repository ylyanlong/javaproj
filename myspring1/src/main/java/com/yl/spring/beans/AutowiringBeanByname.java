package com.yl.spring.beans;

/**
 * Created by Administrator on 2016/5/15.
 */
public class AutowiringBeanByname {
    private ILanguage java; // 类型是不一样的
    private ILanguage cpp;  // HelloWorld
    // private HelloWorld cpp;

    public ILanguage getJava() {
        return java;
    }

    public void setJava(ILanguage java) {
        this.java = java;
    }

    public ILanguage getCpp() {
        return cpp;
    }

    public void setCpp(ILanguage cpp) {
        this.cpp = cpp;
    }

    public void show(){
        java.sayHello();
        cpp.sayHello();
    }
}
