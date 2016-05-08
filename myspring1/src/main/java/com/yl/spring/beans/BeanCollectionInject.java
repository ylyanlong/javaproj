package com.yl.spring.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Created by Administrator on 2016/5/8.
 */
public class BeanCollectionInject {
    private static final Logger LOG = LoggerFactory.getLogger(BeanCollectionInject.class);

    // private ILanguage[] iLanguages;  // 也可以用 list 或者 set 注入
    private Collection<ILanguage> languages;

    public static Logger getLOG() {
        return LOG;
    }

    public Collection<ILanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(Collection<ILanguage> languages) {
        this.languages = languages;
    }

    public void showLanguage(){
        for(ILanguage ele: languages){
            ele.sayHello();
        }
    }
}
