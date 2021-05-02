package com.Flipkart.Util;

/**
 * The Class Constants.
 */
public class Constants {

	/** The Constant BROWSER_FF. */
	public static final String BROWSER_FF = "Firefox";

	/** The Constant BROWSER_CHROME. */
	public static final String BROWSER_CHROME = "Chrome";

	/** The Constant BROWSER_IE. */
	public static final String BROWSER_IE = "IE";

	/** The Constant BROWSER_EDGE. */
	public static final String BROWSER_EDGE = "EDGE";

	/** The Constant BROWSER_SAFARI. */
	public static final String BROWSER_SAFARI = "Safari";

	/** The Constant OS_WIN. */
	public static final String OS_WIN = "Windows";

	/** The Constant OS_MAC. */
	public static final String OS_MAC = "Mac";

	/** The Constant SCREENSHOT_SDF. */
	public static final String SCREENSHOT_SDF = "MMddYYYY_HHmmssSSS";

	/** The Constant DATABASE_SDF. */
	public static final String DATABASE_SDF = "yyyy-MM-dd HH:mm:ss";

	/** The Constant IMAGE_EXTENSION. */
	public static final String IMAGE_EXTENSION = ".jpg";

	/** The Constant HTML_EXTENSION. */
	public static final String HTML_EXTENSION = ".html";

	// Files and URIs

	/** The Constant CONFIG_PROPERTY. */
	public static final String CONFIG_PROPERTY = "config.properties";

	/** The Constant EXTENT_FILE. */
	public static final String EXTENT_FILE = "ExtentReportsConfig.xml";

	/** The Constant PROPERTIES_URI. */
	public static final String PROPERTIES_URI = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\configFiles\\";

	/** The Constant CONFIG_FILES_URI. */
	public static final String CONFIG_FILES_URI = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\configFiles\\";

	/** The Constant DRIVERS_URI. */
	public static final String DRIVERS_URI = System.getProperty("user.dir") + "\\src\\test\\resources\\driverFiles\\";

	/** The Constant SCREENSHOT_PATH. */
	public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "\\output\\Screenshot\\";

	/** The Constant REPORT_PATH. */
	public static final String REPORT_PATH = System.getProperty("user.dir") + "\\output\\";
	/** The Constant Download_PATH. */
	public static final String Download_PATH = System.getProperty("user.dir") + "\\Download\\";

	/** The Constant FILES_PATH. */
	public static final String FILES_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\";

	public static final String FILES_NAME = "DeviceList.xlsx";

	// timeOuts in seconds

	/** The Constant QUICK_IMPLICIT_WAIT. */
	public static final int QUICK_IMPLICIT_WAIT = 4;

	/** The Constant QUICK_IMPLICIT_WAIT_2. */
	public static final int QUICK_IMPLICIT_WAIT_2 = 2;

	/** The Constant IMPLICIT_WAIT. */
	public static final int IMPLICIT_WAIT = 20;

	/** The Constant EXPLICIT_WAIT. */
	public static final int EXPLICIT_WAIT = 30;

	/** The Constant EXPLICIT_WAIT. */
	public static final int QUICK_EXPLICIT_WAIT = 4;

	/** The Constant PAGE_LOAD_TIMEOUT. */
	public static final int PAGE_LOAD_TIMEOUT = 10;

	// Database table detail

	/** The Constant TESTRUN_TABLE. */
	public static final String TESTRUN_TABLE = "testRun";

	/** The Constant FEATURE_TABLE. */
	public static final String FEATURE_TABLE = "feature";

	/** The Constant SCENARIO_TABLE. */
	public static final String SCENARIO_TABLE = "scenario";

}
