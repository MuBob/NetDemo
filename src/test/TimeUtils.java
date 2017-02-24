package test;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by lx on 2016/8/26.
 * 时间工具类
 */
public class TimeUtils {
 
	public static void main(String[] args) {
		DateTime d=	new TimeUtils.DateTime();
		d.setTimeStamp(String.valueOf(System.currentTimeMillis()));
		d.getWeekDay();
		System.out.println(d.getWeekDay());
//		Calendar c=Calendar.getInstance();
//		
//		c.setTimeInMillis(System.currentTimeMillis());
////		c.set(2016, 9, 15);
//		System.out.println(c.get(Calendar.DAY_OF_MONTH));
//		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(d.getWeekDayStr());
		
		
	}
//	private void mian() {
//		DateTime d=	new TimeUtils.DateTime();
//		d.setTimeStamp(String.valueOf(System.currentTimeMillis()));
//		d.getWeekDay();
//		System.out.println(d.getWeekDay());
//
//	}
    public static class DateUtil{

        private static Date preRefreshDateTime;
        public static String getTimeString(long time){
            //1获取时间戳，转换为MM-dd  格式
            //2获取系统时间，转换为MM-dd 格式
            //判断1与2的结果是否相同，是将当前时间转换为HH:mm:ss格式  否就显示MM-dd

            try {
                if (time>0) {
                    SimpleDateFormat sdf1= new SimpleDateFormat("MM-dd HH:mm");
                    String time1= sdf1.format(new Date(time));

                    SimpleDateFormat sdf2= new SimpleDateFormat("MM-dd HH:mm");
                    String time2= sdf2.format(new Date(System.currentTimeMillis()));

                    if (time1.equals(time2)) {
                        SimpleDateFormat sdf3= new SimpleDateFormat("HH:mm:ss");
                        String time3= sdf3.format(new Date(time));

                        return time3;

                    }else{
                        return time1;
                    }
                }else {

                }
            } catch (Exception e) {

            }
            return "";
        }


        public static String getTimeString4(long time){
            //1获取时间戳，转换为MM-dd  格式
            //2获取系统时间，转换为MM-dd 格式
            //判断1与2的结果是否相同，是将当前时间转换为HH:mm:ss格式  否就显示MM-dd

            try {
                if (time>0) {
                    SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String time1= sdf1.format(new Date(time));
                    return time1;

                }else {

                }
            } catch (Exception e) {

            }
            return "";
        }
//
//	public static String getTimeString(long time){
//		//1获取时间戳，转换为MM-dd  格式
//		//2获取系统时间，转换为MM-dd 格式
//		//判断1与2的结果是否相同，是将当前时间转换为HH:mm:ss格式  否就显示MM-dd
//		if (time>0) {
//			SimpleDateFormat sdf1= new SimpleDateFormat("MM-dd");
//			String time1= sdf1.format(new Date(time));
//
//			SimpleDateFormat sdf2= new SimpleDateFormat("MM-dd");
//			String time2= sdf2.format(new Date(System.currentTimeMillis()));
//
//			if (time1.equals(time2)) {
//				SimpleDateFormat sdf3= new SimpleDateFormat("HH:mm");
//				String time3= sdf3.format(new Date(time));
//
//				return time3;
//
//			}else{
//				return time1;
//			}
//
//
//
//
////			return time1;
////			return getTimeDisplay(new Date(time));
//		}else {
//			return "";
//		}
//





//		if (time>0) {
//			 SimpleDateFormat sdf= new SimpleDateFormat("MM-dd");
//			String time1= sdf.format(new Date(time));
//			return time1;
////			return getTimeDisplay(new Date(time));
//		}else {
//			return "";
//		}

//	}
        /**
         * 根据系统时间显示,返回时间
         * @param time
         * @return
         */
        public static String getTimeString2(long time){
            if (time>0) {
//			 SimpleDateFormat sdf= new SimpleDateFormat("MM-dd HH:mm:ss");
//			String time1= sdf.format(new Date(time));
//			return time1;
//			return getTimeDisplay(new Date(time));

                Calendar calendar=Calendar.getInstance();
                calendar.setTimeInMillis(time);
//			Calendar calendar=Calendar.getInstance();
//			calendar.setTimeInMillis(time);
//			String time1= sdf.format(calendar.getTime());
//			return time1;
                return getTimeDiffDesc(calendar.getTime());
            }else {
                return "";
            }

        }


