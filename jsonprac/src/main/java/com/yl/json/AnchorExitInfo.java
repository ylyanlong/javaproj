package com.yl.json;

/**
 * Created by Administrator on 2016/4/6.
 */
public class AnchorExitInfo {
    private long uid;
    private double liushiRate;
    private long rank;
    private int en_uv;
    private int out_uv;

    public AnchorExitInfo() {
    }

    public AnchorExitInfo(long uid, double liushiRate, long rank, int en_uv, int out_uv) {
        this.uid = uid;
        this.liushiRate = liushiRate;
        this.rank = rank;
        this.en_uv = en_uv;
        this.out_uv = out_uv;
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

    public int getEn_uv() {
        return en_uv;
    }

    public void setEn_uv(int en_uv) {
        this.en_uv = en_uv;
    }

    public int getOut_uv() {
        return out_uv;
    }

    public void setOut_uv(int out_uv) {
        this.out_uv = out_uv;
    }

    @Override
    public String toString() {
        return "AnchorExitInfo{" +
                "uid=" + uid +
                ", liushiRate=" + liushiRate +
                ", rank=" + rank +
                ", en_uv=" + en_uv +
                ", out_uv=" + out_uv +
                '}';
    }
}
