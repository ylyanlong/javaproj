package com.yl.common;

import com.yl.entity.StatKey1dInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/9.
 */
public class SplitList<E> {
    private static final Logger LOG = LoggerFactory.getLogger(SplitList.class);

    public  List<ArrayList<E> > splitList(List<E> inputList, final int splitsize){
        // ArrayList<ArrayList<E> > rtnList = new ArrayList<ArrayList<E> >();
        List<ArrayList<E> > rtnList = new ArrayList<ArrayList<E> >();

        ArrayList<E> tempdataList = new ArrayList<>();

        int count = 0;
        int size = inputList.size();
        for(E ele: inputList){
            tempdataList.add(ele);
            ++count;

            if((count % splitsize == 0) || (count == size)){

                LOG.info("-------begin-print----------");
                for(E obj: tempdataList){
                    LOG.info("obj: {}", obj.toString() );
                }
                LOG.info("-------end-print----------");
                rtnList.add(new ArrayList<E>(tempdataList) );

                tempdataList.clear();
            }

        }

        return rtnList;
    }

    public static void main(String[] args){
        List<StatKey1dInfo> keyInfo = new LinkedList<>();
        keyInfo.add(new StatKey1dInfo("2015-12-09 12:01:00", "KEY_DB_TEST", 1) );
        keyInfo.add(new StatKey1dInfo("2015-12-09 12:02:00", "KEY_DB_TEST", 2) );
        /*keyInfo.add(new StatKey1dInfo("2015-12-09 12:03:00", "KEY_DB_TEST", 3) );

        keyInfo.add(new StatKey1dInfo("2015-12-09 12:04:00", "KEY_DB_TEST", 4) );
        keyInfo.add(new StatKey1dInfo("2015-12-09 12:05:00", "KEY_DB_TEST", 5) );
        keyInfo.add(new StatKey1dInfo("2015-12-09 12:06:00", "KEY_DB_TEST", 6) );
        keyInfo.add(new StatKey1dInfo("2015-12-09 12:07:00", "KEY_DB_TEST", 7) );*/

        List<ArrayList<StatKey1dInfo> > listInfo = new SplitList<StatKey1dInfo>().splitList(keyInfo, 3);
        for(ArrayList<StatKey1dInfo> ele: listInfo){
            LOG.info("-------------SplitList-begin-----------------");
            for(StatKey1dInfo obj: ele){
                LOG.info("ele: {}", obj.toString());
            }
            LOG.info("-------------SplitList-end-----------------");
        }

    }
}
