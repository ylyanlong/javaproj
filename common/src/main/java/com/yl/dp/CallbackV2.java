package com.yl.dp;

/**
 * Created by Administrator on 2016/5/19.
 */
class StudentV2{
    private String name;

    public StudentV2(String name) {
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

    public void callHelp(){
        System.out.println("请小红帮忙");
    }

    public void fillBlankWithSum(int a, int b, int sum){
        System.out.println("写在黑板上: " + a + " + " + b + " = " + sum);
    }

    public void fillBlank(int a, int b){
        int sum = calculateAdd(a, b);
        System.out.println("写在黑板上: " + a + " + " + b + " = " + sum);
    }

    public void fillBlankWithCall(int a, int b){
        int sum = new Calculator().add(a, b);
        System.out.println("写在黑板上: " + a + " + " + b + " = " + sum);
    }
}

// 小红
class Calculator{
    public int add(int a, int b){
        return a + b;
    }

    public void tellFinish(){
        System.out.println("计算完成");
    }
}

public class CallbackV2 {

    public static void main(String[] args){
        StudentV2 studentV2 = new StudentV2("小明");
        Calculator calculator = new Calculator();

        // 版本一
        studentV2.callHelp();
        int sum = calculator.add(100, 308);
        calculator.tellFinish();
        studentV2.fillBlankWithSum(100, 308, sum);
        // 缺点：此处的交互过程过于冗长，应该由小红做完后直接填下就好了，前提是小明告诉小红应该怎么填


        // 版本二
        // 这个版本存在的缺点是小明需要现场等着小红昨晚，然后去黑板填；如果小明想去操场玩该怎么办？
        studentV2.fillBlankWithCall(100, 308);


    }
}
