package com.yl.spring.aopannotation;

/**
 * Created by Administrator on 2016/5/26.
 */
public aspect JudgeAspect {
    public JudgeAspect() {
    }

    pointcut performance(): execution(* perform(..));

    after() returning() : performance(){
        System.out.println(criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