        public static String getTimeStringDate(long time){
            //1获取时间戳，转换为MM-dd  格式
            //2获取系统时间，转换为MM-dd 格式
            //判断1与2的结果是否相同，是将当前时间转换为HH:mm:ss格式  否就显示MM-dd
            if (time>0) {
                SimpleDateFormat sdf1= new SimpleDateFormat("MM-dd");
                String time1= sdf1.format(new Date(time));

                SimpleDateFormat sdf2= new SimpleDateFormat("MM-dd");
                String time2= sdf2.format(new Date(System.currentTimeMillis()));

                if (time1.equals(time2)) {
                    SimpleDateFormat sdf3= new SimpleDateFormat("HH:mm");
                    String time3= sdf3.format(new Date(time));

                    return time3;

                }else{
                    return time1;
                }
            }else {
                return "";
            }
        }


        public static String getTimeString(String time){
            try {
                return getTimeDisplay(new Date(time));
            } catch (Exception e) {
                // TODO: handle exception
            }
            return "";
        }

        public static long getTimeLong(String time){

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date dt1;
            try {
                dt1 = df.parse(time);
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(dt1);
                return calendar.getTimeInMillis();
            } catch (ParseException e) {
                e.printStackTrace();

            }
            return 0;
        }



        public static String getMinuteTimeString(String stocktime){

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date dt1;
            try {
                dt1 = df.parse(stocktime);
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String d3 = format2.format(dt1);
                return d3;
            } catch (ParseException e) {
                e.printStackTrace();
                return stocktime;
            }

        }






        public static boolean toRefresh() {
            Date curdate = new Date();
            if (null == preRefreshDateTime) {
                preRefreshDateTime = curdate;
                return true;
            }

            long timediff = (curdate.getTime() - preRefreshDateTime.getTime());
            preRefreshDateTime = curdate;
            return (timediff >= 60 * 60 * 1000);
        }

        @SuppressLint("SimpleDateFormat")
        public static Date getDate(Long dateLong) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String d = format.format(dateLong);
            Date date;
            try {
                date = format.parse(d);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
            return date;
        }



        public static boolean needDisplayTime(Date predate, Date curdate) {
            if (predate == null || curdate == null) {
                return true;
            }

            long timediff = (curdate.getTime() - predate.getTime());
            return (timediff >= 24 * 60 * 60 * 1000);
        }

