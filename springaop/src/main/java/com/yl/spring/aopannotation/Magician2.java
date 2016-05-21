package com.yl.spring.aopannotation;

import com.yl.spring.aopxml.MindReader;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/5/21.
 */
@Component
@Aspect
public class Magician2 implements MindReader {
    private String thoughts;

    // @Pointcut("execution(* com.yl.spring.aopxml.Thinker.thinkOfSomething(String)) and args(thoughts)")
    // @Pointcut("execution(* *.thinkOfSomething(String)) and args(thoughts)") // 用 and 会 报错
    @Pointcut("execution(* *.thinkOfSomething(String)) && args(thoughts)")
    public void thinking(String thoughts){

    }

    public String getThoughts() {
        return thoughts;
    }

    @Before("thinking(thoughts)")
    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Magician2: intecepting volunteer`s thoughts");
        this.thoughts = thoughts;
    }
}
