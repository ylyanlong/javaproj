package com.yl.zookeeper.biz;

import com.yl.zookeeper.util.CuratorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/8/26.
 */
public class StormCat {
    private static final Logger LOG = LoggerFactory.getLogger(CuratorTest.class);

    public static void main(String[] args){
        CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);

        //--------------------------------------------
        // get 节点信息
        String value = curatorUtil.getNodeValue("/storm/supervisors/211d6ece-8f58-4909-8291-d1c041163f91");
        LOG.info("value:{}", value );
        // LOG.info("value:{}", str2HexStr(value) );
        // LOG.info("value:{}", value.getBytes());

        ////
        /*String value = curatorUtil.getNodeValue("/ylzktest/counter");
        LOG.info("value size:{}", value.length());
        LOG.info("value:{}", value.getBytes());*/
        //--------------------------------------------

        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");

    }

    public static String str2HexStr(String str)
    {

        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;

        for (int i = 0; i < bs.length; i++)
        {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }

}
