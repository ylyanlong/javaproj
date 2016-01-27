package com.yl.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by leon on 2015/10/27.
 */
public class MyAtomicLong {
    // private AtomicLong counter = new AtomicLong();

    public static void main(String[] args){
        AtomicLong counter = new AtomicLong();
        System.out.println("counter.get():" + counter.get() ); // init with 0
        System.out.println("counter.compareAndSet(0, 10):" + counter.compareAndSet(0, 10) );
        System.out.println("counter.addAndGet(3):" + counter.addAndGet(3) );  // first add then get
        System.out.println("counter.decrementAndGet():" + counter.decrementAndGet() ); // first decrement then get
        System.out.println("counter.getAndAdd(2):" + counter.getAndAdd(2) );  // get then add
        System.out.println("counter.get():" + counter.get() );
        System.out.println("counter.getAndDecrement():" + counter.getAndDecrement() );  // get then decrement
        System.out.println("counter.get():" + counter.get() );
        System.out.println("counter.getAndIncrement():" + counter.getAndIncrement() );  // get then increment
        System.out.println("counter.get():" + counter.get() );
        System.out.println("counter.getAndSet(30):" + counter.getAndSet(30) );  // get then set
        System.out.println("counter.get():" + counter.get() );
        System.out.println("counter.incrementAndGet():" + counter.incrementAndGet() );  // increment then get
        System.out.println("counter.get():" + counter.get() );

    }
}
