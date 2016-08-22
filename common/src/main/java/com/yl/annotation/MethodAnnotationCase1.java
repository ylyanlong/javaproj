package com.yl.annotation;

/**
 * Created by Administrator on 2016/6/15.
 */
public class MethodAnnotationCase1 {
    public static void main(String[] args){

    }

    @Override
    @MethodAnnotation1(author = "yanlong", date = "2016-06-15", comments = "method annotation")
    public String toString(){
        return "override toString()";
    }
    
    @MethodAnnotation1(date = "2016-06-13", comments = "method annotation 2")
    public void add(){
        
    }
}
