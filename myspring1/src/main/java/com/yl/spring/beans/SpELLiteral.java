package com.yl.spring.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/5/8.
 */
public class SpELLiteral {
    private static final Logger LOG = LoggerFactory.getLogger(SpELLiteral.class);

    private int age;
    public String name;
    private String height;
    private String address;

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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void show(){
        LOG.info("age:{}", age);
        LOG.info("name:{}", name);
        LOG.info("height:{}", height);
        LOG.info("address:{}", address);
    }
}
