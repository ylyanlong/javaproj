package com.yl.dbtest.biz;

import com.yl.dbtest.dao.StatKeyDao;
import com.yl.entity.StatKey1dInfo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/9.
 */
public class MyDBTest {
    public static void main(String[] args){
        /*List<StatKey1dInfo> keyInfo = new LinkedList<>();
        keyInfo.add(new StatKey1dInfo("2015-12-09 12:01:00", "KEY_DB_TEST", 1) );
        keyInfo.add(new StatKey1dInfo("2015-12-09 12:02:00", "KEY_DB_TEST", 2) );

        keyInfo.add(new StatKey1dInfo("2015-12-09 12:03:00", "KEY_DB_TEST", 3) );
        keyInfo.add(new StatKey1dInfo("2015-12-09 12:04:00", "KEY_DB_TEST", 4) );
        keyInfo.add(new StatKey1dInfo("2015-12-09 12:05:00", "KEY_DB_TEST", 5) );
        keyInfo.add(new StatKey1dInfo("2015-12-09 12:06:00", "KEY_DB_TEST", 6) );
        keyInfo.add(new StatKey1dInfo("2015-12-09 12:07:00", "KEY_DB_TEST", 7) );*/


        StatKeyDao statKeyDao = new StatKeyDao();
        // Integer age = statKeyDao.dbGetUserAge(9981);
        for(int i = 0; i < 50; ++i){
            Integer age = statKeyDao.dbGetUserAge(9981);
            System.out.println("age: " + age);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // statKeyDao.dbBatchUpdateStat1dkey(keyInfo);
    }
}
