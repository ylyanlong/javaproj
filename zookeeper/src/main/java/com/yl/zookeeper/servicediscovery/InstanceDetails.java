package com.yl.zookeeper.servicediscovery;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by Administrator on 2016/7/5.
 */
@JsonRootName("detail")
public class InstanceDetails {
    private String serverName;
    private String id;
    private String ip;
    private int port;

    public InstanceDetails() {
    }

    public InstanceDetails(String serverName, String id, String ip, int port) {
        this.serverName = serverName;
        this.id = id;
        this.ip = ip;
        this.port = port;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "InstanceDetails{" +
                "serverName='" + serverName + '\'' +
                ", id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}
