package com.Flipkart.Cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.Flipkart.Helper.WebElementHelper;
import com.Flipkart.PageObjects.CommonPage;
import com.Flipkart.PageObjects.HomePage;
import com.Flipkart.PageObjects.Login.FlipkartPage;
import com.Flipkart.Util.Constants;
import com.Flipkart.Util.DriverDetail;
import com.FlipkartFactory.DriverFactory;


/**
 * The Class TestContext.
 */
public class TestContext {

	/** The driver. */
	private WebDriver driver;

	/** The web element helper. */
	private WebElementHelper webElementHelper;

	/** The driver factory. */
	private DriverFactory driverFactory;

	/** The login page. */
	private FlipkartPage loginPage;

	/** The home page. */
	private HomePage homePage;

	/** The common page. */
	private CommonPage commonPage;


	/**
	 * Instantiates a new test context.
	 */
	public TestContext() {

		WebDriver dr = DriverDetail.getUnoccupiedDriver();

		if (dr != null) {
			this.driver = dr;
		} else {
			driverFactory = new DriverFactory();
			this.driver = driverFactory.getDriver();
		}

		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		this.webElementHelper = new WebElementHelper(driver);
	}

	/**
	 * Tear down driver.
	 */
	public void tearDownDriver() {
		DriverDetail.PushUnoccupiedDriver(this.driver);
	}

	/**
	 * Gets the login page.
	 *
	 * @return the login page
	 */
	public FlipkartPage getLoginPage() {
		loginPage = new FlipkartPage(this.driver, this.webElementHelper);
		return loginPage;
	}

	/**
	 * Gets the common page.
	 *
	 * @return the common page
	 */
	public CommonPage getCommonPage() {
		commonPage = new CommonPage(this.driver, this.webElementHelper);
		return commonPage;
	}

	public HomePage getHomePage() {
		homePage = new HomePage(this.driver, this.webElementHelper);
		return homePage;
	}


	
}
