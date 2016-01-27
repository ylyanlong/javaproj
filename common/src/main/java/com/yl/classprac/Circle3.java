package com.yl.classprac;

/**
 * Created by leon on 15-7-15.
 */
public class Circle3 {
    private double radius = 1;
    private final static String testFinal = "test";

    private static int numOfObjects = 0;

    public Circle3(){
        numOfObjects++;
    }
    public Circle3(double newRadius){
        radius = newRadius;
        numOfObjects++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius>0?radius:0;
    }

    public static int getNumOfObjects(){
        return numOfObjects;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public static void main(String[] args){
        Circle3 circle = new Circle3(2.4);
        System.out.println("radius: " + circle.getRadius() );
        System.out.println("numOfObjects: " + Circle3.getNumOfObjects() );
        System.out.println("area: " + circle.getArea() );
    }
}
