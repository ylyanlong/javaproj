package com.yl.annotation;

/**
 * Created by Administrator on 2016/6/17.
 */
public class FieldAnnotationCase1 {

    @FieldAnnotation1(id = 5, name = "陕西红富士", address = "陕西咸阳")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

}
