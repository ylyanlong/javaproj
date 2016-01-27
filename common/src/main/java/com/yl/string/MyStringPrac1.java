package com.yl.string;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class MyStringPrac1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "123456789";  // commit from laptop  add second commit
		System.out.println(str1.substring(3, 7) );  // ???

		String orderid = "201601211541570002RTTZMSZ";
		System.out.println("orderid time:" + orderid.substring(0, 14));

		Date orderidDate = null;
		try {
			orderidDate = DateUtils.parseDate(orderid.substring(0, 14), "yyyyMMddHHmmss");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String rtn = null;
		rtn = DateFormatUtils.format(orderidDate, "yyyy-MM-dd HH:mm:ss");
		System.out.println("rtn:" + rtn);

	}

}
