package com.yl.zookeeper.servicediscovery;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2016/7/5.
 */
public class ServiceRegistrar {
    private static final Logger LOG = LoggerFactory.getLogger(ServiceRegistrar.class);

    private ServiceDiscovery<InstanceDetails> serviceDiscovery;
    private CuratorFramework client;

    public ServiceRegistrar(CuratorFramework client, final String basePath){
        this.client = client;
        JsonInstanceSerializer<InstanceDetails> serializer = new JsonInstanceSerializer<InstanceDetails>(InstanceDetails.class);
        serviceDiscovery = ServiceDiscoveryBuilder.builder(InstanceDetails.class)
                .client(client)
                .serializer(serializer)
                .basePath(basePath)
                .build();
        try {
            serviceDiscovery.start();
        } catch (Exception e) {
            LOG.info("ServiceRegistrar start() Exception:{}", ExceptionUtils.getStackTrace(e));
        }
    }

    public void registerService(ServiceInstance<InstanceDetails> serviceInstance){
        try {
            serviceDiscovery.registerService(serviceInstance);
        } catch (Exception e) {
            LOG.error("registerService Exception:{}", ExceptionUtils.getStackTrace(e));
        }
    }

    public void unregisterService(ServiceInstance<InstanceDetails> serviceInstance){
        try {
            serviceDiscovery.unregisterService(serviceInstance);
        } catch (Exception e) {
            LOG.error("unregisterService Exception:{}", ExceptionUtils.getStackTrace(e));
        }
    }

    public void updateService(ServiceInstance<InstanceDetails> serviceInstance){
        try {
            serviceDiscovery.updateService(serviceInstance);
        } catch (Exception e) {
            LOG.error("updateService Exception:{}", ExceptionUtils.getStackTrace(e));
        }
    }

    public void close(){
        try {
            serviceDiscovery.close();
        } catch (IOException e) {
            LOG.error("close IOException:{}", ExceptionUtils.getStackTrace(e));
        }
    }

}
