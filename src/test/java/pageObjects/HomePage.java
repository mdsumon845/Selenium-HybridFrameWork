package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="(//span[normalize-space()='My account'])[2]") WebElement myAccount;
	@FindBy(xpath="//span[normalize-space()='Register']") WebElement registerLink;
	@FindBy(xpath="//img[@alt='Poco Electro']") WebElement logo;
	@FindBy(xpath="//span[normalize-space()='Login']") WebElement loginLink;
	@FindBy(xpath="(//input[@name='search'])[1]") WebElement textSearchBar;
	@FindBy(xpath="//button[normalize-space()='Search']") WebElement btnSearch;
	@FindBy(xpath="//div[@class='product-thumb']//div[@class='caption']//a") WebElement resultSearch;
	@FindBy(xpath="(//button[normalize-space()='All Categories'])[1]") WebElement linkCategoryList;
	@FindBy(xpath="(//div[@class='dropdown-menu dropdown-menu-left'])[1]//a") List<WebElement> linkCategoryListsDisplay;
	
	
	
	//action method
	public boolean logoPresence() 
	{
		return logo.isDisplayed();
	}
	
	public boolean searchBarPresence() 
	{
		try 
		{
			return textSearchBar.isDisplayed();
		}catch(Exception e) 
		{
			return false;
		}
	}
	
	
	public boolean searchBarEnablity() 
	{
		try 
		{
			return btnSearch.isEnabled();
		}catch(Exception e) 
		{
			return false;
		}
	}
	
	public void productSearch(String product) 
	{
		textSearchBar.sendKeys(product);
		btnSearch.click();	
	}
	
	
	public void clickSearchBtn() 
	{
		btnSearch.click();	
	}
	public int categoryList() 
	{
		try
		{
			linkCategoryList.click();
			 List<WebElement> lists=linkCategoryListsDisplay;
			return lists.size();	
		}catch(Exception e) 
		{
			return -1;
		}	
	}
	
	
	public void hoverMyAccount() 
	{
		Actions action=new Actions(driver);
		action.moveToElement(myAccount).build().perform();
	}
	
	public void clickRegister() 
	{
		registerLink.click();
	}
	
	public void clickLogin() 
	{
		loginLink.click();
	}
}
