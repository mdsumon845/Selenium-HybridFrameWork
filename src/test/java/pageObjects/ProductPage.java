package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locators
	
	@FindBy(xpath="//div[@class='product-thumb']//div[@class='caption']//a") List<WebElement> searchResults;
	@FindBy(xpath="(//a[text()='Palm Treo Pro'])") WebElement textPalm;
	
	@FindBy(xpath="(//button[@title='Add to Wish List'])[1]") WebElement btnWishList;
	@FindBy(xpath="//a[@class='btn btn-danger btn-block']") WebElement btnLogin;
	
	
	//action method
	public void searchResults() 
	{
		List<WebElement> results=searchResults;
		System.out.println(results.size());
		if(results.isEmpty()) 
		{
			 System.out.println("No search results found.");
	         Assert.fail();
		}else 
		{
			for(WebElement result:results) 
			{
				String res=result.getText();
				System.out.println(res);
					
				if(res.equals("Samsung SyncMaster 941BW") || res.equals("Samsung Galaxy Tab 10.1") )	
				{
					System.out.println("all products are related to search");
					Assert.assertTrue(true);
						
				}else 
				{
					System.out.println("invalid products found:"+res);
					Assert.fail();	
				}		
			}		
		}
	}
	
	
	public void  productLinkClick() 
	{
		List<WebElement> results=searchResults;
		System.out.println(results);
		for(WebElement result:results) 
		{
			String res=result.getText();
			
			if(res.equals("Sony VAIO")) 
			{
				result.click();	
				break;
			}
		}
	}	
	
	public void scrollUptoProductIsAvailable() 
	{
		WebElement textpaml=textPalm;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", textpaml);	
	}
	public void clickOnWishListBtn() 
	{
		List<WebElement> results=searchResults;
		for(WebElement result:results) 
		{
			String res=result.getText();
			System.out.println(res);
				
			if(res.equals("Palm Treo Pro") )	
			{
				btnWishList.click();		
			}
		}
	}
	
	public void clickOnLoginBtn() 
	{
		btnLogin.click();
	}
}