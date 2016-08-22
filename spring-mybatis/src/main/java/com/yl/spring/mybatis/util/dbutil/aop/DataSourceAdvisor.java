package com.yl.spring.mybatis.util.dbutil.aop;

import com.yl.spring.mybatis.util.dbutil.datasource.DynamicDataSource;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class DataSourceAdvisor implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {

	/**
	 * 系统报错后，数据源处理
     * @param method
     * @param args
     * @param target
     * @param ex
     */
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        DataSourceChange annotation = method.getAnnotation(DataSourceChange.class);
        if(null != annotation) {
            if (null != annotation.value() && !"".equals(annotation.value())) {
                if (!annotation.value().equals("default")) {
                    DynamicDataSource.use(annotation.value());
                }
            }
        }else {
            DynamicDataSource.reset();
        }
    }

	/**
     * 方法执行后默认把数据源切回默认
     * @param returnValue
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        DynamicDataSource.reset();
    }

	/**
     * 方法执行前切换数据源
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        DataSourceChange annotation = method.getAnnotation(DataSourceChange.class);
        if(null != annotation) {
            if (null != annotation.value() && !"".equals(annotation.value())) {
                if(!annotation.value().equals("default")) {
                    DynamicDataSource.use(annotation.value());
                }
            }
        }
    }
}
