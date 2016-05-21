package com.yl.dp;

/**
 * Created by Administrator on 2016/5/19.
 */
interface IDoJob{
    void fillBlank(int a, int b, int sum);
}

class CalculatorV3{
    public void addAndFillblank(int a, int b, IDoJob iDoJob){
        int sum = a + b;
        iDoJob.fillBlank(a, b, sum);
    }
}

class StudentV3{
    private String name;

    public StudentV3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void callHelp(int a, int b){
        new CalculatorV3().addAndFillblank(a, b, new StudentFillBlank());
    }

    // 内部类，也可以考虑用匿名内部类实现
    private class StudentFillBlank implements IDoJob{

        @Override
        public void fillBlank(int a, int b, int sum) {
            System.out.println("课堂作业, 写在黑板上: " + a + " + " + b + " = " + sum);
        }
    }

}

public class CallbackV3 {
    public static void main(String[] args){
        StudentV3 studentV3 = new StudentV3("小明");
        studentV3.callHelp(1000, 4567);
    }
}
