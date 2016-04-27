package com.yl.dbtest.dao;

import com.yl.common.SplitList;
import com.yl.dbtest.constants.DbtestConstants;
import com.yl.entity.StatKey1dInfo;
import com.yl.mappers.statact.StatKeyMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/9.
 */
public class StatKeyDao {
    private static final Logger LOG = LoggerFactory.getLogger(StatKeyDao.class);

    static SqlSession sqlSession_test = SqlSessionFactoryConfig.getSqlSessionFactory_statact().openSession();

    public Integer dbGetUserAge(int id){
        SqlSession sqlSession = null;

        Integer age = null;
        try {
            // sqlSession = SqlSessionFactoryConfig.getSqlSessionFactory_statact().openSession();
            // StatKeyMapper statKeyMapper = sqlSession.getMapper(StatKeyMapper.class);
            sqlSession_test = SqlSessionFactoryConfig.getSqlSessionFactory_statact().openSession();
            StatKeyMapper statKeyMapper = sqlSession_test.getMapper(StatKeyMapper.class);
            age = statKeyMapper.getAgeById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // sqlSession.close();
            sqlSession_test.close();
        }

        return age;
    }

    public void dbBatchUpdateStat1dkeyTest(List<StatKey1dInfo> dataList){
        SqlSession sqlSession = null;

        List<StatKey1dInfo> tempdataList = new LinkedList<>();

        int count = 0;
        int size = dataList.size();
        for(StatKey1dInfo ele: dataList){
            tempdataList.add(ele);
            ++count;

            if((count % DbtestConstants.BATCH_INSERT_NUM == 0) || (count == size)){

                LOG.info("-------begin-print----------");
                for(StatKey1dInfo obj: tempdataList){
                    LOG.info("obj: {}", obj.toString() );
                }
                LOG.info("-------end-print----------");

                try {
                    sqlSession = SqlSessionFactoryConfig.getSqlSessionFactory_statact().openSession();
                    StatKeyMapper statKeyMapper = sqlSession.getMapper(StatKeyMapper.class);
                    statKeyMapper.batchInsertStatKey1d(tempdataList);
                    sqlSession.commit();
                } catch (PersistenceException e) {
                    LOG.error("PersistenceException error: {}", e.getMessage());
                } finally {
                    sqlSession.close();
                }

                tempdataList.clear();
            }

        }
    }//end

    public void dbBatchUpdateStat1dkey(List<StatKey1dInfo> dataList){
        SqlSession sqlSession = null;

        List<ArrayList<StatKey1dInfo> > listInfo = new SplitList<StatKey1dInfo>().splitList(dataList, DbtestConstants.BATCH_INSERT_NUM);

        for(ArrayList<StatKey1dInfo> ele: listInfo){
            try {
                sqlSession = SqlSessionFactoryConfig.getSqlSessionFactory_statact().openSession();
                StatKeyMapper statKeyMapper = sqlSession.getMapper(StatKeyMapper.class);
                statKeyMapper.batchInsertStatKey1d(ele);
                sqlSession.commit();
            } catch (PersistenceException e) {
                LOG.error("PersistenceException error: {}", e.getMessage());
            } finally {
                sqlSession.close();
            }
        }

    }//end
}
