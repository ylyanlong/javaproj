package com.yl.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by leon on 2015/9/17.
 */
class TimerTaskTest extends TimerTask{

    @Override
    public void run() {
        System.out.println("time:" + new Date());
        System.gc();
    }
}

public class MyTimerT1 {
    public static void main(String[] args){
        // Timer timer = new Timer(true);
        Timer timer = new Timer();
        timer.schedule(new TimerTaskTest(), 2000, 2000);
        System.out.println("exit");
    }
}


