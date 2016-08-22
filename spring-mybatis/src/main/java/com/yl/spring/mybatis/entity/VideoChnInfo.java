package com.yl.spring.mybatis.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/6/21.
 */
public class VideoChnInfo {
    private long uid;
    private Date updatetime;
    private int num;

    public VideoChnInfo() {
    }

    public VideoChnInfo(long uid, Date updatetime, int num) {
        this.uid = uid;
        this.updatetime = updatetime;
        this.num = num;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "VideoChnInfo{" +
                "uid=" + uid +
                ", updatetime=" + updatetime +
                ", num=" + num +
                '}';
    }
}