        public static String getTimeDiffDesc(Date date) {

            if (date == null) {
                return null;
            }

            String strDesc = null;
            Calendar curCalendar = Calendar.getInstance();
            Date curDate = new Date();
            curCalendar.setTime(curDate);
            Calendar thenCalendar = Calendar.getInstance();
            thenCalendar.setTime(date);

            String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
            int w = thenCalendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            // SimpleDateFormat format = new
            // SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar current = Calendar.getInstance();
            Calendar today = Calendar.getInstance(); // 今天
            today.set(Calendar.YEAR, current.get(Calendar.YEAR));
            today.set(Calendar.MONTH, current.get(Calendar.MONTH));
            today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            // Date datetoday = today.getTime();
            // System.out.println(format.format(datetoday));

            Calendar yesterday = Calendar.getInstance(); // 昨天
            yesterday.setTime(curDate);
            yesterday.add(Calendar.DATE, -1);
            yesterday.set(Calendar.HOUR_OF_DAY, 0);
            yesterday.set(Calendar.MINUTE, 0);
            yesterday.set(Calendar.SECOND, 0);
            // Date dateyestoday = yesterday.getTime();
            // System.out.println(format.format(dateyestoday));

            Calendar sevendaysago = Calendar.getInstance(); // 7天
            sevendaysago.setTime(curDate);
            sevendaysago.add(Calendar.DATE, -7);
            sevendaysago.set(Calendar.HOUR_OF_DAY, 0);
            sevendaysago.set(Calendar.MINUTE, 0);
            sevendaysago.set(Calendar.SECOND, 0);
            // Date datesevenago = sevendaysago.getTime();
            // System.out.println(format.format(datesevenago));
		/*
		 * Date tasktime = yesterday.getTime(); SimpleDateFormat df=new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * System.out.println(df.format(tasktime));
		 */

            int thenMonth = thenCalendar.get(Calendar.MONTH);
            int thenDay = thenCalendar.get(Calendar.DAY_OF_MONTH);
            int h = thenCalendar.get(Calendar.HOUR_OF_DAY);
            int m = thenCalendar.get(Calendar.MINUTE);
            String sh = "", sm = "";
            if (h < 10)
                sh = "0";

            if (m < 10)
                sm = "0";
            if (thenCalendar.after(today))// today
            {
                if (h < 6) {
                    strDesc = "凌晨 " + sh + h + " : " + sm + m;
                } else if (h < 12) {
                    strDesc = "上午 " + sh + h + " : " + sm + m;
                } else if (h < 13) {
                    strDesc = "下午 " + h + " : " + sm + m;
                } else if (h < 19) {
                    strDesc = "下午 " + (h - 12) + " : " + sm + m;
                } else {
                    strDesc = "晚上 " + (h - 12) + " : " + sm + m;
                }
            } else if (thenCalendar.before(today) && thenCalendar.after(yesterday)) {// yestoday
                // System.out.println("yestoday");
                if (h < 6) {
                    strDesc = "昨天凌晨 " + sh + h + " : " + sm + m;
                } else if (h < 12) {
                    strDesc = "昨天上午 " + sh + h + " : " + sm + m;
                } else if (h < 13) {
                    strDesc = "昨天下午 " + h + " : " + sm + m;
                } else if (h < 19) {
                    strDesc = "昨天下午 " + (h - 12) + " : " + sm + m;
                } else {
                    strDesc = "昨天晚上 " + (h - 12) + " : " + sm + m;
                }
            } else if (thenCalendar.before(yesterday)
                    && thenCalendar.after(sevendaysago)) {// 2 ~ 7days ago
                // System.out.println("2~7");
                if (h < 6) {
                    strDesc = weekDays[w] + "凌晨 " + sh + h + " : " + sm + m;
                } else if (h < 12) {
                    strDesc = weekDays[w] + "上午 " + sh + h + " : " + sm + m;
                } else if (h < 13) {
                    strDesc = weekDays[w] + "下午 " + h + " : " + sm + m;
                } else if (h < 19) {
                    strDesc = weekDays[w] + "下午 " + (h - 12) + " : " + sm + m;
                } else {
                    strDesc = weekDays[w] + "晚上 " + (h - 12) + " : " + sm + m;
                }
            } else {
                // System.out.println("7~");
                if (h < 6) {
                    strDesc = (thenMonth + 1) + "月" + thenDay + "日" + "凌晨 " + sh
                            + h + " : " + sm + m;
                } else if (h < 12) {
                    strDesc = (thenMonth + 1) + "月" + thenDay + "日" + "上午 " + sh
                            + h + " : " + sm + m;
                } else if (h < 13) {
                    strDesc = (thenMonth + 1) + "月" + thenDay + "日" + "下午 " + h
                            + " : " + sm + m;
                } else if (h < 19) {
                    strDesc = (thenMonth + 1) + "月" + thenDay + "日" + "下午 "
                            + (h - 12) + " : " + sm + m;
                } else {
                    strDesc = (thenMonth + 1) + "月" + thenDay + "日" + "晚上 "
                            + (h - 12) + " : " + sm + m;
                }
            }
            // System.out.println(strDesc);
            return strDesc;
        }

