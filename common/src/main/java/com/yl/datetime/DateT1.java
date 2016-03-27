package com.yl.datetime;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by leon on 2015/7/14.
 */
public class DateT1 {
    public static int getDaySumMin(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(date);
        int hour = Integer.parseInt(dateStr.substring(11, 13));
        System.out.println("hour: " + hour);
        int min = Integer.parseInt(dateStr.substring(14, 16));
        System.out.println("min: " + min);
        int sumMin = hour * 60 + min;
        return sumMin;
    }

    public static void main(String[] args){
        System.out.println("curTime:" + System.currentTimeMillis() );
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        System.out.println("ts: " + ts.getTime());
        Date mydate = new Date();
        System.out.println("datetime str: " + mydate.toString() );
        System.out.println("milliseconds: " + mydate.getTime() );

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(mydate);
        String dateStrSec = dateStr.substring(0, 17) + "00";
        System.out.println("dateStrSec: " + dateStrSec);
        System.out.println(dateStr);

        Long time = 1442815200L;
        Date mydate2 = new Date(time * 1000);
        System.out.println("mydate2: " + dateFormat.format(mydate2));

        String dateStr1 = "2015-09-17 12:30:00";
        String dateStr2 = "2015-09-17 12:30:00";
        String dateStr3 = "2015-10-08 00:00:23";

        DateFormat dateFormatNum = new SimpleDateFormat("yyyyMMddHHmmss");

        try {
            Date dateFromStr1 = dateFormat.parse(dateStr1);
            Date dateFromStr2 = dateFormat.parse(dateStr2);
            Date dateFromStr3 = dateFormat.parse(dateStr3);
            System.out.println("dateFromStr1: " + dateFromStr1.toString());
            System.out.println("dateFromStr2: " + dateFromStr2);
            System.out.println("dateFromStr3: " + dateFromStr3.getTime());


            // System.out.println("dateFormatNum: " + dateFormatNum.format(dateFromStr3) );
            String dateTimeNum = dateFormatNum.format(dateFromStr3);
            String dateNum = dateTimeNum.substring(0, 8);
            System.out.println("dateNum: " + dateNum);
            String timeNum = dateTimeNum.substring(8);
            System.out.println("timeNum: " + timeNum);

            int sumMin = getDaySumMin(dateFromStr3);
            System.out.println("sumMin: " + sumMin);

            if(dateFromStr1.after(dateFromStr2)){
                System.out.println("dateFromStr1 after dateFromStr2");
            }
            else {
                System.out.println("dateFromStr2 after dateFromStr1");
            }

            if(dateFromStr1.before(dateFromStr2) ){
                System.out.println("dateFromStr1 before dateFromStr2");
            }
            else {
                System.out.println("dateFromStr1 not before dateFromStr2");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        // cal.add(Calendar.MINUTE, -20);
        System.out.println("hour: " + cal.get(Calendar.HOUR_OF_DAY) ) ;
        System.out.println("min: " + cal.get(Calendar.MINUTE));
        System.out.println("second:" + cal.get(Calendar.SECOND));
        Date date5 = cal.getTime();
        System.out.println("time5: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date5));

    }// end main
}
