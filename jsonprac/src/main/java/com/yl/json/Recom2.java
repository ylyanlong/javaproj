package com.yl.json;

import java.util.Set;

/**
 * Created by Administrator on 2016/3/20.
 */
public class Recom2 {
    private String _id;  // uid_type
    private Set<Integer> anchors;

    public Recom2() {
    }

    public Recom2(String _id, Set<Integer> anchors) {
        this._id = _id;
        this.anchors = anchors;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Set<Integer> getAnchors() {
        return anchors;
    }

    public void setAnchors(Set<Integer> anchors) {
        this.anchors = anchors;
    }
}
