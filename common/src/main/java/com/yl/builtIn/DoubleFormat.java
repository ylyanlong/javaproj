package com.yl.builtIn;

/**
 * Created by Administrator on 2016/3/20.
 */
public class DoubleFormat {
    public static void main(String[] args){

        int a = 32, b = 70;
        double d = (a * 100) / (a + b);
        // double x1 = 0.026;
        System.out.println(String.format("%.2f", d) + "%");

        Double d1 = 5.0;
        Double d2 = 5.000001;
        d1.compareTo(d2);

    }
}
