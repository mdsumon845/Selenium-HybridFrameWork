package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-email']") WebElement textEmail;
	@FindBy(xpath="//input[@id='input-password']") WebElement textpwd;
	@FindBy(xpath="//input[@type='submit']") WebElement btnLogin;
	
	//action method
	
	public void SetEmail(String email) 
	{
		textEmail.sendKeys(email);	
	}

	public void SetPassword(String pwd) 
	{
		textpwd.sendKeys(pwd);	
	}
	
	public void clickLoginBtn() 
	{
		btnLogin.click();
	}
}
