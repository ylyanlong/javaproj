package com.yl.datetime;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Administrator on 2016/4/20.
 */
public class DateCompare {
    public static void main(String[] args){
        // 字符串不支持 > 符号比较; 最理想的情况是转为时间戳比较
        String dateStr1 = "2016-04-20 12:29:00";
        String dateStr2 = "2016-04-20 12:30:00";
        try {
            Date date1 = DateUtils.parseDate(dateStr1, "yyyy-MM-dd HH:mm:ss");
            Date date2 = DateUtils.parseDate(dateStr2, "yyyy-MM-dd HH:mm:ss");

            if(date1.before(date2)){  // 相等时，返回的是false
                System.out.println("date1.before(date2) is true");
            } else {
                System.out.println("date1.before(date2) is false");
            }

            if(date1.after(date2)){  // 相等时，返回的是 false
                System.out.println("date1.after(date2) is true");
            } else {
                System.out.println("date1.after(date2) is false");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dateStr3 = "2016-04-20 12:47:51";
        try {
            // 细节: ss 可以是 51 ，但不可以是其它数字会报错，为 51 会解析为00；
            // 最好是用 "yyyy-MM-dd HH:mm:ss" 标准格式，在 format 里面转吧
            Date date3 = DateUtils.parseDate(dateStr3, "yyyy-MM-dd HH:mm:51");
            System.out.println("date3: " + date3);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*String dateStr4 = "20160420124751";
        try {
            Date date4 = DateUtils.parseDate(dateStr4, "yyyyMMddHHmmss");
            System.out.println("date4: " + date4);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

    }
}
