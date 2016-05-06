package com.yl.generic;

import java.util.ArrayList;

class GenericStack<E>{
	private ArrayList<E> list = new ArrayList<E>();
	
	public int getSize(){
		return list.size();  // java 对容器大小是统一用 size 吗?
	}
	public E peek(){
		return list.get(getSize() - 1);
	}
	public void push(E obj){
		list.add(obj);
	}
	public E pop(){
		E obj = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return obj;
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
}

class GenericStack2<E> extends GenericStack<E>{
	public void Hello(){
		System.out.println("Hello");
	}
}

public class GenericT1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arrayListStr = new ArrayList<String>();
		arrayListStr.add("red");
		arrayListStr.add("gree");
		arrayListStr.add("blue");
		
		System.out.println(arrayListStr.get(0));
		System.out.println(arrayListStr.get(1));
		
		GenericStack<String> genericSt1 = new GenericStack<String>();
		genericSt1.push("str1");
		genericSt1.push("str2");
		genericSt1.push("str3");
		
		GenericStack<Integer> genericStInt = new GenericStack<Integer>();
		genericStInt.push(23);
		genericStInt.push(45);
		genericStInt.push(67);
		
		String[] strArray = {"abc", "wer", "jko", "erj"};
		GenericT1.<String>print(strArray);
		Integer[] intArray = {12, 34, 45, 64, 86};
		GenericT1.<Integer>print(intArray);
		
		double maxValue = max(genericStInt);
		System.out.println("maxValue: " + maxValue);
		
		// 合并stack
		GenericStack<String> stackStr = new GenericStack<String>();
		stackStr.push("abc");
		stackStr.push("jkl");
		stackStr.push("mnj");

		GenericStack<Object> stackObj = new GenericStack<Object>();
		stackObj.push("java");
		stackObj.push(12);

		add(stackStr, stackObj);
		printGenericStack(stackObj);
	}

	public static <E> void print(E[] list){
	// public static  void print(E[] list){
		for(int i = 0; i < list.length; ++i)
			System.out.print(list[i] + "  ");
		System.out.println();
	}
	public static double max(GenericStack<? extends Number> stack){  // 返回值前面没有类型信息，是因为类型信息是已知的吗？
		double max = stack.pop().doubleValue();
		while(!stack.isEmpty() ){
			double value = stack.pop().doubleValue();
			if(max < value){
				max = value;
			}
		}
		
		return max;
	}
	public static void printGenericStack(GenericStack<?> stack){
		while(!stack.isEmpty() ){
			System.out.println(stack.pop() + "  ");
		}
	}
	public static  <T> void add(GenericStack<T> stack1, GenericStack<? super T> stack2){
		while(!stack1.isEmpty() ){
			stack2.push(stack1.pop() );
		}
	}
	

}
