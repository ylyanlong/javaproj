package com.yl.spring.aopannotation;

import com.yl.spring.aopxml.Contestant;
import com.yl.spring.aopxml.GraciousContestant;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/5/26.
 */
@Component
@Aspect
public class ContestantIntroducer {

    // 小心点是个借口，而不是一般的方法名
    @DeclareParents(value = "com.yl.spring.aopxml.Performer+", defaultImpl = GraciousContestant.class)
    public static Contestant contestant;
}
