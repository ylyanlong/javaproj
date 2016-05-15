package com.yl.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/5/15.
 */
public class ProgrammerC {
    @Autowired(required = false)
    private HelloBean helloBean;

    public void show(){
        if(helloBean != null){
            helloBean.getMessage();
        }

        System.out.println("helloBean is null");
    }
}
