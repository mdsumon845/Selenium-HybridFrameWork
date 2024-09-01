package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators
	@FindBy(xpath="//span[normalize-space()='Product Code:']") WebElement txtproductCode;
	@FindBy(xpath="(//input[@name='name'])[2]") WebElement txtYourName;
	@FindBy(xpath="//textarea[@id='input-review']") WebElement txtYourReview;
	@FindBy(xpath="//button[text()='Write Review']") WebElement btnWriteReview;
	@FindBy(xpath="//span[@class='start-form-check']//label[@for='rating-1-216860']") WebElement starLabel;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement textMgsConfirmation;
	@FindBy(xpath="//div[@class='product-thumb']//div[@class='caption']//a") List<WebElement> searchResults;
	@FindBy(xpath="(//button[@title='Add to Cart'])[2]") WebElement availabilityStatus;
	@FindBy(xpath="(//button[@title='Add to Cart'])[2]") WebElement textInStock;
	@FindBy(xpath="(//button[@title='Add to Cart'])[2]") WebElement textDays;
	@FindBy(xpath="(//button[@title='Add to Cart'])[2]") WebElement textPreOrder;
	@FindBy(xpath="(//button[@title='Add to Cart'])[2]") WebElement textOutOfStock;	
	@FindBy(xpath="//div[@id='entry_216842']//button[@title='Add to Cart'][normalize-space()='Add to Cart']") WebElement btnAddToCart;
	@FindBy(xpath="//a[normalize-space()='View Cart']") WebElement btnViewCart;
	@FindBy(xpath="//li[normalize-space()='Shopping Cart']") WebElement txtShoppingCart;
	
	
	//action method
	
	public boolean isProductCodeExists() 
	{
		try 
		{
			return txtproductCode.isDisplayed();	
		}catch(Exception e) 
		{
			return false;
		}
		
	}
	
	public void setStarLabel() 
	{
		starLabel.click();
	}
	
	public void setName(String name) 
	{
		txtYourName.sendKeys(name);
	}
	
	public void setReview(String review) 
	{
		txtYourReview.sendKeys(review);
	}
	
	public void clickReview()
	{
		btnWriteReview.click();
	}
	
	public boolean getReviewConfirmationMgs() 
	{
		try 
		{
			return textMgsConfirmation.isDisplayed();
		}catch(Exception e)
		{
		 return false;	
		}
	}		
}
	


	
	
	
	
	
	
	
	
	
	
	
	
	

