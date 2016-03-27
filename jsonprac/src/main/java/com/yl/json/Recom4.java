package com.yl.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/26.
 */
public class Recom4 {
    private long uid;
    private List<RecomUserInfo> ratios = new ArrayList<>();

    public Recom4() {
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public List<RecomUserInfo> getRatios() {
        return ratios;
    }

    public void setRatios(List<RecomUserInfo> ratios) {
        this.ratios = ratios;
    }
}

class RecomUserInfo {
    private String tag;
    private int tagRatio;
    private int femaleRatio;
    private int maleRatio;

    public RecomUserInfo() {
    }

    public RecomUserInfo(String tag, int tagRatio, int femaleRatio, int maleRatio) {
        this.tag = tag;
        this.tagRatio = tagRatio;
        this.femaleRatio = femaleRatio;
        this.maleRatio = maleRatio;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTagRatio() {
        return tagRatio;
    }

    public void setTagRatio(int tagRatio) {
        this.tagRatio = tagRatio;
    }

    public int getFemaleRatio() {
        return femaleRatio;
    }

    public void setFemaleRatio(int femaleRatio) {
        this.femaleRatio = femaleRatio;
    }

    public int getMaleRatio() {
        return maleRatio;
    }

    public void setMaleRatio(int maleRatio) {
        this.maleRatio = maleRatio;
    }
}
