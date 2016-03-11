package com.yl.dbtest.dao;

import com.yl.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2016/3/11.
 */
public interface UserMapper {

    @Insert("INSERT INTO users (id, name, age) VALUES (#{id}, #{name}, #{age})")
    public int addUser(User user);

    @Select("select * from users where id=#{id}")
    public User getUserById(int id);

    @Select("select * from users")
   /* @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age")
    })*/
    public List<User> getAllUsers();
}
