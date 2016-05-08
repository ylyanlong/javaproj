package com.yl.spring.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2016/5/8.
 */
public class BeanNullInject {
    private static final Logger LOG = LoggerFactory.getLogger(BeanNullInject.class);

    private Integer age;
    private List<String> books;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public void show(){
        if(age == null){
            LOG.info("age is null");
        } else {
            LOG.info("age is not null");
        }

        if(books == null){
            LOG.info("books is null");
        } else {
            LOG.info("books is not null");
        }
    }
}
