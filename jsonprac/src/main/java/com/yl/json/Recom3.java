package com.yl.json;

import java.util.*;

/**
 * Created by Administrator on 2016/3/20.
 */
public class Recom3 {
    private String id;  // uid 或者 IMEI、MAC
    private List<RecomAnchor> re = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<RecomAnchor> getRe() {
        return re;
    }

    public void setRe(List<RecomAnchor> re) {
        this.re = re;
    }

    @Override
    public String toString() {
        return "Recom3{" +
                "id='" + id + '\'' +
                ", re=" + re +
                '}';
    }
}
