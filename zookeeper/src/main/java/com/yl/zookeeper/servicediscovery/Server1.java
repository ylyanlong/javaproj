package com.yl.zookeeper.servicediscovery;

import com.yl.zookeeper.biz.ZkCommon;
import com.yl.zookeeper.util.CuratorUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.UriSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/5.
 */
public class Server1 {
    private static final Logger LOG = LoggerFactory.getLogger(Server1.class);

    public static void main(String[] args){
        CuratorUtil curatorUtil = new CuratorUtil(ZkCommon.ZKADDRESS);

        // putAndConsumeMsg(curatorUtil.getCuratorFramework(), "/ylzktest/queue");
        ServiceRegistrar serviceRegistrar = new ServiceRegistrar(curatorUtil.getCuratorFramework(), "ylservices");
        ServiceInstance<InstanceDetails> instance = null;
        try {
            instance = ServiceInstance.<InstanceDetails>builder()
                    .name("myservice")
                    .port(33333)
                    .address("172.19.43.162")
                    .payload(new InstanceDetails("statbg", "10005", "172.19.43.162", 33333))
                    .uriSpec(new UriSpec("{scheme}://{address}:{port}"))
                    .build();
        } catch (Exception e) {
            LOG.error("ServiceInstance builder Exception:{}", ExceptionUtils.getStackTrace(e));
        }

        serviceRegistrar.registerService(instance);

        try {
            TimeUnit.SECONDS.sleep(180);
        } catch (InterruptedException e) {
            LOG.error("sleep InterruptedException:{}", ExceptionUtils.getStackTrace(e));
        }

        serviceRegistrar.unregisterService(instance);
        LOG.info("preparing close.......");
        curatorUtil.destroy();
        LOG.info("zookeeper closed");
    }

}
