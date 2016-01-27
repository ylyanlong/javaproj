package com.yl.json;

/**
 * Created by Administrator on 2016/1/19.
 */
public class User {
    private int uid;
    private String uname;
    private String upwd;
    private int number;

    public User(){}  // 加上，否则读取文件生成对象时会出错

    public User(int p_uid, String p_uname, String p_upwd, int p_number){
        uid = p_uid;
        uname = p_uname;
        upwd = p_upwd;
        number = p_number;
    }

    public String getUpwd() {  // 必须有 getter方法，否则转为 JSON是会报序列化出错；或者用JsonProperty
        return upwd;
    }

    public int getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", number=" + number +
                '}';
    }
}
