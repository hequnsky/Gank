package com.zhq.gank.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：hequnsky on 2016/8/4 10:39
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class DateUtil {
	/*
	 *
	 * 时间戳工具类
	 */

    private static SimpleDateFormat sf = null;

    /* 获取系统时间 格式为："yyyy/MM/dd " */
    public static String getCurrentDate() {
        Date d = new Date();
        sf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒SSS毫秒");
        return sf.format(d);
    }

    /* 时间戳转换成字符窜 */
    public static String getDateToString(long time) {
        Date d = new Date(time);
        sf = new SimpleDateFormat("yyyy年MM月dd日");
        return sf.format(d);
    }

    /* 将字符串转为时间戳 */
    public static long getStringToDate(String time) {
        sf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒SSS毫秒");
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }

}

