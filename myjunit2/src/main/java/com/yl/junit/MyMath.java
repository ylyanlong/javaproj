package com.yl.junit;

/**
 * Created by Administrator on 2015/11/8.
 */
public class MyMath {
    public int sum(int a, int b){
        return a + b;
    }

    public int minus(int a, int b){
        return a - b;
    }

    public double division(double a, double b) throws Exception {
        if(b == 0){
            throw new Exception("除数不能为0");
        }

        return a / b;
    }
}
