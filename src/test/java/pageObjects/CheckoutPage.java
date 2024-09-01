package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage  extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-payment-firstname']") WebElement txtfirstName;
	@FindBy(xpath="//input[@id='input-payment-lastname']") WebElement txtlastName;
	@FindBy(xpath="//input[@id='input-payment-company']']") WebElement txtComapnyName;
	@FindBy(xpath="//input[@id='input-payment-address-1']") WebElement txtAddress1;
	@FindBy(xpath="//input[@id='input-payment-address-2']") WebElement txtAddress2;
	@FindBy(xpath="//input[@id='input-payment-city']") WebElement txtCity;
	@FindBy(xpath="//input[@id='input-payment-postcode']") WebElement txtPostCode;
	@FindBy(xpath="//select[@id='input-payment-country']") WebElement selectCountry;
	@FindBy(xpath="//select[@id='input-payment-zone']") WebElement selectState;
	@FindBy(xpath="//textarea[@id='input-comment']") WebElement textareaComment;
	@FindBy(xpath="//label[@for='input-agree']") WebElement checkAgree;
	@FindBy(xpath="//button[normalize-space()='Continue']") WebElement btnContinue;
	
	
	//action method
	
	public void setFirstName(String firstName) 
	{
		txtfirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) 
	{
		txtfirstName.sendKeys(lastName);
	}
	public void setCompanyName(String com) 
	{
		txtComapnyName.sendKeys(com);
	}

	public void setAddress1(String add1) 
	{
		txtAddress1.sendKeys(add1);
	}

	public void setAddress2(String add2) 
	{
		txtAddress2.sendKeys(add2);
	}

	public void setCity(String city) 
	{
		txtCity.sendKeys(city);
	}

	public void setPostCode(String postcode) 
	{
		txtPostCode.sendKeys(postcode);
	}

	public void selectCountry() 
	{
		WebElement country=selectCountry;
		Select countrysSelect=new Select(country);
		countrysSelect.selectByVisibleText("United Arab Emirates"); 
	}

	public void selectState() 
	{
		WebElement state=selectState;
		Select stateSelect=new Select(state);
		stateSelect.selectByVisibleText("Dubai");
	}
	
	public void setComment(String comment) 
	{
		textareaComment.sendKeys(comment);
	}
	
	public void checkAgree() 
	{
		checkAgree.click();
	}
	
	public void clickContinue() 
	{
		btnContinue.click();
	}
}
