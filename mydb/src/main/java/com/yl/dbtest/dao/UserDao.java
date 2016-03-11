package com.yl.dbtest.dao;

import com.yl.entity.User;
import com.yl.mappers.statact.StatKeyMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2016/3/11.
 */
public class UserDao {
    private static final Logger LOG = LoggerFactory.getLogger(UserDao.class);

    public static void main(String[] args){
        // User user = new User(11, "张三", 14);
        // User user = new User(21, "张三", 13);
        // insertUser(user);

        // user = queryUserById(11);
        //
        // LOG.info("user:{}", user.toString());
        List<User> users = queryAllUsers();
        for(User ele: users){
            LOG.info("ele:{}", ele.toString());
        }
    }

    public static boolean insertUser(User user){
        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryConfig.getSqlSessionFactory_statact().openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.addUser(user);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOG.error("PersistenceException error: {}", e.getMessage());
        } finally {
            sqlSession.close();
        }

        return true;
    }

    public static User queryUserById(int id){
        SqlSession sqlSession = null;
        User user = null;

        try {
            sqlSession = SqlSessionFactoryConfig.getSqlSessionFactory_statact().openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user = userMapper.getUserById(id);
        } catch (PersistenceException e) {
            LOG.error("PersistenceException error: {}", e.getMessage());
        } finally {
            sqlSession.close();
        }

        return user;
    }

    public static List<User> queryAllUsers(){
        SqlSession sqlSession = null;
        List<User> users = null;

        try {
            sqlSession = SqlSessionFactoryConfig.getSqlSessionFactory_statact().openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            users = userMapper.getAllUsers();
        } catch (PersistenceException e) {
            LOG.error("PersistenceException error: {}", e.getMessage());
        } finally {
            sqlSession.close();
        }

        return users;
    }
}
