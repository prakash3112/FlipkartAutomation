package com.FlipkartFactory;

import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import org.testng.annotations.Parameters;

import com.Flipkart.Helper.PropertyHelper;
import com.Flipkart.Util.Constants;

/**
 * A factory for creating Driver objects.
 */
public class DriverFactory {

	/** The driver. */
	private WebDriver driver = null;

	/** The driver 2. */
	private static WebDriver driver2 = null;

	/** The is active. */
	private static boolean isActive = false;

	/** The config. */
	private static Properties CONFIG = PropertyHelper.getConfig(Constants.CONFIG_PROPERTY);

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	
	public WebDriver getDriver() {

		String browser = CONFIG.getProperty("browser");

		String geckoDriverPath = Constants.DRIVERS_URI + CONFIG.getProperty("gecko.driver.path");
		String chromeDriverPath = Constants.DRIVERS_URI + CONFIG.getProperty("chrome.driver.path");
		String IEDriverPath = Constants.DRIVERS_URI + CONFIG.getProperty("ie.driver.path");
		String EdgeDriverPath = Constants.DRIVERS_URI + CONFIG.getProperty("Edge.driver.path");

		if (browser.equalsIgnoreCase(Constants.BROWSER_FF)) {
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("-enablePassThrough", true);
			driver = new FirefoxDriver(options);

		} else if (browser.equalsIgnoreCase(Constants.BROWSER_CHROME)) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			String downloadFilepath = Constants.Download_PATH;
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			options.addArguments("disable-infobars");
			options.addArguments("use-fake-device-for-media-stream");
			options.addArguments("use-fake-ui-for-media-stream");
			// options.addArguments("--headless");

			HashMap<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory", downloadFilepath);
			prefs.put("plugins.always_open_pdf_externally", true);
			prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
			prefs.put("download.prompt_for_download", false);

			options.setExperimentalOption("prefs", prefs);

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(cap);

		} else if (browser.equalsIgnoreCase(Constants.BROWSER_IE)) {
			System.setProperty("webdriver.ie.driver", IEDriverPath);
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase(Constants.BROWSER_EDGE)) {
			System.setProperty("webdriver.edge.driver", EdgeDriverPath);
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase(Constants.BROWSER_SAFARI)) {
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		// Dimension dim = new Dimension(1366, 768);
		// driver.manage().window().setSize(dim);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		setActive(true);
		return driver;

	}

	/**
	 * Gets the driver 2.
	 *
	 * @return the driver 2
	 */
	public static WebDriver getDriver2() {

		String browser = CONFIG.getProperty("browser");

		String geckoDriverPath = Constants.DRIVERS_URI + CONFIG.getProperty("gecko.driver.path");
		String chromeDriverPath = Constants.DRIVERS_URI + CONFIG.getProperty("chrome.driver.path");
		String IEDriverPath = Constants.DRIVERS_URI + CONFIG.getProperty("ie.driver.path");

		if (browser.equalsIgnoreCase(Constants.BROWSER_FF)) {
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);

			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("-enablePassThrough", true);

			driver2 = new FirefoxDriver(options);
		} else if (browser.equalsIgnoreCase(Constants.BROWSER_CHROME)) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver2 = new ChromeDriver();
		} else if (browser.equalsIgnoreCase(Constants.BROWSER_IE)) {
			System.setProperty("webdriver.ie.driver", IEDriverPath);
			driver2 = new InternetExplorerDriver();
		}

		driver2.manage().window().maximize();

		return driver2;
	}

	/**
	 * Tear down.
	 */
	public void tearDown() {
		driver.quit();
		setActive(false);
	}

	/**
	 * Tear down driver 2.
	 */
	public static void tearDownDriver2() {
		if (driver2 != null) {
			driver2.quit();
			driver2 = null;
		}
	}

	/**
	 * Sets the active.
	 *
	 * @param active
	 *            the new active
	 */
	public static void setActive(boolean active) {
		isActive = active;
	}

	/**
	 * Gets the active.
	 *
	 * @return the active
	 */
	public static boolean getActive() {
		return isActive;
	}

}
