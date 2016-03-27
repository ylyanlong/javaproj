package com.yl.spring.beans;

/**
 * Created by Administrator on 2016/3/12.
 */
public abstract class Employee {
    private String name;
    private int id;
    private Double salary;
    private String sex;

    public Employee() {
    }

    public Employee(String name, int id, Double salary, String sex) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.sex = sex;
    }

    abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", salary=" + salary +
                ", sex='" + sex + '\'' +
                '}';
    }
}
