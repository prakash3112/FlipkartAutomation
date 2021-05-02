package com.Flipkart.Runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.Flipkart.Helper.PropertyHelper;
import com.Flipkart.Util.Constants;
import com.Flipkart.Util.CustomFormatter;
import com.Flipkart.Util.Variables;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = {
				"classpath:featureFiles/Flipkart/FlipkartAutomation.feature",
					},
//		tags = { "~@ignore"},
		glue = { "com.Flipkart.StepDefinition" },
		plugin = { "junit:target/cucumberJunit.xml" , "com.Flipkart.Util.CustomFormatter"}   
		)

public class SequentialRunnerTest {
	
	/** The log. */
	private static Logger log = Logger.getLogger(SequentialRunnerTest.class.getName());
	
	private static Properties CONFIG = PropertyHelper.getConfig(Constants.CONFIG_PROPERTY);
	
	/** The report path. */
	private static File reportPath;

	/**
	 * Setup - called before the test-suite.
	 */
	@BeforeClass
	public static void Setup() {

		if (CustomFormatter.getReportInstance() == null) {

			Date d = new Date();
			String today = new SimpleDateFormat(Constants.SCREENSHOT_SDF).format(d);
			String reportName = String.format("Report_%s%s", today, Constants.HTML_EXTENSION);

			File dir = new File(today);
			dir = new File(Constants.REPORT_PATH + dir);
			if (!dir.exists()) {
				dir.mkdir();
				Variables.reportFolderName = dir;
			}
			reportPath = new File(dir + "/" + reportName);
			File folderPath = new File(dir + "/");

			CustomFormatter.initiateCustomFormatter(reportPath, folderPath);

			File extentConfig = new File(Constants.CONFIG_FILES_URI + Constants.EXTENT_FILE);
			CustomFormatter.loadConfig(extentConfig);
			CustomFormatter.addSystemInfo("user", System.getProperty("user.name"));
			CustomFormatter.addSystemInfo("os", System.getProperty("os.name"));
			CustomFormatter.addSystemInfo("browser", CONFIG.getProperty("browser"));

		} else {
			CustomFormatter.initiateCustomFormatter();
		}

		/************************ LOGGER ***********************/
		PropertyConfigurator.configure(Constants.PROPERTIES_URI + "log4j.properties");
		log.info("********* Starting Test Execution. ***********");

	}
	
}
