package com.yl.generic;

/**
 * Created by yanlong on 2016/4/13.
 */
interface ISayHello <E> {
    void sayHello(E obj);
}

// 如果 两个都没有 泛型类型，函数里面就没有泛型类型；所以必须其中一个有泛型类型;
// 如果 ISayHello 有泛型，则实现它的类必须有泛型；否则会报错
// 如果实现类有泛型，父类没有；则参数变为 Object 类型的了
// 可以用 Object 来间接实现泛型，再做转型
public class GenericInterfaceT1 <E> implements ISayHello <E> {

    @Override
    public void sayHello(E obj) {
        System.out.println(obj);
    }

    public static void main(String[] args){
        GenericInterfaceT1<String> genericInterfaceT1 = new GenericInterfaceT1<>();
        genericInterfaceT1.sayHello("hello, generic interface");
    }
}
