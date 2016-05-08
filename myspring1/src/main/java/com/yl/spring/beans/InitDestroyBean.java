package com.yl.spring.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/5/8.
 */
public class InitDestroyBean {
    private static final Logger LOG= LoggerFactory.getLogger(InitDestroyBean.class);

    public InitDestroyBean(){
        LOG.info("InitDestroyBean constructor");
    }

    public void print(){
        LOG.info("InitDestroyBean print");
    }

    public void init(){
        LOG.info("InitDestroyBean init");
    }

    public void destroy(){
        LOG.info("InitDestroyBean destroy");
    }
}
