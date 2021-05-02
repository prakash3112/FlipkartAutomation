package com.Flipkart.Util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * The Class GenerateData.
 */
public class GenerateData {

	/** The generate data. */
	private static GenerateData generateData;

	/**
	 * Instantiates a new generate data.
	 */
	private GenerateData() {

	}

	/**
	 * Gets the single instance of GenerateData.
	 *
	 * @return single instance of GenerateData
	 */
	public static GenerateData getInstance() {
		if (generateData == null) {
			generateData = new GenerateData();
		}
		return generateData;
	}

	/**
	 * Generate random string.
	 *
	 * @param length
	 *            the length
	 * @return the string
	 */
	public String generateRandomString(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	/**
	 * Generate random number.
	 *
	 * @param length
	 *            the length
	 * @return the string
	 */
	public String generateRandomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	/**
	 * Generate random alpha numeric.
	 *
	 * @param length
	 *            the length
	 * @return the string
	 */
	public String generateRandomAlphaNumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	/**
	 * Generate string with allobed spl chars.
	 *
	 * @param length
	 *            the length
	 * @param allowdSplChrs
	 *            the allowd spl chrs
	 * @return the string
	 */
	public String generateStringWithAllobedSplChars(int length, String allowdSplChrs) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
				"1234567890" + // numbers
				allowdSplChrs;
		return RandomStringUtils.random(length, allowedChars);
	}

	/**
	 * Generate email.
	 *
	 * @param length
	 *            the length
	 * @return the string
	 */
	public String generateEmail(int length) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
				"1234567890" + // numbers
				"_-."; // special characters
		String email = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		email = temp.substring(0, temp.length() - 9) + "@test.org";
		return email;
	}

	/**
	 * Generate url.
	 *
	 * @param length
	 *            the length
	 * @return the string
	 */
	public String generateUrl(int length) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
				"1234567890" + // numbers
				"_-."; // special characters
		String url = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		url = temp.substring(0, 3) + "." + temp.substring(4, temp.length() - 4) + "."
				+ temp.substring(temp.length() - 3);
		return url;
	}

}
