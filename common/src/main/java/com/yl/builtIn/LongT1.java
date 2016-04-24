package com.yl.builtIn;

/**
 * Created by Administrator on 2016/4/18.
 */
public class LongT1 {
    public static void main(String[] args){
        Long longValue = 2L;
        Integer intValue = 3;
        LongT1 longT1 = new LongT1();
        longT1.changeParam(longValue, intValue);
        System.out.println("outer longValue: " + longValue + ", intValue: " + intValue);
    }

    public void changeParam(Long longParam1, Integer intParam2){
        System.out.println("before longParam1: " + longParam1 + ", intParam2: " + intParam2);
        longParam1 = longParam1 + 10;
        intParam2 = intParam2 + 20;
        System.out.println("end longParam1: " + longParam1 + ", intParam2: " + intParam2);
    }
}
