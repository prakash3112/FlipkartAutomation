package com.Flipkart.PageObjects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Flipkart.Helper.WebElementHelper;

/**
 * The Class HomePage.
 */
public class HomePage extends BasePage {

	public ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

	/**
	 * Instantiates a new home page.
	 *
	 * @param driver
	 *            the driver
	 * @param webElementHelper
	 *            the web element helper
	 */

	public HomePage(WebDriver driver, WebElementHelper webElementHelper) {
		super(driver, webElementHelper);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='q']")
	private WebElement ClickOnSearch;
	
	public void  EnterSearchDetails(String text) {
         webElementHelper.click(ClickOnSearch);
				
		webElementHelper.TypeInto(ClickOnSearch, text);
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='aajZCb']"));
        for (int i=0; i<rows.size(); i++){
        	
            System.out.println(rows.get(i).getText());
     
        }

	}
	
	@FindBy(xpath = "(//*[@role='option'])[1]")
	private WebElement clickOnFilpkart;
	
	public void SelectSearchValue(){
		
		webElementHelper.click(clickOnFilpkart);
		
	}
	@FindBy(xpath= "//h3[text()='Flipkart']")
	private WebElement Filpkartlink;
	
	public void SelectFilpkartLink(){
		
		webElementHelper.click(Filpkartlink);
	}
	@FindBy(xpath="//button[text()='✕']")
	private WebElement crossButton;
	
	public void clickOnCrossButton(){
		
		webElementHelper.click(crossButton);
		
	}
	
	@FindBy(xpath="//p[text()='TVs & Appliances']")
	private WebElement clickOnTVAppliances;
	
	public void selectAppliances(){
		webElementHelper.click(clickOnTVAppliances);
		//Actions act = new Actions(driver);
		//act.moveToElement(dropdownAppliances).build().perform();
	}
	
	@FindBy(xpath="//span[text()='TVs & Appliances']")
	private WebElement selectOnTVAppliances;
	
	public void selectTVandAppliances(){
		//webElementHelper.click(clickOnTVAppliances);
		Actions act = new Actions(driver);
		act.moveToElement(selectOnTVAppliances).build().perform();
	}
	
	
	@FindBy(xpath="//*[text()='Air Conditioners']")
	private WebElement airCondition;
	
	public void selectAirCondition(){
		
		Actions act = new Actions(driver);
		act.moveToElement(airCondition).build().perform();
	}
	
	@FindBy(xpath="//*[text()='Window ACs']")
	private WebElement windowACs;
	
	public void selectWindowACs(){
		
		webElementHelper.click(windowACs);
	}
	
	
     @FindBy(xpath="(//span[@class='f3A4_V'])[2]")
     private WebElement secondValue;
     
     public void SelectSecondValue(){
    	 
    	 webElementHelper.click(secondValue);
     }
     
     @FindBy(xpath="(//span[@class='f3A4_V'])[3]")
     private WebElement thirdValue;
     
     public void SelectThirdValue(){
    	 
    	 webElementHelper.click(thirdValue);
     }
     
     @FindBy(xpath="(//span[@class='f3A4_V'])[6]")
     private WebElement sixValue;
     
     public void SelectSixValue(){
    	 
    	 webElementHelper.click(sixValue);
     }
     
     @FindBy(xpath="//span[text()='COMPARE']")
     private WebElement compare;
     
     public void clickOnCompare(){
    	 webElementHelper.click(compare);
    	 List<WebElement> row = driver.findElements(By.xpath("//div[@class='EcigTC _1zUO2-']"));
         for (int j=0; j<row.size(); j++){
             System.out.println(row.get(0).getText());
     }
         
     }
     @FindBy(xpath="//button[text()='ADD TO CART']")
     private WebElement addToCart;
     
     public void clickOnAddToCart(){
    	 webElementHelper.click(addToCart);
    	 ThreadSleep(800);
         driver.navigate().back();
         webElementHelper.click(addToCart);
         ThreadSleep(800);
         driver.navigate().back();
         webElementHelper.click(addToCart);
    	 
     }
     @FindBy(xpath="//input[@placeholder='Enter delivery pincode']")
     private WebElement enterPinCode;
     
     public void EnterAreaPincode(String text){
    	 ThreadSleep(1500);
    	 webElementHelper.TypeIntoWithTab(enterPinCode, text);
    	 
     }
     @FindBy(xpath="//span[text()='Check']")
     private WebElement check;
     
     public void clickONcheck(){
    	 ThreadSleep(1500);
    	 webElementHelper.click(check);
    	 
    	 List<WebElement> delevery = driver.findElements(By.xpath("//div[@class='_2pqhhf']"));
         for (int k=0; k<delevery.size(); k++){
             System.out.println(delevery.get(k).getText());
         }
     
     }
     
     @FindBy(xpath="//div[@class='_12cXX4']")
     private WebElement selectDeleveryBox;
     
     public void clickOnDelevrybox(){
   	  webElementHelper.click(selectDeleveryBox);
   	 
   	  
     }
     
     public void closeBrowser(){
    	 
    	 driver.close();
     }
     
}