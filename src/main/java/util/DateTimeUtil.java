package util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Description: TODO
 * <p>
 * PackageName:com.sxc.jotunheim.flinkcore.jobdemo.util
 * FileName: DateTimeUtil.java
 * Copyright: Copyright (c)2019. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2019-11-22
 */
public class DateTimeUtil {


    public final static String DATE_SEC_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Long getDayBeginMillSeconds(Date d){
        Calendar calendar = Calendar.getInstance();
        if(null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }


    public static Long convertTime(String dateStr, String format) {
        Long time = null;
        if(StringUtils.isNotEmpty(dateStr)){
            try {
                if(dateStr.indexOf(".")>-1){
                    dateStr.substring(0,dateStr.indexOf("."));

                }
                time =  DateUtils.parseDate(dateStr,format).getTime();
                return time;
            } catch (ParseException e) {
                return time;
            }
        }
        return time;
    }

    public static String longToHmsStr(Long time) {
        String dateStr = null;
        try {
            dateStr = DateFormatUtils.format(time,DATE_SEC_FORMAT);

        } catch (Exception e) {
            return dateStr;

        }
        return dateStr;
    }

    public static void main(String[] args) {
        Timestamp s = new Timestamp(0);
        System.out.print(longToHmsStr(System.currentTimeMillis()));
    }

}