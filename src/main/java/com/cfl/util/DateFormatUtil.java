package com.cfl.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 日期转换
* */
public class DateFormatUtil {
    public static Date StringToDate(String dt){

        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;

        try {

            date = format1.parse(dt);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;

    }

    public static String  DateToString(Date date){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = formatter.format(date);

        return dateString;

    }
}
