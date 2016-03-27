package com.yl.classprac;

/**
 * Created by yanlong on 2016/3/27.
 */
public class SubClass2 extends SubClass1 {

    public static void main(String[] args){
        // 动态绑定是由实际类型决定的，会沿着调用链，找到首个满足条件的方法
        System.out.println(new SubClass2().toString());  // 注意 SubClass2 没有覆盖 toString 方法

        System.out.println(new SubClass1().toString());
        System.out.println(new Super1().toString());
        System.out.println(new Object().toString());
    }

    public void sayHello(String message){
        System.out.println("SubClass2:" + message);
        System.out.println("SubClass2 num:" + super.num);
        System.out.println("SubClass2 name:" + super.name);
        super.talk("talk SubClass2");
    }
}
