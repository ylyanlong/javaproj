package com.yl.string;

/**
 * Created by Administrator on 2016/2/28.
 */
public class StringEqualT1 {
    public static void main(String[] args){
        int uid1 = 5896;
        int uid2 = 5896;

        final String str1 = String.valueOf(uid1);
        final String str2 = String.valueOf(uid2);

        if(str1 == str2){
            System.out.printf("str1 == str2");
        } else {
            System.out.printf("str1 != str2");
        }

    }
}
