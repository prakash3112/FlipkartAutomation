package com.Flipkart.StepDefinition;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.Flipkart.Cucumber.TestContext;
import com.Flipkart.PageObjects.CommonPage;
import com.Flipkart.Util.Constants;
import com.Flipkart.Util.DriverDetail;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * The Class BaseSteps.
 */

public class BaseSteps {

	/** The common page. */
	private CommonPage commonPage;
	
	/** The driver detail. */
	public DriverDetail driverDetail;
	
	/** The driver. */
	public WebDriver driver;

	/** The Constant log. */
	private static final Logger log = Logger.getRootLogger();

	/** The sdf. */
	private SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATABASE_SDF);

	/** The scenario start time. */
	private String scenarioStartTime = "";

	/** The scenario end time. */
	private String scenarioEndTime = "";

	/** The scenario map. */
	private Map<String, String> scenarioMap;

	/** The scenario list. */
	private static List<Map<String, String>> scenarioList = new ArrayList<Map<String, String>>();

	/** The test context. */
	private TestContext testContext;
	
	/**
	 * Instantiates a new base steps.
	 *
	 * @param context the context
	 */
	
	public BaseSteps(TestContext context) {
		this.testContext = context;
		scenarioStartTime = sdf.format(System.currentTimeMillis());
	}
	
	/**
	 * Before scenario - called before every scenario.
	 *
	 * @param scenario
	 *            the scenario
	 */
	@Before
	public void BeforeScenario(final Scenario scenario) {

		scenarioMap = new HashMap<String, String>();

		scenarioMap.put("ScenarioStartTime", scenarioStartTime);
		scenarioMap.put("ScenarioID", scenario.getId());
		scenarioMap.put("ScenarioName", scenario.getName());

		log.info("****************************");
		log.info("Scenario : " + scenario.getName());
		log.info("Scenario start time: " + scenarioStartTime);

		System.out.println("Starting Scenario ID: " + scenario.getId());
		
	}

	/**
	 * After scenario - called after every scenario.
	 *
	 * @param scenario
	 *            the scenario
	 */
	@After
	public void AfterScenario(final Scenario scenario) {

		scenario.embed(commonPage.takeScreenShot(), "image/jpg");
		scenarioMap.put("ScenarioStatus", scenario.getStatus().toUpperCase());
		scenarioMap.put("ScenarioScreenshot", commonPage.ScreenshotName);

		testContext.tearDownDriver();
		scenarioEndTime = sdf.format(System.currentTimeMillis());
		scenarioMap.put("ScenarioEndTime", scenarioEndTime);

		log.info("The scenario '" + scenario.getName() + "' completed with status = "
				+ scenario.getStatus().toUpperCase());
		log.info("Scenario end time: " + scenarioEndTime);
		log.info("");

		scenarioList.add(scenarioMap);
		
	}

	
	/**
	 * Gets the scenario list.
	 *
	 * @return the scenario list
	 */
	public static List<Map<String, String>> getScenarioList() {
		return scenarioList;
	}

}
