package com.Flipkart.Helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Flipkart.Util.Constants;

/**
 * The Class WebElementHelper.
 */
public class WebElementHelper extends WaitHelper {

	/** The web element helper. */
	private WebElementHelper webElementHelper;

	/**
	 * Instantiates a new web element helper.
	 *
	 * @param driver
	 *            the driver
	 */
	public WebElementHelper(WebDriver driver) {
		super(driver);
	}

	/**
	 * Gets the single instance of WebElementHelper.
	 *
	 * @param driver
	 *            the driver
	 * @return single instance of WebElementHelper
	 */
	public WebElementHelper getInstance(WebDriver driver) {
		webElementHelper = new WebElementHelper(driver);
		return webElementHelper;
	}

	/**
	 * Type text into provided input element. Clears the existing text first,
	 * then types into new text.
	 *
	 * @param element
	 *            the element
	 * @param text
	 *            the text
	 */
	public void TypeInto(WebElement element, String text) {
		LOG.info("Writing '" + text + "' into web-element: " + element.toString());
		WaitForElementVisible(element);
		element.clear();
		element.sendKeys(text);
		ThreadSleep(500);
	}

	/**
	 * Type into with deletevalue.
	 *
	 * @param element
	 *            the element
	 * @param text
	 *            the text
	 */
	public void TypeIntoWithDeletevalue(WebElement element, String text) {
		LOG.info("Writing '" + text + "' into web-element: " + element.toString());
		WaitForElementVisible(element);
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		ThreadSleep(800);
		element.sendKeys(text);
		ThreadSleep(800);
	}

