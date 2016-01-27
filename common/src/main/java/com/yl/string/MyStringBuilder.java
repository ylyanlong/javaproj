package com.yl.string;

/**
 * Created by leaon on 15-7-12.
 */
public class MyStringBuilder {
    public static void main(String[] args){
        StringBuilder strBulider = new StringBuilder();
        strBulider.append("welcome");
        strBulider.append(' ');
        strBulider.append("to");
        strBulider.append(' ');
        strBulider.append("java");

        System.out.println(strBulider.toString() );
    }
}
