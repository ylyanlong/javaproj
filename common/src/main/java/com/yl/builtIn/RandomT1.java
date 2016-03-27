package com.yl.builtIn;

import java.util.Random;

/**
 * Created by Administrator on 2016/3/25.
 */
public class RandomT1 {
    private static Random random = new Random();

    public static void main(String[] args){

        for(int i = 0; i < 20; ++i){
            System.out.println(random.nextInt(50));
        }
    }

}
