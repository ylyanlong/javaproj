package com.yl.map;

import com.yl.entity.User;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.map.LazyMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yanlong on 2016/4/1.
 * 怎样评估性能好坏
 *  http://commons.apache.org/proper/commons-collections/javadocs/api-release/index.html
 *  http://commons.apache.org/proper/commons-collections/javadocs/api-release/org/apache/commons/collections4/map/LazyMap.html
 */
public class LazyMapT1 {
    public static void main(String[] args){
        Factory<User> factory = new Factory() {
            @Override
            public Object create() {
                return new User();
            }
        };

        Map<Integer, User> lazyMap = LazyMap.lazyMap(new HashMap<Integer, User>(), factory);
        /*User user = lazyMap.get(23);
        System.out.println("user:" + user);*/
        lazyMap.get(456).setAge(56);
        lazyMap.get(6843).setAge(26);

        for(Map.Entry<Integer, User> ele: lazyMap.entrySet()){
            System.out.println(ele.getKey() + " : " + ele.getValue().toString() );
        }


    }
}
