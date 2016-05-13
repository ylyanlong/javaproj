package com.yl.datetime;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
public class DatetimeUtil {
    private static final Logger LOG = LoggerFactory.getLogger(DatetimeUtil.class);

    public static void main(String[] args){
        // List<String> dateStrList = getTimePeriodByDayStep(new Date(), 10, "yyyy-MM-dd HH:mm:ss");
        List<String> dateStrList = getTimePeriodByDayStep(new Date(), 10, "yyyyMMdd");
        for(String dateStr: dateStrList){
            System.out.println("dateStr:" + dateStr);
        }
    }

    public static Date getStatTimeOffsetCurrentMin(int offsetMin){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = dateFormat.format(new Date()).substring(0, 17) + "00";
        Date dateNow = null;
        try {
            dateNow = dateFormat.parse(dateNowStr);
        } catch (ParseException e) {
            LOG.error("dateFormat.parse error");
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateNow);
        cal.add(Calendar.MINUTE, offsetMin);
        Date statTime = cal.getTime();

        return statTime;
    }

    public static List<String> getTimePeriodByDayStep(final Date beginDate, final int dayStep, final String pattern){
        if(beginDate == null){
            LOG.error("getTimePeriodByDayStep beginDate is null");
            return null;
        }

        if(dayStep < 0){
            LOG.error("getTimePeriodByDayStep dayStep < 0");
            return null;
        }

        // 结果集
        List<String> dateStrList = new ArrayList<>();

        Date tempDate = beginDate;
        for(int i = 0; i < dayStep; ++i){
            String dateStr = DateFormatUtils.format(tempDate, pattern);
            LOG.info("getTimePeriodByDayStep dateStr:{}", dateStr);
            dateStrList.add(dateStr);
            tempDate = DateUtils.addDays(tempDate, 1);
        }
        LOG.info("getTimePeriodByDayStep dateStrList size:{}", dateStrList.size());
        return dateStrList;
    }

}
