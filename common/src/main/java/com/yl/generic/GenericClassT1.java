package com.yl.generic;

/**
 * Created by yanlong on 2016/4/13.
 */
public class GenericClassT1<E> {
    private E obj;

    public E getObj() {
        return obj;
    }

    public void setObj(E obj) {
        this.obj = obj;
    }

    public static void main(String[] args){
        GenericClassT1<String> genericClassT1 = new GenericClassT1<>();
        genericClassT1.setObj("hello, Generic");
        System.out.println(genericClassT1.getObj() );

    }
}
