package com.yl.timer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        // timer.schedule(new TimerTaskTest(), 2000, 2000);

        //-------------指定时间--begin-----------------------------
        /*String date = "2016-07-08 15:50:00";
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = null;
        try {
            datetime = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("ParseException error");
        }

        timer.schedule(new TimerTaskTest(), datetime);*/
        //-------------指定时间--end-----------------------------

        //-------------周期性--begin-----------------------------
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天
        //定制每天的21:09:00执行，
        calendar.set(year, month, day, 16, 10, 0);
        Date date = calendar.getTime();
        System.out.println(date);
        final int PERIOD = 1000 * 60 * 60 * 24;
        // timer.schedule(new TimerTaskTest(), date, 2 * 1000);
        timer.schedule(new TimerTaskTest(), date, PERIOD);
        //-------------周期性--end-------------------------------

        System.out.println("exit");
    }
}


