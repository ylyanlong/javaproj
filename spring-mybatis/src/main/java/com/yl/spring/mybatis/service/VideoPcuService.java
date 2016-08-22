package com.yl.spring.mybatis.service;

import com.yl.spring.mybatis.dao.DBNames;
import com.yl.spring.mybatis.dao.VideoPcuDao;
import com.yl.spring.mybatis.entity.VideoChnInfo;
import com.yl.spring.mybatis.util.dbutil.datasource.DynamicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2016/6/22.
 */
@Service
public class VideoPcuService {
    private static final Logger LOG = LoggerFactory.getLogger(VideoPcuService.class);

    @Autowired
    private VideoPcuDao videoPcuDao;

    public void getUid2numInfo(){
        DynamicDataSource.use(DBNames.STATACT);
        List<VideoChnInfo> videoChnInfoList = videoPcuDao.getVideoChnInfo();

        for(VideoChnInfo videoChnInfo: videoChnInfoList){
            LOG.info("ele:{}", videoChnInfo.toString());
        }
    }

}
