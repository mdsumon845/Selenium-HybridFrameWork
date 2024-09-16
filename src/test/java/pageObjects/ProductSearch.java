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
	@FindBy(xpath="//ul[@class='pagination']//li[@class='page-item']") List<WebElement> pageItem;
//	@FindBy(xpath="//ul[@class='pagination']//a[text()='" + p + "']") WebElement linkPage;
	@FindBy(xpath="//div[text()='Showing 1 to 15 of 75 (5 Pages)']") WebElement textpageNumber;
	
//	 driver.findElement(By.xpath("//ul[@class='ant-pagination ']//a[text()="+p+"]"));
	
	

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
	
	
	public void scrollUptoPageNumberText() 
	{
		WebElement text=textpageNumber;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", text);
	}
	public int totalpages() 
	{
		return  pageItem.size();
		
	}
	
	

	  // Method to check if a specific page link is available
    public boolean isPageLinkAvailable(int p) {
        try {
            WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']//a[text()="+ p +"]"));
            return page.isDisplayed();
        } catch (Exception e) {
            return false; // If there's an exception, the page link does not exist
        }
    }
    
    // Method to click on a specific page number
    public void clickPage(int p) {
        WebElement page = driver.findElement(By.xpath("//ul[@class='pagination']//a[text()="+p +"]"));
        page.click();
    }
}
