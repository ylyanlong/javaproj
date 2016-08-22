package com.yl.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/6/21.
 */
@Repository
public class RedisVideoPcuT1 {
    private static final Logger LOG = LoggerFactory.getLogger(RedisVideoPcuT1.class);
    private static final String REDIS_VIDEO_PCU_PREFIX = "videopcu_";
    private static final int TIME_OUT_SECOND = 30;

    @Autowired
    private RedisTemplate redisTemplate;

    /*@Resource(name = "redisTemplate")
    private ValueOperations<String, Integer> valueOperations;*/

    public void setVideoPcu(){
        String key = REDIS_VIDEO_PCU_PREFIX + "9090";
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        RedisSerializer<String> serializer = new StringRedisSerializer();  // 方便识别, 增加可读性
        redisTemplate.setValueSerializer(serializer);

        valueOperations.set(key, "5000", TIME_OUT_SECOND, TimeUnit.SECONDS);

        valueOperations.set("videopcu_620", "8500", TIME_OUT_SECOND, TimeUnit.SECONDS);
        valueOperations.set("videopcu_540", "3500", TIME_OUT_SECOND, TimeUnit.SECONDS);
        valueOperations.set("videopcu_8080", "12000", TIME_OUT_SECOND, TimeUnit.SECONDS);


        valueOperations.get("");//
        LOG.info("setVideoPcu done");
    }

    /**
     * key 不存在是接口返回 null,是对象，不是字符串, 如: rtn == null
     */
    public void get(){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String rtn = valueOperations.get("videopcu_770");
        if(rtn != null){
            LOG.info("get rtn:{}", rtn);
        } else {
            LOG.info("rtn == null");
        }

    }

    public void mutiGet(){
        // 入参
        List<Long> chns = new ArrayList<>();
        chns.add((long) 9090);
        chns.add((long) 540);
        chns.add((long) 8080);
        chns.add((long) 521);
        chns.add((long) 768);

        // 构造合法参数
        List<String> sids = new ArrayList<>();
        for(Long chn: chns){
            sids.add(REDIS_VIDEO_PCU_PREFIX + String.valueOf(chn));
        }
        LOG.info("mutiGet sids size:{}", sids.size());  // sids 可以直接打印出数组的内容

        // 查询
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        List<String> results = valueOperations.multiGet(sids);
        final Integer RESULT_LEN = results.size();
        LOG.info("mutiGet RESULT_LEN:{}", RESULT_LEN);

        // 拼接结果
        Map<Long, Integer> chn2num = new HashMap<>();
        Integer num = null;
        for(int i = 0; i < RESULT_LEN; ++i){
            if(null != results.get(i)){
                num = Integer.parseInt(results.get(i));
                chn2num.put(chns.get(i), num);
            } else {
                LOG.info("mutiGet input key={} value is null", chns.get(i));
            }
        }

        // 打印结果
        Set<Map.Entry<Long, Integer> > entries = chn2num.entrySet();
        for(Map.Entry<Long, Integer> entry: entries){
            LOG.info("mutiGet result, {}:{}", entry.getKey(), entry.getValue() );
        }

    }

}
