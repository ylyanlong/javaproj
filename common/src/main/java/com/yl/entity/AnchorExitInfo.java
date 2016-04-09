package com.yl.entity;

/**
 * Created by Administrator on 2016/4/6.
 */
public class AnchorExitInfo {
    private long uid;
    private double liushiRate;
    private long rank;

    public AnchorExitInfo() {
    }

    public AnchorExitInfo(long uid, double liushiRate, long rank) {
        this.uid = uid;
        this.liushiRate = liushiRate;
        this.rank = rank;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public double getLiushiRate() {
        return liushiRate;
    }

    public void setLiushiRate(double liushiRate) {
        this.liushiRate = liushiRate;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }
}
