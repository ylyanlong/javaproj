package com.yl.entity;

/**
 * Created by Administrator on 2016/3/24.
 */
public class VideoAnchor {
    private long uid;
    private long num;

    public VideoAnchor() {
    }

    public VideoAnchor(long uid, long num) {
        this.uid = uid;
        this.num = num;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "VideoAnchor{" +
                "uid=" + uid +
                ", num=" + num +
                '}';
    }
}
