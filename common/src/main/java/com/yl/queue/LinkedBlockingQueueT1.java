package com.yl.queue;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2016/2/20.
 */
public class LinkedBlockingQueueT1 {
    public static void main(String[] args){
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        try {
            queue.put(34);
            queue.put(2);
            queue.put(45);
            queue.put(52);
            queue.put(67);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("begin take");
        int ele = 0;
        try {
            ele = queue.take();
            System.out.println("ele:" + ele);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()){
            ele = iterator.next();
            System.out.println("num: " + ele);
            if(ele == 52){
                queue.remove(ele);
            }
        }

        Iterator<Integer> ite = queue.iterator();
        while (ite.hasNext()){
            System.out.println("cur num: " + ite.next());
        }

        System.out.println("end");
    }
}
