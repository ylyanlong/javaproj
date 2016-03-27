package com.yl.spring.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/3/21.
 */
@Component
// @Scope("singleton")  // 默认的
public class PythonLanguage {
    private static int count = 0;

    private int objCount = 0;

    public PythonLanguage() {
        count++;
    }

    public void sayHello() {
        System.out.println("say PythonLanguage");
        objCount++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        PythonLanguage.count = count;
    }

    public int getObjCount() {
        return objCount;
    }

    public void setObjCount(int objCount) {
        this.objCount = objCount;
    }
}
