package com.yl.classprac;

/**
 * Created by yanlong on 2016/3/27.
 */
public class Super1 {
    public int num = 10;
    protected String name = "tom";

    public static void main(String[] args){
        Object object = new Super1();  // 没有对应的方法，不能这么写
        Super1 super1 = new Super1();
        super1.sayHello("hello");

        super1 = new SubClass1();
        super1.sayHello("hello");

        super1 = new SubClass2();
        super1.sayHello("hello");

        SubClass1 subClass1 = new SubClass1();
        subClass1.sayHello("hello2");

        subClass1 = new SubClass2();
        subClass1.sayHello("hello2");

    }

    public void sayHello(String message){
        System.out.println("Super1:" + message);
    }

    protected void talk(String words){
        System.out.println("say:" + words);
    }

    public static void laugh(String message){
        System.out.println("Super1 laugh:" + message);
    }

    public void print(double num){
        System.out.println("print:" + num * 2);
    }

    public String toString(){
        return "Super1";
    }

}
