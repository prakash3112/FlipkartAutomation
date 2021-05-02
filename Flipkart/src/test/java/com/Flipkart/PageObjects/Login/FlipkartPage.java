package com.Flipkart.PageObjects.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.Flipkart.Helper.WebElementHelper;
import com.Flipkart.PageObjects.BasePage;


/**
 * The Class LoginPage.
 */
public class FlipkartPage extends BasePage {

	/**
	 * Instantiates a new login page.
	 *
	 * @param driver
	 *            the driver
	 * @param webElementHelper
	 *            the web element helper
	 */
	public FlipkartPage(WebDriver driver, WebElementHelper webElementHelper) {
		super(driver, webElementHelper);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Launch application.
	 */
	public void LaunchApplication() {
		LOG.info("Launching web application URL: " + CONFIG.getProperty("application.url"));
		driver.manage().deleteAllCookies();
		driver.get(CONFIG.getProperty("application.url"));
	}

	/**
	 * Open new window.
	 */
	public void openNewWindow() {
		driver2 = new ChromeDriver();
		this.driver = driver2;
		driver.manage().window().maximize();
	}

}
