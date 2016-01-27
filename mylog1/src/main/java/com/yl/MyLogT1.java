package com.yl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2015/11/17.
 */
public class MyLogT1 {
    private static final Logger LOG = LoggerFactory.getLogger(MyLogT1.class);

    public static void main(String[] args){
        LOG.debug("logback debug");
        LOG.info("logback info");
        LOG.warn("logback warn");
        LOG.error("logback error");
        LOG.info("{}, [}, {}", 1, 2, 3);

        // PCOldDataImport.updatePCPCUData();
        // PCOldDataImport.updatePCMsgGotData();


    }
}
