package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductSearch  extends BasePage{

	public ProductSearch(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators
	@FindBy(xpath="(//div[normalize-space()='Price'])[2]") WebElement priceFilterLocation;
	@FindBy(xpath="(//label[normalize-space()='Apple'])[2]") WebElement btnAppleBrandClick;
	@FindBy(xpath="//label[@for='mz-fss-0--1']") WebElement btnInStock;
	@FindBy(xpath="//i[@class='fas fa-th-list']") WebElement btnListIcon;
	@FindBy(xpath="(//div[@class='ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span)[3]") 
	WebElement locationLowPrice;
	@FindBy(xpath="(//div[normalize-space()='Availability'])[2]") WebElement txtAvailability;
	@FindBy(xpath="//div[@class='product-thumb']//div[@class='caption']//a") List<WebElement> searchResults;
	

	//action method
	public void scrollUptoPriceFillter() 
	{
		WebElement price=priceFilterLocation;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", price);	
	}

	public void priceFilltering() 
	{
		WebElement lowPrice=locationLowPrice;
		Actions action =new Actions(driver);	
		System.out.println("current location of min price before moving: "+lowPrice.getLocation());
		action.dragAndDropBy(lowPrice, 150,328).build().perform();
		System.out.println("current location of min price after moving: "+lowPrice.getLocation());		
	}

	public void clickOnAppleBrand() 
	{
		btnAppleBrandClick.click();
	}
	
	public void clickInStockBtn() 
	{
		WebElement availability=txtAvailability;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", availability);
		btnInStock.click();		
	}
	
	public void clickOnListIcon() 
	{
		btnListIcon.click();
	}
	
	public void ProductAdvanceSearchResults() 
	{
		List<WebElement> results=searchResults;
		System.out.println(results.size());
		if(results.isEmpty()) 
		{
			 System.out.println("No search results found.");
	         Assert.fail();
		} else 
		{
			for(WebElement result:results) 
			{
				String res=result.getText();
				System.out.println(res);	
				if(res.equals("MacBook Air") || res.equals("MacBook Pro") )	
				{
					System.out.println("all products are related to search");
					Assert.assertTrue(true);	
				} else 
				{
					System.out.println("invalid products found:"+res);
					Assert.fail();	
				}		
			}		
		}
	}
}
