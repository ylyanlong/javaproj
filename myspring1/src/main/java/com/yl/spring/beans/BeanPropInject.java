package com.yl.spring.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Administrator on 2016/5/8.
 */
public class BeanPropInject {
    private static final Logger LOG = LoggerFactory.getLogger(BeanPropInject.class);

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void show(){
        Set<String> names = properties.stringPropertyNames();
        for(String key : names){
            LOG.info("key:{}, value:{}", key, properties.getProperty(key));
        }
    }
}
