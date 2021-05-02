package com.Flipkart.Helper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Flipkart.Util.Constants;

/**
 * The Class WaitHelper.
 */
public class WaitHelper {

	/** The driver. */
	protected WebDriver driver;

	/** The wait. */
	protected WebDriverWait wait;

	/** The Constant LOG. */
	protected static final Logger LOG = Logger.getRootLogger();

	/** The action. */
	protected Actions action;

	/**
	 * Instantiates a new wait helper.
	 *
	 * @param driver
	 *            the driver
	 */
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Constants.EXPLICIT_WAIT);
		action = new Actions(this.driver);
	}

	/**
	 * Gets the wait instance.
	 *
	 * @return the wait instance
	 */
	public WebDriverWait getWaitInstance() {
		return this.wait;
	}

	/**
	 * Wait for element visible.
	 *
	 * @param element
	 *            the element
	 */
	public void WaitForElementVisible(WebElement element) {
		LOG.info("Waiting for the element to be visible : " + element.toString());
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait for element visible with catch.
	 *
	 * @param element
	 *            the element
	 */
	@SuppressWarnings("deprecation")
	public void WaitForElementVisibleWithCatch(WebElement element) {
		wait.withTimeout(Constants.QUICK_EXPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.QUICK_IMPLICIT_WAIT, TimeUnit.SECONDS);
		String elementStr = element.toString();
		LOG.info("Waiting for the element to be visible with catch." + elementStr);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			LOG.error(e.getMessage());
		}
		LOG.info("End wait for the element to be visible with catch." + elementStr);
		wait.withTimeout(Constants.EXPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	/**
	 * Wait for element enabled.
	 *
	 * @param element
	 *            the element
	 */

	public void WaitForElementEnabled(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wait for presence of element located.
	 *
	 * @param by
	 *            the by
	 */
	public void WaitForPresenceOfElementLocated(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	/**
	 * Wait for text to be present in element.
	 *
	 * @param element
	 *            the element
	 * @param text
	 *            the text
	 */
	public void waitForTextToBePresentInElement(WebElement element, String text) {
		wait.until(ExpectedConditions.or(ExpectedConditions.textToBePresentInElement(element, text),
				ExpectedConditions.textToBePresentInElementValue(element, text)));
	}

	/**
	 * Wait for text to be present in element quick.
	 *
	 * @param element
	 *            the element
	 * @param text
	 *            the text
	 */
	@SuppressWarnings("deprecation")
	public void waitForTextToBePresentInElement_Quick(WebElement element, String text) {
		wait.withTimeout(Constants.QUICK_EXPLICIT_WAIT, TimeUnit.SECONDS);
		try {
			wait.until(ExpectedConditions.or(ExpectedConditions.textToBePresentInElement(element, text),
					ExpectedConditions.textToBePresentInElementValue(element, text)));
		} catch (TimeoutException e) {
			LOG.error(e.getMessage());
		}
		wait.withTimeout(Constants.EXPLICIT_WAIT, TimeUnit.SECONDS);
	}

	/**
	 * Wait for element tobe present quick.
	 *
	 * @param by
	 *            the by
	 */
	@SuppressWarnings("deprecation")
	public void waitForElementTobePresent_Quick(By by) {
		wait.withTimeout(Constants.QUICK_EXPLICIT_WAIT, TimeUnit.SECONDS);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (TimeoutException e) {
			LOG.error(e.getMessage());
		}
		wait.withTimeout(Constants.EXPLICIT_WAIT, TimeUnit.SECONDS);
	}

	/**
	 * Wait for element to be clickable.
	 *
	 * @param element
	 *            the element
	 */
	@SuppressWarnings("deprecation")
	public void WaitForElementToBeClickable(WebElement element) {
		wait.withTimeout(Constants.QUICK_EXPLICIT_WAIT, TimeUnit.SECONDS);
		LOG.info("Waiting for the element to be clickable : " + element.toString());
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.withTimeout(Constants.EXPLICIT_WAIT, TimeUnit.SECONDS);
	}

	/**
	 * Wait for staleness of element.
	 *
	 * @param element
	 *            the element
	 */
	public void WaitForStalenessOf(WebElement element) {
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	/**
	 * Wait for list of element to be visible.
	 *
	 * @param elements
	 *            the elements
	 */
	public void waitForListOfElementToBeVisible(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	/**
	 * Wait for list of element to be present.
	 *
	 * @param by
	 *            the by
	 */
	public void waitForListOfElementToBePresent(By by) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}

	/**
	 * Waitfor number of elements to be present.
	 *
	 * @param by
	 *            the by
	 * @param number
	 *            the number
	 */
	public void waitforNumberOfElementsToBe(By by, int number) {
		wait.until(ExpectedConditions.numberOfElementsToBe(by, number));
	}

	/**
	 * Waitfor number of elements to be less than.
	 *
	 * @param by
	 *            the by
	 * @param number
	 *            the number
	 */
	public void waitforNumberOfElementsToBeLessThan(By by, int number) {
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(by, number));
	}

	/**
	 * Wait for element to contain sub element.
	 *
	 * @param element
	 *            the element
	 * @param by_subElement
	 *            the by sub element
	 */
	public void waitForElementToContainSubElement(WebElement element, By by_subElement) {
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(element, by_subElement));
	}

	/**
	 * Thread sleep.
	 *
	 * @param milliSecond
	 *            the milli second
	 */
	public void ThreadSleep(int milliSecond) {
		try {
			Thread.sleep(milliSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
