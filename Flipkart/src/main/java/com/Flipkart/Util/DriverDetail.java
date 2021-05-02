package com.Flipkart.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.openqa.selenium.WebDriver;

/**
 * The Class DriverDetail.
 */
public class DriverDetail {

	/** The driver ID. */
	private String driverID;

	/** The feature ID. */
	private String featureID;

	/** The scenario ID. */
	private String scenarioID;

	/** The driver map. */
	private static Map<String, Object> driverMap = new HashMap<String, Object>();

	/** The scenario list. */
	public static ArrayList<String> scenarioList = new ArrayList<String>();

	/** The un occupied driver. */
	public static LinkedList<WebDriver> unOccupiedDriver = new LinkedList<WebDriver>();

	/**
	 * Gets the feature ID.
	 *
	 * @return the feature ID
	 */
	public String getFeatureID() {
		return featureID;
	}

	/**
	 * Sets the feature ID.
	 *
	 * @param featureID
	 *            the new feature ID
	 */
	public void setFeatureID(String featureID) {
		this.featureID = featureID;
	}

	/**
	 * Gets the scenario ID.
	 *
	 * @return the scenario ID
	 */
	public String getScenarioID() {
		return scenarioID;
	}

	/**
	 * Sets the scenario ID.
	 *
	 * @param scenarioID
	 *            the new scenario ID
	 */
	public void setScenarioID(String scenarioID) {
		this.scenarioID = scenarioID;
	}

	/**
	 * Gets the driver ID.
	 *
	 * @return the driver ID
	 */
	public String getDriverID() {
		return driverID;
	}

	/**
	 * Sets the driver ID.
	 *
	 * @param driverID
	 *            the new driver ID
	 */
	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	/**
	 * Put into map.
	 *
	 * @param key
	 *            the key
	 * @param data
	 *            the data
	 */
	public static void PutIntoMap(String key, Object data) {
		driverMap.put(key, data);
	}

	/**
	 * Gets the from map.
	 *
	 * @param key
	 *            the key
	 * @return the from map
	 */
	public static Object getFromMap(String key) {
		return driverMap.get(key);
	}

	/**
	 * Put into scenario list.
	 *
	 * @param scenarioID
	 *            the scenario ID
	 */
	public void PutIntoScenarioList(String scenarioID) {
		scenarioList.add(scenarioID);
	}

	/**
	 * Gets the unoccupied driver.
	 *
	 * @return the unoccupied driver
	 */
	public static WebDriver getUnoccupiedDriver() {
		synchronized (DriverDetail.class) {
			if (unOccupiedDriver.size() > 0) {
				return unOccupiedDriver.pop();
			} else {
				return null;
			}
		}
	}

	/**
	 * Push unoccupied driver.
	 *
	 * @param driver
	 *            the driver
	 */
	public static void PushUnoccupiedDriver(WebDriver driver) {
		synchronized (DriverDetail.class) {
			unOccupiedDriver.add(driver);
		}
	}

	/**
	 * End.
	 */
	public static void end() {
		for (int i = 0; i < unOccupiedDriver.size(); i++) {
			unOccupiedDriver.get(i).quit();
		}
	}

}
