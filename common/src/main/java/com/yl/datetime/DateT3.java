package com.yl.datetime;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Administrator on 2016/3/30.
 */
public class DateT3 {
    public static void main(String[] args){
        long minuteNum = 0L;
        try {
            // Date minDate = DateUtils.parseDate("20160330230400", "yyyyMMddHHmm00");
            Date minDate = DateUtils.parseDate("20160330230400", "yyyyMMddHHmmss");
            minuteNum = minDate.getTime();
        } catch (ParseException e) {
            System.out.println("DateUtils ParseException" + e.getMessage());
        }

        System.out.println("minuteNum:" + minuteNum);
        System.out.println("minuteNum time:" + DateFormatUtils.format(new Date(minuteNum), "yyyy-MM-dd HH:mm:ss"));


        // 说明 DateFormatUtils 可以使用格式化的 描述串，比如含有 00 的；但 DateUtils 的 parse 函数不可以用 含零的串
        // 从本质意义上将，DateUtil 的 parse 描述串功能专一，就是用来讲清楚 是怎样一个格式的.
        String timeNum = DateFormatUtils.format(new Date(), "yyyyMMddHHmm00");
        System.out.println("timeNum:" + timeNum);
    }
}