	/**
	 * Type into without wait.
	 *
	 * @param element
	 *            the element
	 * @param text
	 *            the text
	 */
	public void TypeIntoWithoutWait(WebElement element, String text) {
		LOG.info("Writing '" + text + "' into web-element: " + element.toString());
		WaitForElementVisible(element);
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Type text into provided input element. Clears the existing text first,
	 * then types into new text, and then hits TAB key to move cursor out of the
	 * element to generate focusOut event.
	 *
	 * @param element
	 *            the element
	 * @param text
	 *            the text
	 */
	public void TypeIntoWithTab(WebElement element, String text) {
		LOG.info("Writing '" + text + "' into web-element: " + element.toString());

		element.clear();
		element.sendKeys(text);
		ThreadSleep(700);
		element.sendKeys(Keys.TAB);
		ThreadSleep(700);
	}

	/**
	 * Type text into provided input element. Clears the existing text first,
	 * then types into new integer value.
	 *
	 * @param element
	 *            the element
	 * @param text
	 *            the integer value
	 */
	public void TypeInto(WebElement element, int text) {

		LOG.info("Writing '" + text + "' into web-element: " + element.toString());
		WaitForElementVisible(element);
		element.clear();
		element.sendKeys(Integer.toString(text));
		ThreadSleep(500);
	}

	/**
	 * Type text into provided input element without clearing existing text.
	 *
	 * @param element
	 *            the element
	 * @param text
	 *            the text
	 */
	public void TypeIntoWithoutClear(WebElement element, String text) {
		LOG.info("Writing '" + text + "' into web-element: " + element.toString());
		WaitForElementVisible(element);
		element.sendKeys(text);
		ThreadSleep(500);
	}

	/**
	 * Click. If mask element obstructs click event, then the control will wait
	 * for staleness of mask element, than it will try to click on element once
	 * again.
	 *
	 * @param element
	 *            the element
	 */
	public void click(WebElement element) {
		String elementStr = element.toString();
		LOG.info("Clicking on web-element: " + elementStr);
		WaitForElementVisible(element);
		WaitForElementToBeClickable(element);
		try {
			element.click();
		} catch (WebDriverException e) {
			LOG.info(e.getMessage());
			if (e.getMessage().contains("Other element would receive the click: <div")) {
				waitForStalenessOfMask();
				ThreadSleep(300);
				element.click();
			}
		}
		LOG.info("Clicked on web-element: " + elementStr);
	}

	/**
	 * Click1. If mask element obstructs click event, then the control will wait
	 * for invisibility of mask element, than it will try to click on element
	 * once again.
	 *
	 * @param element
	 *            the element
	 */
	public void click1(WebElement element) {
		LOG.info("Clicking on web-element: " + element.toString());
		WaitForElementVisible(element);
		WaitForElementToBeClickable(element);
		try {
			element.click();
		} catch (WebDriverException e) {
			LOG.error(e.getMessage());
			if (e.getMessage().contains("Other element would receive the click:")) {
				waitForInvisibilityOfMask();
				element.click();
			}
		}
	}

	/**
	 * Control click.
	 *
	 * @param element
	 *            the element
	 */
	public void ControlClick(WebElement element) {
		WaitForElementVisible(element);
		WaitForElementToBeClickable(element);
		action.keyDown(Keys.LEFT_CONTROL).click(element).keyUp(Keys.LEFT_CONTROL).build().perform();
	}

	/**
	 * Shift click.
	 *
	 * @param element
	 *            the element
	 */
	public void ShiftClick(WebElement element) {
		WaitForElementVisible(element);
		WaitForElementToBeClickable(element);
		action.keyDown(Keys.LEFT_SHIFT).click(element).keyUp(Keys.LEFT_SHIFT).build().perform();
	}

	/**
	 * CTRL click.
	 *
	 * @param element
	 *            the element
	 */
	public void CTRLClick(WebElement element) {
		action.keyDown(Keys.LEFT_CONTROL).click(element).keyUp(Keys.LEFT_CONTROL).build().perform();
	}

	/**
	 * Right click.
	 *
	 * @param element
	 *            the element
	 */
	public void rightClick(WebElement element) {
		WaitForElementVisible(element);
		WaitForElementToBeClickable(element);
		action.contextClick(element).build().perform();
		scrollToElement(getElementQuick(By.className("x-menu-list")));
	}

	/**
	 * Right click 1.
	 *
	 * @param element
	 *            the element
	 */
	public void rightClick1(WebElement element) {
		WaitForElementVisible(element);
		WaitForElementToBeClickable(element);
		action.contextClick(element).build().perform();
	}

	/**
	 * Right click 2.
	 *
	 * @param element
	 *            the element
	 */
	public void rightClick2(WebElement element) {
		WaitForElementToBeClickable(element);
		action.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build()
				.perform();
		scrollToElement(getElementQuick(By.className("x-menu-list")));
	}

	/**
	 * Double click.
	 *
	 * @param element
	 *            the element
	 */
	public void doubleClick(WebElement element) {
		if (!element.isDisplayed()) {
			scrollToElement(element);
		}
		ThreadSleep(200);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"arguments[0].dispatchEvent (new MouseEvent('dblclick', { 'view': window, 'bubbles': true, 'cancelable': true}));",
				element);
		ThreadSleep(200);
	}

