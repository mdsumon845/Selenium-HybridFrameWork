package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{

	public WishListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locator
	@FindBy(xpath="//i[@class='fas fa-cart-plus']") WebElement btnAddToCart;
	@FindBy(xpath="//a[@class='btn btn-primary btn-block']") WebElement btnViewCart;
	@FindBy(xpath="//li[text()='My Wish List']") WebElement txtMyWishList;
	@FindBy(xpath="//table[@class='table table-hover border']//tbody//tr//td[2]//a[text()='Palm Treo Pro']") WebElement txtProductPresence;
	
	
	
	//action method
	public void clickOnAddtoCartBtn() 
	{
		btnAddToCart.click();	
	}

	public void clickOnViewCart() 
	{
		btnViewCart.click();
	}
	
	public boolean getMyWishListText() 
	{
		try 
		{
			return txtMyWishList.isDisplayed();	
		}catch(Exception e) 
		{
			return false;
		}
	}
	
	public  boolean isProductIsDisplayed()
	{
		try 
		{
			return txtProductPresence.isDisplayed();	
		}catch(Exception e) 
		{
			return false;
		}
	}
}
