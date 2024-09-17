package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators
	@FindBy(xpath="//a[text()='Checkout']") WebElement btnCheckOut;
	@FindBy(xpath="//div[@class='product-thumb']//div[@class='caption']//a") List<WebElement> searchResults;
	@FindBy(xpath="(//button[@title='Add to Cart'])[2]") WebElement availabilityStatus;
	@FindBy(xpath="(//button[@title='Add to Cart'])[2]") WebElement textInStock;
	@FindBy(xpath="(//button[@title='Add to Cart'])[2]") WebElement textDays;
	@FindBy(xpath="(//button[@title='Add to Cart'])[2]") WebElement textPreOrder;
	@FindBy(xpath="(//button[@title='Add to Cart'])[2]") WebElement textOutOfStock;	
	@FindBy(xpath="//div[@id='entry_216842']//button[@title='Add to Cart'][normalize-space()='Add to Cart']") WebElement btnAddToCart;
	@FindBy(xpath="//a[normalize-space()='View Cart']") WebElement btnViewCart;
	@FindBy(xpath="//li[normalize-space()='Shopping Cart']") WebElement txtShoppingCart;
	@FindBy(xpath="//table[@class='table table-bordered']//tbody//tr/td[4]//button[2]") 
	List<WebElement> btnProductsRemove; 
	@FindBy(xpath="(//p[text()='Your shopping cart is empty!'])[2]") WebElement textShoppingCartEmptyMgs;
	@FindBy(xpath="//a[@aria-label='Wishlist']") WebElement btnWishList;
	@FindBy(xpath="//li[normalize-space()='Shopping Cart']") WebElement textShoppingCart;
	
	
	
	//action method
	
	public boolean getCartPage() 
	{
		try 
		{
			return txtShoppingCart.isDisplayed();
		}catch(Exception e) 
		{
			return false;
		}
		
	}
	
	public void verifyProductsForAddingIntoCart() throws Exception 
	{
		List<WebElement> results=searchResults;
		System.out.println(results.size());
		for(WebElement result:results) 
		{
			result.click();
			Thread.sleep(3000);
			String res=availabilityStatus.getText();
			System.out.println(res);
			 if (res.equalsIgnoreCase("2-3 Days") ||res.equalsIgnoreCase("Pre-Order") ||res.equalsIgnoreCase("Out Of Stock")) 
			 {   // Navigate back to the product list
				 JavascriptExecutor js = (JavascriptExecutor) driver;
		         js.executeScript("window.history.back();"); 
		         Thread.sleep(3000);  
		      }else
		      {
	    	  	btnAddToCart.click();
                btnViewCart.click(); 
              
                JavascriptExecutor js = (JavascriptExecutor) driver;
                // Navigate back to the product list
		        js.executeScript("window.history.back();"); 
		        js.executeScript("window.history.back();"); 
		      }
		}			
	}	
	
	
	public void addProductToCart() throws Exception 
	{
		List<WebElement> results=searchResults;
		System.out.println(results.size());
		for(WebElement result:results) 
		{
			result.click();
			Thread.sleep(3000);
			String res=availabilityStatus.getText();
			System.out.println(res);
			
			 if (res.equals("ADD TO CART")) 
			 {   
				 	btnAddToCart.click();
	                btnViewCart.click(); 
	                break;
		      }else 
		      {
		    	  JavascriptExecutor js = (JavascriptExecutor) driver;
	              // Navigate back to the product list
			      js.executeScript("window.history.back();");  
		      }
		}
	}
	
	public void clickCheckout() 
	{
		btnCheckOut.click();	
	}
	
	public void clickOnRemoveBtn() throws Exception 
	{
		List<WebElement> removeableProducts=btnProductsRemove;
		
		for(WebElement removeProduct:removeableProducts) 
		{
			removeProduct.click();	
			Thread.sleep(1000);
		}
	}
	
	public boolean getEmptyMessagsAfterRemovingProduct() 
	{
		try 
		{
			return textShoppingCartEmptyMgs.isDisplayed();
		}catch(Exception e) 
		{
			return false;
		}
		
	}
	
	public void clcikOnWishListBtn() 
	{
		btnWishList.click();
	}
	
	public boolean getShoppingCartText() 
	{
		try 
		{
			return textShoppingCart.isDisplayed();	
		}catch(Exception e) 
		{
			return false;
		}
	}
}