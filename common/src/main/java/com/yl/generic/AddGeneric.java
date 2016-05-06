package com.yl.generic;


/**
 * Created by yanlong on 2016/4/13.
 */
public class AddGeneric {
    public static <E extends  Number> double add(E obj1, E obj2){
        return  obj1.doubleValue() + obj2.doubleValue();
    }

    public static void main(String[] args){
        System.out.println(AddGeneric.add(12, 25.0) );
    }

}
