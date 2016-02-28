package com.yl.string;

/**
 * Created by Administrator on 2016/2/28.
 * 是字符串常量，会直接在常量区分配;
 * 常量区会从堆区中取引用，但堆区不会从常量去取引用;
 * String#intern 方法时，如果存在堆中的对象，会直接保存对象的引用，而不会重新创建对象。
 */
public class StringInter {

    public static void main(String[] args){
        StringInter string_inter = new StringInter();
        string_inter.test1();
        string_inter.test2();
    }

    private void test1(){
        System.out.println("-------------test1--begin----------------------");
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        System.out.println("-------------test1--end----------------------");
    }

    private void test2(){
        System.out.println("-------------test2--begin----------------------");
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
        System.out.println("-------------test2--end----------------------");
    }
}
