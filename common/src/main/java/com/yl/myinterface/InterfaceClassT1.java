package com.yl.myinterface;

/**
 * Created by Administrator on 2016/4/9.
 */
public class InterfaceClassT1<E extends Number> implements InterfaceT2 {
    @Override
    public void sayHello(String words) {
        System.out.println("hello, " + words);
    }


    public static void main(String[] args){
        InterfaceT1 interfaceT1 = new InterfaceClassT1();
        interfaceT1.sayHello("InterfaceT1");

        InterfaceT2 interfaceT2 = new InterfaceClassT1();
        interfaceT2.sayHello("InterfaceT2");

        Integer a = 20;
        int b = a + 10;
    }
}
