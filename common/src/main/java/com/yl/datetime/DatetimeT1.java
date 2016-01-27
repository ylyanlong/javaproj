package com.yl.datetime;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Administrator on 2016/1/18.
 */
public class DatetimeT1 {
    public static void main(String[] args){
        Date date = new Date();
        System.out.println("date:" + date);
        System.out.println("format date:" + DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));
        System.out.println("format date2:" + DateFormatUtils.format(date, "yyyy-MM-dd HH:48:54"));

        Date dateChange = DateUtils.addMinutes(date, -15);
        System.out.println("dateChange: " + DateFormatUtils.format(dateChange, "yyyy-MM-dd HH:mm:ss"));

        Date dateParse = null;
        try {
            dateParse = DateUtils.parseDate("2016-01-18 00:00:00", "yyyy-MM-dd HH:mm:ss");
            // dateParse = DateUtils.parseDate("2016-01-18 00:00:00", "yyyy-MM-dd HH:48:07");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("dateParse:" + dateParse);

        String orderid = "201601210000000002RTTZMSZ";
        // Date orderidDate = DateUtils.parseDate(orderid.substring(0, 14));

    }
}
