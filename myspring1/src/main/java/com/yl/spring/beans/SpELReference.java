package com.yl.spring.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/5/8.
 */
public class SpELReference {
    private static final Logger LOG = LoggerFactory.getLogger(SpELReference.class);

    private int age;
    private String name;
    private String address;
    private double pi;
    private double percent;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPi() {
        return pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public void show(){
        LOG.info("age:{}", age);
        LOG.info("name:{}", name);
        LOG.info("address:{}", address);
        LOG.info("pi:{}", pi);
        LOG.info("percent:{}", percent);
    }
}
