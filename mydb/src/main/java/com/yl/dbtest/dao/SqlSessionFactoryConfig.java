package com.yl.dbtest.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by Administrator on 2015/10/30.
 */
public class SqlSessionFactoryConfig {
    private static final Logger LOG = LoggerFactory.getLogger(SqlSessionFactoryConfig.class);

    private static final String DBCONFIG_STATACT = "statisact-db-config.xml";
//    private static final String DBCONFIG_HIIDOSHOW = "hiido_show-db-config.xml";

    private static SqlSessionFactory sqlSessionFactory_statact = null;
    private static SqlSessionFactory sqlSessionFactory_hiidoshow = null;

    static {
        try {
            String resource = DBCONFIG_STATACT;
            InputStream inputStream = Resources.getResourceAsStream(resource);  // throw IOException
            sqlSessionFactory_statact = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            LOG.error("stat_act resource path error");
        }

        /*try {
            String resource = DBCONFIG_HIIDOSHOW;
            InputStream inputStream = Resources.getResourceAsStream(resource);  // throw IOException
            sqlSessionFactory_hiidoshow = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            LOG.error("hiido_show resource path error");
        }*/
    }

    private SqlSessionFactoryConfig(){
        LOG.info("SqlSessionFactoryConfig exec");
    }

    public static SqlSessionFactory getSqlSessionFactory_statact(){
        return sqlSessionFactory_statact;
    }

//    public static SqlSessionFactory getSqlSessionFactory_hiidoshow(){
//        return sqlSessionFactory_hiidoshow;
//    }

}
