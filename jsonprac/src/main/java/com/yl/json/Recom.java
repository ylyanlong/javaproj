package com.yl.json;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/3/20.
 */
public class Recom {
    private String id;  // uid 或者 IMEI、MAC
    private Map<Integer, Set<Long> > re = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Integer, Set<Long>> getRe() {
        return re;
    }

    public void setRe(Map<Integer, Set<Long>> re) {
        this.re = re;
    }
}
