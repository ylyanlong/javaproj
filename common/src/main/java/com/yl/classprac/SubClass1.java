package com.yl.classprac;

/**
 * Created by yanlong on 2016/3/27.
 */
public class SubClass1 extends Super1 {

    public static void main(String[] args){
        /// Super1.main(args);  // 方法是方法，数据是数据呀
        // SubClass1.main(args);  // Exception in thread "main" java.lang.StackOverflowError
        SubClass1 subClass1 = new SubClass1();
        subClass1.print(10.0);
        subClass1.print(10);
        System.out.println(subClass1);
    }

    public void sayHello(String message){
        System.out.println("SubClass1:" + message);
        System.out.println("num:" + super.num);
        System.out.println("name:" + super.name);
        // 静态方法也可以继承
        super.sayHello("this is Super1 say hello"); // 调用父类中被覆盖的实例方法
        super.talk("talk");

        // 静态方法并没有被覆盖，是隐藏了
        laugh("this is SubClass1");
        Super1.laugh("this is Super1");
    }

    public static void laugh(String message){
        System.out.println("SubClass1 laugh:" + message);
    }

    // 重载不是重写
    public void print(int num){
        System.out.println("print:" + num);
    }

    public String toString(){
        return "SubClass1";
    }

}
