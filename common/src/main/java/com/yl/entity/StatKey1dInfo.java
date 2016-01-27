package com.yl.entity;

/**
 * Created by Administrator on 2015/11/10.
 */
public class StatKey1dInfo {
    private String datatime;
    private String keyName;
    private long value;

    public StatKey1dInfo(){}

    public StatKey1dInfo(String p_datatime, String p_keyName, long p_value){
        datatime = p_datatime;
        keyName = p_keyName;
        value = p_value;
    }

    public String getDatatime() {
        return datatime;
    }

    public String getKeyName() {
        return keyName;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "StatKey1dInfo{" +
                "datatime=" + datatime +
                ", keyName='" + keyName + '\'' +
                ", value=" + value +
                '}';
    }
}