        @SuppressWarnings("unused")
        public static String getTimeDisplay(Date date) {

            if (date == null) {
                return null;
            }

            String strDesc = null;
            Calendar curCalendar = Calendar.getInstance();
            Date curDate = new Date();
            curCalendar.setTime(curDate);
            Calendar thenCalendar = Calendar.getInstance();
            thenCalendar.setTime(date);

            String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
            int w = thenCalendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            // SimpleDateFormat format = new
            // SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar current = Calendar.getInstance();
            Calendar today = Calendar.getInstance(); // 今天
            today.set(Calendar.YEAR, current.get(Calendar.YEAR));
            today.set(Calendar.MONTH, current.get(Calendar.MONTH));
            today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);

            Calendar yesterday = Calendar.getInstance(); // 昨天
            yesterday.setTime(curDate);
            yesterday.add(Calendar.DATE, -1);
            yesterday.set(Calendar.HOUR_OF_DAY, 0);
            yesterday.set(Calendar.MINUTE, 0);
            yesterday.set(Calendar.SECOND, 0);

            Calendar sevendaysago = Calendar.getInstance(); // 7天
            sevendaysago.setTime(curDate);
            sevendaysago.add(Calendar.DATE, -7);
            sevendaysago.set(Calendar.HOUR_OF_DAY, 0);
            sevendaysago.set(Calendar.MINUTE, 0);
            sevendaysago.set(Calendar.SECOND, 0);

            long timediff = (curDate.getTime() - date.getTime());
            int theYear = thenCalendar.get(Calendar.YEAR);
            int thenMonth = thenCalendar.get(Calendar.MONTH);
            int thenDay = thenCalendar.get(Calendar.DAY_OF_MONTH);
            if (thenCalendar.after(today))// today
            {
//			if (timediff < 5 * 60 * 1000) {
//				strDesc = "刚刚";
//			} else if (timediff < 60 * 60 * 1000) {
//				strDesc = (timediff / 60 / 1000) + "分钟前";
//			} else {
//				strDesc = (timediff / 3600 / 1000) + "小时前";
//			}
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                strDesc=dateFormat.format(date);
            } else if (thenCalendar.before(today) && thenCalendar.after(yesterday)) {// yestoday
                strDesc = "昨天";
            } else if (thenCalendar.before(yesterday)
                    && thenCalendar.after(sevendaysago)) {// 2 ~ 7days ago
                strDesc = weekDays[w];
            } else {
                strDesc = "" + (theYear - 2000) + "-" + (thenMonth + 1) + "-"
                        + thenDay;
            }
            return strDesc;
        }

        public static String getTime4TimeTitle(Date date) {
            // M:月 d:天 a:上午或下午 h:12小时制的小时 m:分钟
            SimpleDateFormat format = new SimpleDateFormat("MM-dd a hh:mm",
                    Locale.CHINA);
            return format.format(date);
        }

        public static int getCurTimeStamp() {

            return (int) (System.currentTimeMillis() / 1000);

        }

        public static int compare_date(String DATE1, String DATE2) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date dt1 = df.parse(DATE1);
                Date dt2 = df.parse(DATE2);
                if (dt1.getTime() > dt2.getTime()) {
                    return 1;
                } else if (dt1.getTime() < dt2.getTime()) {
                    return -1;
                } else {
                    return 0;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return 0;
        }

        public static int compare_date2(String DATE1, String DATE2) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                Date dt1 = df.parse(DATE1);
                Date dt2 = df.parse(DATE2);
                if (dt1.getTime() > dt2.getTime()) {
                    return -1;
                } else if (dt1.getTime() < dt2.getTime()) {
                    return 1;
                } else {
                    return 0;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return 0;
        }

        public static int compare_date_day(String DATE1, String DATE2) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date dt1 = df.parse(DATE1);
                Date dt2 = df.parse(DATE2);
                if (dt1.getTime() > dt2.getTime()) {
                    return 1;
                } else if (dt1.getTime() < dt2.getTime()) {
                    return -1;
                } else {
                    return 0;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return 0;
        }

