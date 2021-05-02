package com.Flipkart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Flipkart.Helper.WebElementHelper;


/**
 * The Class CommonPage.
 */

public class CommonPage extends BasePage {

	/** The skillshorttxt. */

	/**
	 * Instantiates a new common page.
	 *
	 * @param driver
	 *            the driver
	 * @param webElementHelper
	 *            the web element helper
	 */
	public CommonPage(WebDriver driver, WebElementHelper webElementHelper) {
		super(driver, webElementHelper);
		PageFactory.initElements(driver, this);
	}

}
