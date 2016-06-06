package com.yl.spring.aopannotation;

/**
 * Created by Administrator on 2016/5/26.
 */
public class CriticismEngineImpl implements CriticismEngine {
    @Override
    public String getCriticism() {
        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }

    private String[] criticismPool;

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
