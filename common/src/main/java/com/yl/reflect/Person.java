package com.yl.reflect;

public class Person {
	public String mName = "";
	
	public Person(String aName){
		mName = aName;
	}
	
	public void sayHello(String friendName){
		System.out.println(mName + "  say hello to  " + friendName);
	}
	public void showMyName(){
		System.out.println("my name is:  " + mName);
	}
	public void takeBreathe(){
		System.out.println("take breathe");
	}
	
}