        public static long transferDateToMillions(String date) {
            Long time = 0l;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                Date dt1 = df.parse(date);
                time = dt1.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return time;
        }

        public static long transferDateSSToMillions(String date) {
            Long time = 0l;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date dt1 = df.parse(date);
                time = dt1.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return time;
        }
    }

    /**
     * 时间显示
     * Created by BobMu on 2016/9/23.
     */
    public static class DateTime{
        private int mYear, mMonth, mDay, mHour, mMin, mSec, mWeekDay;
        private SimpleDateFormat dateFormat;
        private Date date;
        private Calendar calendar;
        public DateTime(){
            this("yyyy-MM-dd HH:mm");
//            dateFormat1=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }

        public DateTime(String strFormat){
            dateFormat=new SimpleDateFormat(strFormat);
            calendar=Calendar.getInstance();
        }

        /**
         * 获取当前时间戳
         * @return
         */
        public String  getTimeStamp(){
            String timeStamp = dateFormat.format(new Date());
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp){
            try {
                date = new Date(Long.parseLong(timeStamp));
            }catch (Exception e){
                e.printStackTrace();
                date=new Date(System.currentTimeMillis());
            }
            calendar.setTime(date);
        }

        /**
         * 通过时间戳获取格式1类型的字符串，显示在视图控件中
         * @param timeStample
         * @return
         */
        public String getStrFormat1ByTimeStample(String timeStample){
//            Date date = new Date(Long.parseLong(timeStample)*1000);
            try {
                date = new Date(Long.parseLong(timeStample));
            }catch (Exception e){
                e.printStackTrace();
                date=new Date(System.currentTimeMillis());
            }
            return dateFormat.format(date);
        }

        private String[] weeks=new String[]
        {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        public String getWeekDayStr(){
            return weeks[getWeekDay()-1];
        }

        public int getWeekDay(){
            return calendar.get(Calendar.DAY_OF_WEEK);
        }


        public DateTime setWeekDay(int weekDay) {
            this.mWeekDay=weekDay;
            return this;
        }
//        /**
//         * 通过设置
//         * @return
//         */
//        public String getStrFormat1(){
//            return  mYear+"-"+StringUtil.getDoubleNumber(mMonth)+"-"+StringUtil.getDoubleNumber(mDay)+" "+StringUtil.getDoubleNumber(mHour)+":"+StringUtil.getDoubleNumber(mMin);
//        }

//        public long getTimeFormat1(){
//            try {
//                return dateFormat.parse(getStrFormat1()).getTime();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            return System.currentTimeMillis();
//        }

        public int getYear() {
            return mYear;
        }

        public DateTime setYear(int year) {
            this.mYear = year;
            return this;
        }

        public int getMonth() {
            return calendar.get(Calendar.MONTH)+1;
        }

        public DateTime setMonth(int month) {
            this.mMonth = month;
            return this;
        }

        public int getDay() {
            return calendar.get(Calendar.DAY_OF_MONTH);
        }

        public DateTime setDay(int day) {
            this.mDay = day;
            return this;
        }

        public DateTime buildDate(){
            calendar.set(mYear, mMonth, mDay);
            return this;
        }

        public int getHour() {
            return calendar.get(Calendar.HOUR_OF_DAY);
        }

        public DateTime setHour(int hour) {
            this.mHour = hour;
            return this;
        }

        public int getMin() {
            return calendar.get(Calendar.MINUTE);
        }

        public DateTime setMin(int min) {
            this.mMin = min;
            return this;
        }

        public int getSec() {
            return calendar.get(Calendar.SECOND);
        }

        public DateTime setSec(int sec) {
            this.mSec = sec;
            return this;
        }

        public void buildTime(){
            calendar.set(mYear, mMonth, mDay, mHour, mMin, mSec);
        }
    }
}