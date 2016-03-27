package com.yl.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by leon on 2015/7/14.
 */
public class DateT2 {
    public static void main(String[] args){
        System.out.println("curTime:" + System.currentTimeMillis() );
        Date mydate = new Date();
        System.out.println("datetime str: " + mydate.toString() );
        System.out.println("milliseconds: " + mydate.getTime() );

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(mydate);
        System.out.println(dateStr);

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date tmpDate = dateFormat2.parse("2016-03-01 00:00:03");
            System.out.println("time: " + tmpDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Calendar cal = Calendar.getInstance();
        System.out.println("second:" + cal.get(Calendar.SECOND));
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("second2:" + cal.get(Calendar.SECOND));

    }
}
