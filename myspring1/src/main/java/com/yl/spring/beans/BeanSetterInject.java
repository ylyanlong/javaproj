package com.yl.spring.beans;

/**
 * Created by Administrator on 2016/5/8.
 */
public class BeanSetterInject {
    private int age;
    private String name;
    private Double height;
    private boolean sex;
    private ILanguage iLanguage;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public ILanguage getiLanguage() {
        return iLanguage;
    }

    public void setiLanguage(ILanguage iLanguage) {
        this.iLanguage = iLanguage;
    }
}
