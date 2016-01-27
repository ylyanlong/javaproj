package com.yl.reflect;

import com.yl.dp.Observer;

import java.lang.reflect.*;

public class MyReflect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// get Class Object of a Class, there are three ways
		// method1
		Class<?> classObject1 = Observer.class;  // if we knows the name of the class
		// method2
		Observer observerObj = new Observer();
		Class<?> classObject2 = observerObj.getClass(); // if we have the object of the class
		// method3
		try {
			// must use the full path. if we only know the path at the compile time
			Class<?> classOjbect3 = Class.forName("cn.com.yl.dp.Observer"); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		
		constructorObject("cn.com.yl.reflect.Person");
		
		showDeclaredMethods("cn.com.yl.reflect.Student");  // 并未出现 Object 相关的函数, Object 其实是二级父类, 可以测试下
		showDeclaredMethods("cn.com.yl.reflect.Person");

		showDeclaredFields("cn.com.yl.reflect.Student");

		getAllPublicFields("cn.com.yl.reflect.Student");
	}

	// classPath = "cn.com.yl.reflect.Person"
	private static void constructorObject(String classPath){
		try {
			Class<?> classObject = Class.forName(classPath);
			Constructor<?> constructObj = classObject.getConstructor(String.class);
			// constructObj.setAccessible(true);  // 为 true 时取消 java 语言检查, 提升反射的速度
			Object object = constructObj.newInstance("simple.test");
			System.out.println("obj:  " + object.toString() );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void showDeclaredMethods(String classPath){
		try {
			Class<?> classObj = Class.forName(classPath);
			Method[] methods = classObj.getDeclaredMethods();
			for(Method method: methods){
				System.out.println(method.getName() );
			}

			Method learnMetnod = classObj.getDeclaredMethod("learn", String.class);
			Class<?>[] paramClass = learnMetnod.getParameterTypes();  // class 究竟是什么,感觉和泛型有很大关系
			for(Class<?> classEle: paramClass){
				System.out.println("paramType: " + classEle.getName() );
			}

			System.out.println(learnMetnod.getName() + "  is private  " + Modifier.isPrivate(learnMetnod.getModifiers() ) );

			Student student = new Student("Sam");
			learnMetnod.invoke(student, "java");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getAllPublicMethod(String classPath){
		try {
			Class<?> classObj = Class.forName(classPath);
			Method[] methods = classObj.getMethods();
			for(Method methodEle: methods){
				System.out.println("methodName: " + methodEle.getName() );
			}
			Method learnMethod = classObj.getMethod("learn", String.class);
			System.out.println(learnMethod.getName() + "  is private  " + Modifier.isPrivate(learnMethod.getModifiers() ));

			Student student = new Student("Tom");
			learnMethod.invoke(student, "test2");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void showDeclaredFields(String classPath){
		try {
			Class<?> classObj = Class.forName(classPath);
			Field[] fields = classObj.getDeclaredFields();  // 获取到了所有字段,包括私有的
			for(Field fieldEle: fields){
				System.out.println("fieldName: " + fieldEle.getName() );
			}

			Student student = new Student("Lily");
			Field mGradeField = classObj.getDeclaredField("id");  // 只能获取共有字段
			System.out.println("mGrade: " + mGradeField.getInt(student) );
			mGradeField.setInt(student, 20);
			System.out.println("mGrade: " + mGradeField.getInt(student) );
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getAllPublicFields(String classPath){
		try {
			Class<?> classObj = Class.forName(classPath);
			Field[] fields = classObj.getFields();
			for(Field fieldEle: fields){
				System.out.println("field name: " + fieldEle.getName() );
			}
			
			Student student = new Student("doggy");
			Field mNameField = classObj.getField("id");
			System.out.println("mNameField value: " + mNameField.getInt(student));
			mNameField.setInt(student, 50);
			System.out.println("mNameField value: " + mNameField.getInt(student));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
