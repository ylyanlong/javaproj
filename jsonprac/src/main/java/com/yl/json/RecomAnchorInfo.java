package com.yl.json;

/**
 * Created by Administrator on 2016/3/26.
 */
public class RecomAnchorInfo {
    // recom_anchor={aid,tag,sex,score}
    private long aid;
    private String tag;
    private long sex;
    private long score;

    public RecomAnchorInfo() {
    }

    public RecomAnchorInfo(long aid, String tag, long sex, long score) {
        this.aid = aid;
        this.tag = tag;
        this.sex = sex;
        this.score = score;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getSex() {
        return sex;
    }

    public void setSex(long sex) {
        this.sex = sex;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
