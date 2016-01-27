package com.yl.mappers.statact;

import com.yl.entity.StatKey1dInfo;

import java.util.List;

/**
 * Created by Administrator on 2015/12/9.
 */
public interface StatKeyMapper {
    public void batchInsertStatKey1d(List<StatKey1dInfo> dataList);  //传参
}
