package com.yl.reflect;

public class Student extends Person implements Examination {
	private int mGrade;
	public int id = 1;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student(String aName){
		super(aName);
	}
	public Student(String aName, int grade){
		super(aName);
		mGrade = grade;
	}
	private void learn(String score){
		System.out.println(mName + "  learn  " + score);
	}
	public void takeAnExamination(){
		System.out.println("take an examination");
	}
	public String toString(){
		return "student: " + mName;
	}
	
	
	
}
