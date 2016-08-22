package com.yl.zookeeper.servicediscovery;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2016/7/5.
 */
public class ServiceDiscoverer {
    private static final Logger LOG = LoggerFactory.getLogger(ServiceDiscoverer.class);

    private ServiceDiscovery<InstanceDetails> serviceDiscovery;
    private Map<String, ServiceProvider<InstanceDetails> > providers = Maps.newHashMap();
    private List<Closeable> closeableList = Lists.newArrayList();
    private Object object = new Object();

    public ServiceDiscoverer(CuratorFramework client, final String basePath){

    }

}
