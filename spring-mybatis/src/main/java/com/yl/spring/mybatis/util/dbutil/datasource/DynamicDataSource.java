package com.yl.spring.mybatis.util.dbutil.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.LinkedList;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSource.class);

    private Map<Object, Object> dataSources;

    private static final String DEFAULT = "default";

    private static final ThreadLocal<LinkedList<String>> datasourceHolder = new ThreadLocal<LinkedList<String>>() {

        @Override
        protected LinkedList<String> initialValue() {
            return new LinkedList<String>();
        }

    };

    @Override
    public void afterPropertiesSet() {
        if (null == dataSources) {
            throw new IllegalArgumentException("Property 'dataSources' is required");
        }
        if (null == dataSources.get(DEFAULT)) {
            throw new IllegalArgumentException("key:'default' must be setted in Property 'dataSources'");
        }
        this.setDefaultTargetDataSource(dataSources.get(DEFAULT));
        this.setTargetDataSources(dataSources);
        super.afterPropertiesSet();
    }

    public static void use(String key) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("use datasource :" + datasourceHolder.get());
        }
        LinkedList<String> m = datasourceHolder.get();
        m.offerFirst(key);
    }

    public static void reset() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("reset datasource ");
        }
        LinkedList<String> m = datasourceHolder.get();
        if (m.size() > 0) {
            m.poll();
        }
    }

    @Override
    protected Object determineCurrentLookupKey() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("currenty datasource :" + datasourceHolder.get());
        }
        LinkedList<String> m = datasourceHolder.get();
        return m.peekFirst() == null ? "" : m.peekFirst();
    }

    public Map<Object, Object> getDataSources() {
        return dataSources;
    }

    public void setDataSources(Map<Object, Object> dataSources) {
        this.dataSources = dataSources;
    }

}
