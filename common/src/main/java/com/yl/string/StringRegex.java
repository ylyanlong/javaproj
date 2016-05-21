package com.yl.string;

/**
 * Created by Administrator on 2016/5/18.
 */
public class StringRegex {
    public static void main(String[] args){
        // String str = "q.a.f8add(10, \"yan\")";
        // String str = "f8add(10, \"yan\")";
        // String str = "f8add";
        String str = "a.f8add()";
        String regex = "([a-zA-Z_$][a-zA-Z\\d_$]*\\.)*[a-zA-Z_$][a-zA-Z\\d_$]*\\.[a-zA-Z_$][a-zA-Z\\d_$]*\\(.*\\)";
        System.out.println("match:" + str.matches(regex));
    }
}
