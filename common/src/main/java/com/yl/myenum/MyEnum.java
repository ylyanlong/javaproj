package com.yl.myenum;

/**
 * Created by yl on 2015/9/12.
 */
public enum MyEnum {
    CHN_BEAT(1), CHN_IN(2), CHN_OUT(3);
    private int id;
    MyEnum(int pid){
        id = pid;
    }

    public String toString(){
        return String.valueOf(id);
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args){
        System.out.println("CHN_BEAT: " + MyEnum.CHN_BEAT);
        // System.out.println("values: " + MyEnum.values());
        for(MyEnum ele: MyEnum.values()){
            System.out.println("ele: " + ele);
        }

        System.out.println("CHN_BEAT:" + MyEnum.valueOf(MyEnum.class, "CHN_BEAT"));
        System.out.println("CHN_BEAT: " + MyEnum.valueOf("CHN_BEAT"));
        System.out.println("CHN_BEAT: " + MyEnum.CHN_BEAT.getId());
    }
}
