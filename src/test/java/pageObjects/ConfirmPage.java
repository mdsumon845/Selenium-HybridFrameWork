package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmPage extends BasePage{

	public ConfirmPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators
	@FindBy(xpath="//button[normalize-space()='Confirm Order']") WebElement btnConfirm;
	@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']") WebElement mgsOrderConfirmation;
	
	//action method
	
	public void clickConfirm() 
	{
		btnConfirm.click();
	}
	
	public boolean getOrderConfirmationMgs() 
	{
		try 
		{
			return mgsOrderConfirmation.isDisplayed();	
		}catch(Exception e)
		{
			return false;
		}	
	}
}
