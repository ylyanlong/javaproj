package com.yl.spring.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/5/8.
 */
public class BeanMapIntergeInject {
    private static final Logger LOG = LoggerFactory.getLogger(BeanMapIntergeInject.class);

    private Map<Integer, ILanguage> id2language;

    public Map<Integer, ILanguage> getId2language() {
        return id2language;
    }

    public void setId2language(Map<Integer, ILanguage> id2language) {
        this.id2language = id2language;
    }

    public void show(){
        Set<Map.Entry<Integer, ILanguage> > entries = id2language.entrySet();
        for(Map.Entry<Integer, ILanguage> entry: entries){
            LOG.info("id:{}", entry.getKey());
            entry.getValue().sayHello();
        }
    }
}
