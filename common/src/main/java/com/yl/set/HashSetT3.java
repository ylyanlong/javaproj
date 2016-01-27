package com.yl.set;

import java.util.HashSet;

/**
 * Created by leon on 2015/9/10.
 */
class Student{
    public int num;
    private String name;

    public Student(int num, String name){
        this.num = num;
        this.name = name;
    }

    public int hashCode(){
        return new Integer(num).hashCode();
    }

    public boolean equals(Object st){
        Student tempStudent = (Student)st;
        if(num == tempStudent.num){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}

public class HashSetT3 {
    public static void main(String[] args){
        HashSet<Student> hs = new HashSet<Student>();
        Student st1 = new Student(1, "zhao");
        Student st2 = new Student(2, "qian");
        Student st3 = new Student(3, "sun");

        hs.add(st1);
        hs.add(st2);
        hs.add(st3);
        System.out.println(hs);

        st1.num = 4;
        hs.remove(st1);
        System.out.println(hs);


    }
}
