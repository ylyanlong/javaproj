package com.yl.spring.mybatis.mapper;

import com.yl.spring.mybatis.entity.VideoChnInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by Administrator on 2016/6/21.
 */
public interface IVideoPcuMapper {
    @Select("select uid, updatetime, num from video_test")
    @Results({
            @Result(column = "uid", property = "uid", jdbcType = JdbcType.BIGINT),
            @Result(column = "updatetime", property = "updatetime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "num", property = "num", jdbcType = JdbcType.INTEGER)
    })
    public List<VideoChnInfo> getVideoChnInfo();
}
