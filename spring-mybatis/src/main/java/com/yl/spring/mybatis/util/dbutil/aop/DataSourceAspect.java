package com.yl.spring.mybatis.util.dbutil.aop;

import com.yl.spring.mybatis.util.dbutil.datasource.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;


@Aspect
public class DataSourceAspect {
    //日志
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut(value = "@annotation(com.yl.spring.mybatis.util.dbutil.aop.DataSourceChange)")
    private void dataSourceChange() {
    }

    @Around(value = "dataSourceChange() ", argNames = "pp")
    public Object doAround(ProceedingJoinPoint pp) throws Throwable {
        Object retVal = null;
        MethodSignature ms = (MethodSignature) pp.getSignature();
        Method method = ms.getMethod();
        DataSourceChange annotation = method.getAnnotation(DataSourceChange.class);
        boolean selectedDataSource = false;
        try {
            String selDs = null;
            if (null != annotation.value() && !"".equals(annotation.value())) {
                selectedDataSource = true;
                selDs = annotation.value();
                DynamicDataSource.use(selDs);
            }
            retVal = pp.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            if (selectedDataSource) {
                DynamicDataSource.reset();
            }
        }
        return retVal;
    }
}
