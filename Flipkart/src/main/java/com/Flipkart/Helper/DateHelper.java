package com.Flipkart.Helper;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The Class DateHelper.
 */
public class DateHelper {

	/** The dropdown helper. */
	private static DateHelper dateHelper;

	/**
	 * Instantiates a new dropdown helper.
	 */
	private DateHelper() {

	}

	/**
	 * Gets the single instance of DateHelper.
	 *
	 * @return single instance of DateHelper
	 */
	public static DateHelper getInstance() {
		if (dateHelper == null) {
			dateHelper = new DateHelper();
		}
		return dateHelper;
	}

	/**
	 * Add days to current date.
	 *
	 * @param days
	 *            the days
	 * @return the date
	 */
	public Date AddDaysToCurrentDate(int days) {
		Date d = new Date();
		Calendar myCal = Calendar.getInstance();
		myCal.setTime(d);
		myCal.add(Calendar.DATE, days);
		return (myCal.getTime());
	}

	/**
	 * Gets the year from date provided in string.
	 *
	 * @param date
	 *            the date
	 * @param dateFormat
	 *            the date format
	 * @return the year from string
	 */
	public int getYearFromString(String date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		int year = 0;
		try {
			Date d = sdf.parse(date);
			Calendar myCal = Calendar.getInstance();
			myCal.setTime(d);

			year = myCal.get(Calendar.YEAR);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return year;
	}

	/**
	 * Gets the month from date provided in string.
	 *
	 * @param date
	 *            the date
	 * @param dateFormat
	 *            the date format
	 * @return the month from string
	 */
	public int getMonthFromString(String date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		int month = 0;
		try {
			Date d = sdf.parse(date);
			Calendar myCal = Calendar.getInstance();
			myCal.setTime(d);
			month = myCal.get(Calendar.MONTH) + 1;

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return month;
	}

	/**
	 * Gets the short month name from date provided in string.
	 *
	 * @param date
	 *            the date
	 * @param dateFormat
	 *            the date format
	 * @return the short month name from string
	 */
	public String getShortMonthNameFromString(String date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String shortMonthName = "";
		try {
			Date d = sdf.parse(date);
			shortMonthName = new SimpleDateFormat("MMM").format(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return shortMonthName;
	}

	/**
	 * Gets the month and year from the provided month number.
	 *
	 * @param month
	 *            the month
	 * @return the month year name
	 */
	public String getMonthYearName(int month) {
		String monthString = new DateFormatSymbols().getMonths()[month - 1];
		String year = new SimpleDateFormat("YYYY").format(new Date());
		return monthString + " " + year;
	}

	/**
	 * Gets the short month name from the provided month number.
	 *
	 * @param month
	 *            the month
	 * @return the short month name
	 */
	public String getShortMonthName(int month) {
		return (new DateFormatSymbols().getShortMonths()[month - 1]);

	}

	/**
	 * Gets the date from string - Return date object.
	 *
	 * @param dateToSelect
	 *            the date to select
	 * @param pattern
	 *            the pattern
	 * @return the date from string
	 */
	public Date getDateFromString(String dateToSelect, String pattern) {

		Date date = null;
		try {
			date = new SimpleDateFormat(pattern).parse(dateToSelect);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * Gets the first date of current month.
	 *
	 * @param pattern
	 *            the pattern
	 * @return the first date of current month
	 */
	public String getFirstDateOfCurrentMonth(String pattern) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_MONTH, 1);

		return new SimpleDateFormat(pattern).format(c.getTime());
	}

	/**
	 * Gets the last date of current month.
	 *
	 * @param pattern
	 *            the pattern
	 * @return the last date of current month
	 */
	public String getLastDateOfCurrentMonth(String pattern) {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));

		return new SimpleDateFormat(pattern).format(c.getTime());
	}

	/**
	 * Gets the first date of previous month.
	 *
	 * @param pattern
	 *            the pattern
	 * @return the first date of previous month
	 */
	public String getFirstDateOfPreviousMonth(String pattern) {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DAY_OF_MONTH, 1);

		return new SimpleDateFormat(pattern).format(c.getTime());
	}

	/**
	 * Gets the last date of previous month.
	 *
	 * @param pattern
	 *            the pattern
	 * @return the last date of previous month
	 */
	public String getLastDateOfPreviousMonth(String pattern) {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DATE, -1);

		return new SimpleDateFormat(pattern).format(c.getTime());
	}

	/**
	 * Gets the first date of next month.
	 *
	 * @param pattern
	 *            the pattern
	 * @return the first date of next month
	 */
	public String getFirstDateOfNextMonth(String pattern) {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);

		return new SimpleDateFormat(pattern).format(c.getTime());
	}

	/**
	 * Gets the last date of next month.
	 *
	 * @param pattern
	 *            the pattern
	 * @return the last date of next month
	 */
	public String getLastDateOfNextMonth(String pattern) {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, 2);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DATE, -1);

		return new SimpleDateFormat(pattern).format(c.getTime());
	}

	/**
	 * Checks if is date bigger.
	 *
	 * @param date1
	 *            the date 1
	 * @param date2
	 *            the date 2
	 * @param pattern
	 *            the pattern
	 * @return true, if is date bigger
	 */
	public boolean isDateBigger(String date1, String date2, String pattern) {

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(getDateFromString(date1, pattern));
		c2.setTime(getDateFromString(date2, pattern));

		return c1.before(c2);
	}

	/**
	 * Checks if is date bigger or equal.
	 *
	 * @param date1
	 *            the date 1
	 * @param date2
	 *            the date 2
	 * @param pattern
	 *            the pattern
	 * @return true, if is date bigger or equal
	 */
	public boolean isDateBiggerOrEqual(String date1, String date2, String pattern) {

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(getDateFromString(date1, pattern));
		c2.setTime(getDateFromString(date2, pattern));

		return c1.before(c2) || c1.equals(c2);
	}

	/**
	 * Gets the current date time.
	 *
	 * @param pattern
	 *            the pattern
	 * @return the current date time
	 */
	public String getCurrentDateTime(String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	/**
	 * Gets the date of month.
	 *
	 * @param pattern
	 *            the pattern
	 * @param months
	 *            the months
	 * @param dayOfMonths
	 *            the day of months
	 * @return the date of month
	 */
	public String getDateOfMonth(String pattern, int months, int dayOfMonths) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, months);
		c.set(Calendar.DAY_OF_MONTH, dayOfMonths);
		return new SimpleDateFormat(pattern).format(c.getTime());
	}

}
