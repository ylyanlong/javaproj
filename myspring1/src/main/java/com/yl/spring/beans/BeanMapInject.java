package com.yl.spring.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/5/8.
 */
public class BeanMapInject {
    private static final Logger LOG = LoggerFactory.getLogger(BeanMapInject.class);

    private Map<String, ILanguage> name2language;

    public Map<String, ILanguage> getName2language() {
        return name2language;
    }

    public void setName2language(Map<String, ILanguage> name2language) {
        this.name2language = name2language;
    }

    public void show(){
        Set<Map.Entry<String, ILanguage> > entries = name2language.entrySet();
        for(Map.Entry<String, ILanguage> entry: entries){
            LOG.info("name:{}", entry.getKey());
            entry.getValue().sayHello();
        }
    }
}