	/**
	 * Double click 1.
	 *
	 * @param element
	 *            the element
	 */
	public void doubleClick1(WebElement element) {
		ThreadSleep(200);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"arguments[0].dispatchEvent (new MouseEvent('dblclick', { 'view': window, 'bubbles': true, 'cancelable': true}));",
				element);
		ThreadSleep(200);
	}

	/**
	 * Double click.
	 *
	 * @param element
	 *            the element
	 */
	public void DoubleClick(WebElement element) {
		action.doubleClick(element).build().perform();
		ThreadSleep(300);
	}

	/**
	 * Scroll to element.
	 *
	 * @param element
	 *            the element
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		ThreadSleep(300);
	}

	/**
	 * Mouse over JS.
	 *
	 * @param element
	 *            the element
	 */
	public void mouseOverJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("if(document.createEvent){var evObj =
		// document.createEvent('MouseEvents');evObj.initEvent('mouseover',true,
		// false); arguments[0].dispatchEvent(evObj);} else
		// if(document.createEventObject) {
		// arguments[0].fireEvent('onmouseover');}", element);
		js.executeScript(
				"var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);",
				element);
		ThreadSleep(300);
	}

	/**
	 * Drag and drop.
	 *
	 * @param elementfrom
	 *            the elementfrom
	 * @param elementTo
	 *            the element to
	 */
	public void dragAndDrop(WebElement elementfrom, WebElement elementTo) {
		action.dragAndDrop(elementfrom, elementTo).build().perform();
		ThreadSleep(500);
	}

	/**
	 * Checks if element is displayed.
	 *
	 * @param element
	 *            the element
	 * @return true, if is element displayed
	 */
	public boolean isElementDisplayed(WebElement element) {

		driver.manage().timeouts().implicitlyWait(Constants.QUICK_IMPLICIT_WAIT, TimeUnit.SECONDS);

		boolean displayed = false;
		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return displayed;
	}

	/**
	 * Quickly checks if element is displayed.
	 *
	 * @param element
	 *            the element
	 * @return true, if is element displayed
	 */
	public boolean isElementDisplayedQuicker(WebElement element) {

		driver.manage().timeouts().implicitlyWait(Constants.QUICK_IMPLICIT_WAIT_2, TimeUnit.SECONDS);

		boolean displayed = false;
		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return displayed;
	}

	/**
	 * Gets the element text.
	 *
	 * @param element
	 *            the element
	 * @return the element text
	 */
	public String getElementText(WebElement element) {

		String text = "";

		try {
			if (element.getTagName().equals("input")) {
				if (element.getAttribute("type").equals("text")) {
					text = element.getAttribute("value").trim();
				}
			} else {
				text = element.getText().trim();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		return text;
	}

	/**
	 * Gets the element.
	 *
	 * @param by
	 *            the by
	 * @return the element
	 */
	public WebElement getElement(By by) {

		WebElement element = null;
		try {
			LOG.info("Finding the element by " + by.toString());

			element = driver.findElement(by);
		} catch (Exception e) {
			LOG.error("Element could not be found. " + e.getMessage());
		}
		return element;
	}

	/**
	 * Gets the element quick.
	 *
	 * @param by
	 *            the by
	 * @return the element quick
	 */
	public WebElement getElementQuick(By by) {

		driver.manage().timeouts().implicitlyWait(Constants.QUICK_IMPLICIT_WAIT, TimeUnit.SECONDS);

		WebElement element = null;
		try {
			System.out.println("Finding the element by " + by.toString());
			element = driver.findElement(by);
			scrollToElement(element);
		} catch (Exception e) {
			LOG.error("Element could not be found. " + e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return element;
	}

	/**
	 * Gets the element from parent element.
	 *
	 * @param parentEle
	 *            the parent element
	 * @param by
	 *            the by
	 * @return the element from element
	 */
	public WebElement getElementFromElement(WebElement parentEle, By by) {
		driver.manage().timeouts().implicitlyWait(Constants.QUICK_IMPLICIT_WAIT, TimeUnit.SECONDS);

		WebElement element = null;

		try {
			element = parentEle.findElement(by);
		} catch (Exception e) {
			LOG.error("Element could not be found. " + e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return element;

	}

	/**
	 * Gets the quick list of element based on given locator.
	 *
	 * @param by
	 *            the by
	 * @return the quick list of element
	 */
	public List<WebElement> getQuickListOfElement(By by) {
		driver.manage().timeouts().implicitlyWait(Constants.QUICK_IMPLICIT_WAIT, TimeUnit.SECONDS);

		List<WebElement> elementList = driver.findElements(by);

		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

		return elementList;
	}

	/**
	 * Wait for staleness of mask element.
	 */
	public void waitForStalenessOfMask() {
		WebElement mask = getElementQuick(By.className("ext-el-mask"));

		if (mask != null) {
			wait.until(ExpectedConditions.stalenessOf(mask));
		}
	}

	/**
	 * Wait for invisibility of mask element.
	 */
	public void waitForInvisibilityOfMask() {

		WebElement mask = getElementQuick(By.className("ext-el-mask"));

		if (mask != null) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ext-el-mask")));
		}
	}

	/**
	 * Wait for staleness of loader element.
	 */
	public void waitForStalenessOfLoader() {

		WebElement loader = getElementQuick(By.xpath("//div[contains(text(), 'Loading...')]"));
		try {
			if (loader != null) {
				wait.until(ExpectedConditions.stalenessOf(loader));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Wait for staleness of searching element.
	 */
	public void waitForStalenessOfSearching() {

		WebElement searching = getElementQuick(By.xpath("//div[contains(text(), 'Searching...')]"));
		if (searching != null) {
			wait.until(ExpectedConditions.stalenessOf(searching));
		}
	}

	/**
	 * Wait for staleness of please wait.
	 */
	public void waitForStalenessOfPleaseWait() {

		WebElement plsWait = getElementQuick(By.xpath("//div[contains(text(), 'Please wait...')]"));
		if (plsWait != null) {
			wait.until(ExpectedConditions.stalenessOf(plsWait));
		}
	}

	/**
	 * Gets the visible element from the list of elements.
	 *
	 * @param by
	 *            the by
	 * @return the visible element
	 */
	public WebElement getVisibleElement(By by) {

		driver.manage().timeouts().implicitlyWait(Constants.QUICK_IMPLICIT_WAIT, TimeUnit.SECONDS);

		List<WebElement> elementList = driver.findElements(by);
		WebElement element = null;

		for (WebElement ele : elementList) {
			if (ele.isDisplayed()) {
				element = ele;
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return element;
	}

	/**
	 * Creates the download folder if not exists.
	 */
	public void createDownloadFolderIfNotExists() {

		File f = new File(Constants.Download_PATH);
		if (!f.exists()) {
			f.mkdir();
		}

	}

	/**
	 * Wait for page load.
	 */
	public void waitForPageLoad() {
		LOG.info("Wait For Page Load Start.");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String state = (String) js.executeScript("return document.readyState");

		while (!"complete".equals(state)) {
			ThreadSleep(2000);
			state = (String) js.executeScript("return document.readyState");
		}
		LOG.info("Wait For Page Load End.");
	}

	/**
	 * Move mouse over.
	 *
	 * @param element
	 *            the element
	 */
	public void moveMouseOver(WebElement element) {
		WaitForElementVisible(element);
		action.moveToElement(element).build().perform();
		ThreadSleep(500);
	}

	/**
	 * Move mouse by offset in element.
	 *
	 * @param element
	 *            the element
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void moveMouseByOffsetInElement(WebElement element, int x, int y) {
		action.moveToElement(element, x, y).build().perform();
		ThreadSleep(500);
	}

	/**
	 * Type into.
	 *
	 * @param element
	 *            the element
	 * @param key
	 *            the key
	 */
	public void TypeInto(WebElement element, Keys key) {
		LOG.info("Writing '" + key + "' into web-element: " + element.toString());
		WaitForElementVisible(element);
		element.clear();
		element.sendKeys(key);
		ThreadSleep(500);
	}

	/**
	 * Gets the list of elements.
	 *
	 * @param by
	 *            the by
	 * @return the list of elements
	 */
	public List<WebElement> getListOfElements(By by) {
		List<WebElement> elementList = driver.findElements(by);
		return elementList;
	}

	/**
	 * Gets the list of visible elements.
	 *
	 * @param by
	 *            the by
	 * @return the list of visible elements
	 */
	public List<WebElement> getListOfVisibleElements(By by) {
		List<WebElement> elementList = driver.findElements(by);
		List<WebElement> elementList1 = new ArrayList<WebElement>();

		for (WebElement element : elementList) {
			if (element.isDisplayed()) {
				elementList1.add(element);
			}
		}

		return elementList1;
	}

}
