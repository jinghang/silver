package hang.silver.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateTimeTool {

	/**
	 * 将java8的 java.time.LocalDateTime 转成 java.util.Date
	 * @param dateTime 要转的时间
	 * @return 旧的Date类型
	 */
	public static Date toDate(LocalDateTime dateTime){
		return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 *
	 * @param date
	 * @return
	 */
	public static LocalDateTime toLocalDateTime(Date date){
		return LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault());
	}

	/**
	 * 日期格式化
	 * @param dateTime
	 * @return
	 */
	public static String format(LocalDateTime dateTime){
		return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 日期格式化
	 * @param time
	 * @return
	 */
	public static String format(Date time){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
	}

	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate,Date bdate) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		smdate=sdf.parse(sdf.format(smdate));
		bdate=sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);

		return Integer.parseInt(String.valueOf(between_days));
	}

}
