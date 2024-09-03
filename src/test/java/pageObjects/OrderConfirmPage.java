package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmPage extends BasePage{

	public OrderConfirmPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators
	
	
	@FindBy(xpath="//h1[normalize-space()='Confirm Order']") WebElement txtConfirm;
	@FindBy(xpath="//button[normalize-space()='Confirm Order']") WebElement btnConfirm;
	@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']") WebElement mgsOrderConfirmation;
	
	//action method
	
	public boolean getTargetPage() 
	{
		try 
		{
			return txtConfirm.isDisplayed();
		} catch(Exception e)
		{
			return false;
		}	
	}
	
	public void clickConfirmBtn() 
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
