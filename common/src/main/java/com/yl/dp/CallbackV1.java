package com.yl.dp;

/**
 * Created by Administrator on 2016/5/19.
 */
class StudentV1{
    private String name;

    public StudentV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int calculateAdd(int a, int b){
        return a + b;
    }

    public void fillBlank(int a, int b){
        int sum = calculateAdd(a, b);
        System.out.println("写在黑板上: " + a + " + " + b + " = " + sum);
    }
}

public class CallbackV1 {
    public static void main(String[] args){
        StudentV1 student = new StudentV1("小明");
        student.fillBlank(2, 3);
    }
}
