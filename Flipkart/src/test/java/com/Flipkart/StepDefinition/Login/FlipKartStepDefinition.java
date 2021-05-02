package com.Flipkart.StepDefinition.Login;



import com.Flipkart.Cucumber.TestContext;
import com.Flipkart.PageObjects.CommonPage;
import com.Flipkart.PageObjects.HomePage;
import com.Flipkart.PageObjects.Login.FlipkartPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * The Class LoginStepDefinition.
 */

public class FlipKartStepDefinition {

	/** The login page. */
	private FlipkartPage loginPage;

	/** The home page. */
	private HomePage homePage;

	/** The common page. */
	public CommonPage commonPage;

	/** The config. */

	/**
	 * Instantiates a new step definition.
	 *
	 * @param testContext
	 *            the test context
	 */
	public FlipKartStepDefinition(TestContext testContext) {
		loginPage = testContext.getLoginPage();
		homePage = testContext.getHomePage();
		commonPage = testContext.getCommonPage();
	}

	/**
	 * Launch application.
	 */
	@Given("^the open google web application is open$")
	public void LaunchApplication() {
		loginPage.LaunchApplication();
	}
	
	@Given("^Search for \"([^\"]*)\" Print all the search options displayed in the console from googles search field while we write Flipkart in that$")
	public void searchfor(String text){
	   
		homePage.EnterSearchDetails(text);
		
	}
	@Given("^Press enter to give out the search results and open the link for the flipkart website available$")
	public void pressenterwebsiteavailable(){
		homePage.SelectSearchValue();
		homePage.SelectFilpkartLink();
	}

	@Given("^Close the login popup on the website$")
	public void closelogpopup(){
		
		homePage.clickOnCrossButton();
	  
	}

	@Given("^Click on TV & Appliances dropdown button Navigate to AirConditioners Window ACs page$")
	public void clickondropdown(){
		homePage.selectAppliances();
		homePage.selectTVandAppliances();
		//homePage.selectAirCondition();
		homePage.selectWindowACs();
	}
	@Given("^Click on the Add To Compare checkbox of the second third and sixth products displayed$")
	public void clickoncheckboxproductsdisplayed() {
		
		homePage.SelectSecondValue();
		homePage.SelectThirdValue();
		homePage.SelectSixValue();
	 
	}

	@Given("^Click on the COMPARE button Print Name and price of all three products in the console$")
	public void clickCOMPAREbutton(){
		
		homePage.clickOnCompare();
	
	}

	@Given("^Add all the three products into the cart, one by one$")
	public void addallthreeproducts(){
		homePage.clickOnAddToCart();
	    
	}

	@Given("^Go to the cart and add your area Pincode \"([^\"]*)\" check the availability of the product delivery there Print the message getting displayed for the availability delivery of the product$")
	public void gocartareaPincodecheck(String text){
		homePage.EnterAreaPincode(text);
		homePage.clickONcheck();
	}
	@Given("^Click the Deliver to input box add$")
	public void clicktheDeliverto(){
		homePage.clickOnDelevrybox();
	}

	@Given("^another pin code \"([^\"]*)\" check the availability of the product delivery there Print the message getting displayed for the availability delivery of the product$")
	public void anotherpincodecheck(String text) {
		
		homePage.EnterAreaPincode(text);
		homePage.clickONcheck();
		
	}
  
	@Given("^Close the browser$")
	public void closethebrowser(){
		homePage.closeBrowser();
	}
	

}
