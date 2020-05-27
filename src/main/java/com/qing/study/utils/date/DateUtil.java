package com.qing.study.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    public static final String FORMATE_DAY_0 = "yyyyMMdd";
    public static final String FORMATE_DAY_1 = "yyyy-MM-dd";

    public static final String FORMATE_SECOND_0 = "yyyyMMddHHmmss";
    public static final String FORMATE_SECOND_1 = "yyyyMMdd HHmmss";
    public static final String FORMATE_SECOND_2 = "yyyy-MM-dd HH:mm:ss";

    public static Long getNowLong() {
        return System.currentTimeMillis();
    }

    /**
     * 返回现在date
     * @return
     */
    public static Date getNowDate() {
        return changeTimestampToDate(getNowLong());
    }

    /**
     * 返回指定格式现在时间
     * @param format
     * @return
     * @throws Exception
     */
    public static Date getNowFormat(String format) throws Exception {
        return changeStrToDate(
                changeDateToStr(
                        getNowDate(),
                        format
                ),
                format
        );
    }

    /**
     * 返回现在天
     * @return
     * @throws Exception
     */
    public static Date getNowDay() throws Exception {
        return getNowFormat(FORMATE_DAY_1);
    }

    public static String getNowStr(String formate) {
        return getNowStr(getFormat(formate));
    }

    public static String getNowStr(SimpleDateFormat formate) {
        return changeTimestampToStr(getNowLong(), formate);
    }

    /**
     * 获取SimpleDateFormat
     * @param formate
     * @return
     */
    public static SimpleDateFormat getFormat(String formate) {
        return new SimpleDateFormat(formate);
    }

    /**
     * date - str
     * @param date
     * @param format
     * @return
     */
    public static String changeDateToStr(Date date, String format) {
        return changeDateToStr(date, getFormat(format));
    }

    public static String changeDateToStr(Date date, SimpleDateFormat sdf) {
        return sdf.format(date);
    }

    /**
     * date - tt
     * @param date
     * @return
     */
    public static Long changeDateToTimestamp(Date date) {
        return date.getTime();
    }

    /**
     * str - date
     * @param str
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date changeStrToDate(String str, String format) throws ParseException {
        return changeStrToDate(str, getFormat(format));
    }

    public static Date changeStrToDate(String str, SimpleDateFormat sdf) throws ParseException {
        return sdf.parse(str);
    }

    /**
     * str - tt
     * @param str
     * @param format
     * @return
     *      毫秒
     * @throws ParseException
     */
    public static Long changeStrToTimestamp(String str, String format) throws ParseException {
        return changeStrToTimestamp(str, getFormat(format));
    }

    public static Long changeStrToTimestamp(String str, SimpleDateFormat sdf) throws ParseException {
        return changeDateToTimestamp(changeStrToDate(str, sdf));
    }

    /**
     * str - str
     * @param str
     * @param formatFrom
     * @param formatTo
     * @return
     */
    public static String changeStrFormat1ToFormat2(String str, String formatFrom, String formatTo) throws ParseException {
        return changeStrFormat1ToFormat2(str, getFormat(formatFrom), getFormat(formatTo));
    }

    public static String changeStrFormat1ToFormat2(String str, SimpleDateFormat formatFrom, SimpleDateFormat formatTo) throws ParseException {
        return changeDateToStr(
                changeStrToDate(str, formatFrom),
                formatTo
        );
    }

    /**
     * tt - date
     * @param tt
     * @return
     */
    public static Date changeTimestampToDate(Long tt) {
        return new Date(tt);
    }

    /**
     * tt - str
     * @param tt
     * @param format
     * @return
     */
    public static String changeTimestampToStr(Long tt, String format) {
        return changeTimestampToStr(tt, getFormat(format));
    }

    public static String changeTimestampToStr(Long tt, SimpleDateFormat format) {
        return changeDateToStr(changeTimestampToDate(tt), format);
    }

    /**
     * 获取时间范围列表
     * @param begin
     * @param end
     * @return
     */
    public static List<String> getDateRangeList(String begin, String end, String formatBegin, String formatEnd, String formatPrint, int addSecond) throws ParseException {
        return getDateRangeList(
                changeStrToDate(begin, formatBegin),
                changeStrToDate(end, formatEnd),
                formatPrint,
                addSecond
        );
    }

    public static List<String> getDateRangeList(String begin, String end, SimpleDateFormat formatBegin, SimpleDateFormat formatEnd, SimpleDateFormat formatPrint, int addSecond) throws ParseException {
        return getDateRangeList(
                changeStrToDate(begin, formatBegin),
                changeStrToDate(end, formatEnd),
                formatPrint,
                addSecond
        );
    }

    public static List<String> getDateRangeList(String begin, String end, String formatParma, String formatPrint, int addSecond) throws ParseException {
        return getDateRangeList(begin, end, formatParma, formatParma, formatPrint, addSecond);
    }

    public static List<String> getDateRangeList(String begin, String end, String format, int addSecond) throws ParseException {
        return getDateRangeList(begin, end, format, format, format, addSecond);
    }

    public static List<String> getDateRangeList(Date dateBegin, Date dateEnd, String formatPrint, int addSecond) throws ParseException {
        return getDateRangeList(
                dateBegin,
                dateEnd,
                getFormat(formatPrint),
                addSecond
        );
    }

    public static List<String> getDateRangeList(Date dateBegin, Date dateEnd, SimpleDateFormat sdfPrint, int addSecond) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateBegin);
        List<String> res = new ArrayList<>();
        while (cal.getTime().before(dateEnd)) {
            res.add(
                    sdfPrint.format(cal.getTime())
            );
            cal.add(Calendar.SECOND, addSecond);
        }
        return res;
    }

    /**
     * 加 day
     * @param begin
     * @param end
     * @param format
     * @return
     * @throws ParseException
     */
    public static List<String> getDateRangeDayList(String begin, String end, String format) throws ParseException {
        return getDateRangeList(begin, end, format, format, format, 60*60*24);
    }

    public static List<String> getDateRangeDayList(String begin, String end, SimpleDateFormat format) throws ParseException {
        return getDateRangeList(begin, end, format, format, format, 60*60*24);
    }

    public static List<String> getDateRangeDayList(String begin, String end, SimpleDateFormat format, SimpleDateFormat printformat) throws ParseException {
        return getDateRangeList(begin, end, format, format, printformat, 60*60*24);
    }

    public static List<String> getDateRangeDayList(Date begin, Date end, String formatPrint) throws ParseException {
        return getDateRangeList(begin, end, formatPrint, 60*60*24);
    }

    public static List<String> getDateRangeDayList(Date begin, Date end, SimpleDateFormat formatPrint) throws ParseException {
        return getDateRangeList(begin, end, formatPrint, 60*60*24);
    }

    /**
     * + 小时
     * @param begin
     * @param end
     * @param format
     * @return
     * @throws ParseException
     */
    public static List<String> getDateRangeHourList(String begin, String end, String format) throws ParseException {
        return getDateRangeList(begin, end, format, format, format, 60*60);
    }

    /**
     * 判断是否在指定时间范围内
     * @return
     */
    public static boolean isBetween(String begin, String end, String val, String format, boolean leftClose, boolean rightClose) throws Exception {
        SimpleDateFormat sdf = getFormat(format);
        return isBetween(
                changeStrToDate(begin, sdf),
                changeStrToDate(end, sdf),
                changeStrToDate(val, sdf),
                leftClose,
                rightClose
        );
    }

    public static boolean isBetween(Date begin, Date end, Date date, boolean leftClose, boolean rightClose) {
        boolean left = false;
        boolean right = false;
        if (leftClose) {
            left = !date.before(begin);
        } else {
            left = date.after(begin);
        }
        if (rightClose) {
            right = !date.after(end);
        } else {
            right = date.before(end);
        }
        return left && right;
    }

    /**
     * 排序时间
     * @param dates
     * @return
     */
    public static List<Date> sortDates(List<Date> dates, boolean asc) {
        for (int i=1; i<dates.size(); i++) {
            int j = i;
            Date th = dates.get(j);
            for (j=i; j>0; j--) {
                boolean isContinue = false;
                if (asc) {
                    if (dates.get(j-1).after(th)) {
                        isContinue = true;
                    }
                } else {
                    if (dates.get(j-1).before(th)) {
                        isContinue = true;
                    }
                }
                if (isContinue) {
                    dates.set(j, dates.get(j-1));
                } else {
                    break;
                }
            }
            if (j < i) {
                dates.set(j, th);
            }
        }
        return dates;
    }

    public static List<String> sortDates(List<String> strs, SimpleDateFormat format, boolean asc) throws Exception {
        List<Date> dates = new ArrayList<>();
        for (String str : strs) {
            dates.add(changeStrToDate(str, format));
        }
        dates = sortDates(dates, asc);
        List<String> res = new ArrayList<>();
        for (Date d : dates) {
            res.add(changeDateToStr(d, format));
        }
        return res;
    }

    public static List<String> sortDates(List<String> strs, String format, boolean asc) throws Exception {
        return sortDates(strs, getFormat(format), asc);
    }
}
