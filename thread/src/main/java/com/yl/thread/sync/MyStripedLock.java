package com.yl.thread.sync;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/2/28.
 */
public class MyStripedLock {
    // 不用静态的，因为可能有些场合对应的是同一个id，如果用静态的，会导致多个场景返回的是同一个，相互影响。
    private ConcurrentHashMap<Integer, Integer> id2obj = new ConcurrentHashMap<>();

    public Integer getLockOjb(int id){
        if(id2obj.containsKey(id)){  // 已经有这个key
            return id2obj.get(id);
        } else {  // 没有这个 key
            // 因为整个函数没有加锁，所以各个语句可能被打断执行；如果多个线程同时 get 某个id，一开始的时候该id不在里面；
            // 如果某一个线程 更新该id成功，后续的线程不应该写覆盖了，如果这样就起不到作用了；应该试探性的更新.
            //这个类缺少清除策略，有添加动作；但没有清除动作；如果某些使用场景下会导致占用较多内存；
            // 清除策略思考，假如将每次 get 操作 时将使用计数加1；并且假设，退出同步区时，将计数减1；设置 timeout时间，
            // 超过这个时间就移除
            // 建议参考下 Gauva 里面的 Striped 的实现.
            id2obj.putIfAbsent(id, id);
            return id2obj.get(id);
        }
    }
}
