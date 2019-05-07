package com.kms.katalon.keyword.datetime

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import org.apache.commons.lang3.time.DateUtils
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import groovy.transform.CompileStatic

public class DateTimeUtility {

	/**
	 * Get current date time
	 *
	 * @param timeZoneId TimeZone Id. If the timeZoneId is null, it will use the local TimeZone
	 * @param dateTimeFormat the date time format. If the dateTimeFormat is null, the default format set to "dd-MM-yyyy hh:mm:ss a"
	 * @return the current date
	 */
	@CompileStatic
	@Keyword
	public static String getCurrentDateTime(String timeZoneId, String dateTimeFormat) {
		DateFormat format = setDateFormat(dateTimeFormat)
		setTimeZone(format, timeZoneId)
		Date date = new Date()
		return format.format(date)
	}

	/**
	 * Get noOfDays days previous to current date
	 *
	 * @param noOfDays the days previous to current date
	 * @param timeZoneId TimeZone Id. If the timeZoneId is null, it will use the local TimeZone 
	 * @param dateTimeFormat the date format. If the dateTimeFormat is null, the default returned date time format is "dd-MM-yyyy hh:mm:ss a" 
	 * @return the previous date
	 */
	@CompileStatic
	@Keyword
	public static String getPreviousDateTime(int noOfDays, String timeZoneId, String dateTimeFormat) {
		DateFormat format = setDateFormat(dateTimeFormat)
		setTimeZone(format, timeZoneId)
		Calendar cal = Calendar.getInstance()
		cal.add(5, -noOfDays)
		Date todate1 = cal.getTime()
		return format.format(todate1)
	}

	/**
	 * Get noOfDays days after the current date
	 *
	 * @param noOfDays the days after the current date
	 * @param timeZoneId TimeZone Id. If the timeZoneId is null, it will use the local TimeZone
	 * @param dateTimeFormat the date format. If the dateTimeFormat is null, the default format set to "MM/dd/yyyy"
	 * @return the future date
	 */
	@CompileStatic
	@Keyword
	public static String getFutureDateTime(int noOfDays, String timeZoneId, String dateTimeFormat) {
		DateFormat format = setDateFormat(dateTimeFormat)
		setTimeZone(format, timeZoneId)
		Calendar cal = Calendar.getInstance()
		cal.add(5, noOfDays)
		Date todate = cal.getTime()
		return format.format(todate)
	}

	/**
	 * Set the default TimeZone
	 *
	 * @param timeZoneId TimeZone Id. If the timeZoneId is null, it will use the local TimeZone
	 */
	@CompileStatic
	@Keyword
	public static setDefaultTimeZone(String timeZoneId) {
		if (timeZoneId != null)
			TimeZone.setDefault(TimeZone.getTimeZone(timeZoneId))
		else
			TimeZone.setDefault(null)
	}

	/**
	 * Get the default TimeZone
	 *
	 * @return the default TimeZone
	 */
	@CompileStatic
	@Keyword
	public static TimeZone getDefaultTimeZone() {
		return TimeZone.getDefault()
	}

	private static SimpleDateFormat setDateFormat(String dateFormat) {
		DateFormat format
		if (dateFormat==null)
			format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a")
		else
			format = new SimpleDateFormat(dateFormat)
		return format
	}

	private static setTimeZone(DateFormat format, String timeZoneId) {
		if (timeZoneId != null)
			format.setTimeZone(TimeZone.getTimeZone(timeZoneId))
		KeywordUtil.logInfo("The current TimeZone ID is: " + format.getTimeZone().ID)
	}

	/**
	 * Format a string date
	 *
	 * @param value the date needs to reformat
	 * @param currentFormat the current format of the string date
	 * @param newFormat the expected format of the string date
	 * @return the string date in new format
	 */
	@Keyword
	public String formatStringDate(String value, String currentFormat, String newFormat) throws ParseException {
		return (new SimpleDateFormat(newFormat)).format((new SimpleDateFormat(currentFormat)).parse(value))
	}

	/**
	 * Convert a string to date
	 *
	 * @param value the date string needs to convert
	 * @param dateTimeFormat the format of the date string
	 * @return the date 
	 */
	@Keyword
	public Date convertString2Date(String value, String dateTimeFormat) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateTimeFormat)
		return format.parse(value)
	}

	/**
	 * Add days to a particular date
	 *
	 * @param stringDate the date needs to add more days
	 * @param dateFormat the format of the date string
	 * @param amount the number of days adding to the date
	 * @return new date string
	 */
	@Keyword
	public String addDays(String stringDate, String dateFormat, int amount) throws ParseException {
		Date newDate = DateUtils.addDays((new SimpleDateFormat(dateFormat)).parse(stringDate), amount)
		return (new SimpleDateFormat(dateFormat)).format(newDate)
	}

	/**
	 * Get current date
	 *
	 * @return current date
	 */
	@Keyword
	public static int getCurrentDate() {
		Calendar now = Calendar.getInstance();
		return now.get(5);
	}

	/**
	 * Get current month
	 *
	 * @return current month
	 */
	@Keyword
	public static int getCurrentMonth() {
		Calendar now = Calendar.getInstance();
		return now.get(2) + 1;
	}

	/**
	 * Get current year
	 *
	 * @return current year
	 */
	@Keyword
	public static int getCurrentYear() {
		Calendar now = Calendar.getInstance();
		return now.get(1);
	}

	/**
	 * Get future time
	 *
	 * @param hrs the hours adding to the current hour
	 * @param minute the minutes adding to the current minute
	 * @return the new time
	 */
	@Keyword
	public static String getFutureTime(int hrs, int minute) {
		KeywordUtil.logInfo("The current TimeZone ID is: " + TimeZone.getDefault().ID)
		return LocalTime.now(ZoneId.systemDefault()).plusHours((long)hrs).plusMinutes((long)minute).format(DateTimeFormatter.ofPattern("hh:mm a"));
	}

	/**
	 * Get past time
	 *
	 * @param hrs the hours subtracting from the current hour
	 * @param minute the minutes subtracting the current minute
	 * @return the new time
	 */
	@Keyword
	public static String getPastTime(int hrs, int minute) {
		KeywordUtil.logInfo("The current TimeZone ID is: " + TimeZone.getDefault().ID)
		return LocalTime.now(ZoneId.systemDefault()).minusHours((long)hrs).minusMinutes((long)minute).format(DateTimeFormatter.ofPattern("hh:mm a"));
	}

	/**
	 * Get duration
	 *
	 * @param startTime the start time
	 * @param endTime the end time
	 * @return the duration
	 */
	@Keyword
	public static Duration getDuration(String startTime, String endTime) {
		LocalTime d1 = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("hh:mm a"))
		LocalTime d2 = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("hh:mm a"))
		return Duration.between(d1, d2)
	}

	/**
	 * Get the day of the week
	 *
	 * @param date the date string
	 * @param dateFormat the date format
	 * @return the day of the week
	 */
	@Keyword
	public static String getDayOfWeek(String date, String dateFormat) throws ParseException {
		SimpleDateFormat format1 = new SimpleDateFormat(dateFormat)
		Date dt1 = format1.parse(date)
		DateFormat format2 = new SimpleDateFormat("EEE")
		return format2.format(dt1)
	}
}
