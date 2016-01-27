package com.yl.string;

public class MyStringPrac1 {
	private static final String COMP3 = "yan";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "123456789";  // commit from laptop  add second commit
		System.out.println(str1.substring(3, 7) );  // ???

		String ts1 = "1444374306";
		// String ts1 = "1444374306.410";
		// String ts1 = "1444374285.157";
		// String ts1 = "1444374285@157";
		String[] array = ts1.split("\\.");
		System.out.println("size:" + array.length);
		for(String ele: array){
			System.out.println("ele:" + ele);
		}
		System.out.println("array[0] : " + array[0]);
		// System.out.println("array[1] : " + array[1]);

		// String inputStr = "12u0675688";
		String inputStr = "1210675688";
		try{
			long num1 = Long.parseLong(inputStr);
			System.out.println("num1: " + num1);
		} catch (NumberFormatException e){
			System.out.println("error NumberFormatException");
		}

		String comp1 = "yan";
		String comp2 = "yan";
		if(comp1 == comp2){
			System.out.println("comp1 == comp2");
		} else {
			System.out.println("comp1 != comp2");
		}

		if(COMP3 == comp1){
			System.out.println("COMP3 == comp1");
		} else {
			System.out.println("COMP3 != comp1");
		}

		System.out.println(COMP3 == comp1);
		System.out.println(COMP3.equals(comp1));

		final String myFStr = "long";
		// myFStr = "yanlong";

		String myNullStr = "null";
		if(!myNullStr.equals("null")){
			System.out.println("myNullStr not equals null");
		} else {
			System.out.println("myNullStr equals null");
		}

	}

}
