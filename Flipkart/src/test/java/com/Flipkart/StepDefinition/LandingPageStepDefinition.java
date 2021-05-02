package com.Flipkart.StepDefinition;

import com.Flipkart.Cucumber.TestContext;
import com.Flipkart.PageObjects.HomePage;

/**
 * The Class LandingPageStepDefinition.
 */
public class LandingPageStepDefinition {

	/** The home page. */
	public HomePage homePage;

	public LandingPageStepDefinition(TestContext testContext) {
		homePage = testContext.getHomePage();

	}

}
