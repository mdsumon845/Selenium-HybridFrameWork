package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub	
	}
	
	//locators
	@FindBy(xpath="//input[@name='firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@name='lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@name='email']") WebElement txtEmail;
	@FindBy(xpath="//input[@name='telephone']") WebElement txtTel;
	@FindBy(xpath="//input[@name='password']") WebElement txtPassword;
	@FindBy(xpath="//input[@name='confirm']") WebElement txtConfirmPassword;		
	@FindBy(xpath="//label[normalize-space()='Yes']") WebElement radioBtnSubscribe;	
	@FindBy(xpath="(//label[@class='custom-control-label'])[3]") WebElement checkboxPrivacyPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement mgsConfirmation;
	
	//Action class
	
	public void SetFirstName(String firstName) 
	{
		txtFirstName.sendKeys(firstName);
	}
	
	public void SetlastName(String lastName) 
	{
		txtLastName.sendKeys(lastName);
	}
	
	public void SetEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}
	
	public void SetTelephone(String tel) 
	{
		txtTel.sendKeys(tel);
	}
	
	public void SetPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void SetConfirmPassword(String pwd) 
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void SetSubscribe() 
	{
		radioBtnSubscribe.click();
	}
	
	public void SetPrivacy() 
	{
		checkboxPrivacyPolicy.click();
	}
	
	public void clickContinue() 
	{
		btnContinue.click();
	}
	
	public  String getConfirmationMessage() 
	{
		try
		{
			return mgsConfirmation.getText();
		}
		catch(Exception e) 
		{
			return (e.getMessage());	
		}	
	}	
}
