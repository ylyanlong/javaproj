package com.yl.builtIn;

/**
 * Created by yl on 2015/12/4.
 */
public class MyByteT1 {
    public static void main(String[] args){
        byte b = 'a';
        System.out.println(b);
        byte a = 12;
        char ch = 'c';
        System.out.println(a);
        System.out.format("0x%x%n", a);
        System.out.format("0x%x%n", b);

        int[] intArray = new int[]{1, 2, 3, 4, 5};
        System.out.println(intArray);

        System.out.format("output %s, %d", "yan", 45);
        System.out.format("ot2:%s%n", "long");
        System.out.format("ot3:%s%n", "abc");

        System.out.printf("ot4:%s", "123");
        System.out.printf("ot5:%s%n", "456");
        System.out.printf("ot6:%s", "789");
    }
}
