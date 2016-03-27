package com.yl.spring.beans;

/**
 * Created by Administrator on 2016/3/12.
 */
public class LeaderA extends Employee {
    private int teamNum = 5;
    private ILanguage language1;
    private ILanguage language2;

    public LeaderA(){}

    public LeaderA(String name, int id, Double salary, String sex, int teamNum, ILanguage language1, ILanguage language2){
        super(name, id, salary, sex);
        this.teamNum = teamNum;
        this.language1 = language1;
        this.language2 = language2;
    }

    public void work(){
        System.out.println("------------work-begin------------------------");
        System.out.println(getBaseInfo());
        System.out.println("leading " + teamNum + "  people!");
        language1.sayHello();
        language2.sayHello();
        System.out.printf("------------work-end--------------------------");
    }

    public String getBaseInfo(){
        return super.toString();
    }
}
