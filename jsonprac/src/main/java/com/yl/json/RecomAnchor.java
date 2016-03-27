package com.yl.json;

/**
 * Created by Administrator on 2016/3/24.
 */
public class RecomAnchor {
    private long uid;
    private int type;

    public RecomAnchor() {
    }

    public RecomAnchor(long uid, int type) {
        this.uid = uid;
        this.type = type;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RecomAnchor{" +
                "uid=" + uid +
                ", type=" + type +
                '}';
    }
}
