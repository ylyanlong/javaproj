package com.yl.generic;

import java.util.Date;

/**
 * Created by yanlong on 2016/4/13.
 */
interface IComparable {
    int compareTo(Object o);
}


interface IComparableDate <E> {
    int compareTo(E o);
}

public class CompareTest{
    public static void main(String[] args){
        // Exception in thread "main" java.lang.ClassCastException: java.util.Date cannot be cast to com.yl.generic.IComparable
        IComparable iComparable = (IComparable) new Date();
        iComparable.compareTo("red");

        IComparableDate<Date> iComparableDate = (IComparableDate<Date>) new Date();
        // 会有类型报错
        // iComparableDate.compareTo("red");



    }
}


