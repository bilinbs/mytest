package com.bilin.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Date;

public class TimeZoneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'H:mm:ss.SSSXXX");
		System.out.println(df.format(new Date()));
	}

}
