package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC_006_ProductPageTest  extends BaseClass{
	@Test(groups={"Sanity","Master"})
	public void verifyRelatedSearchProducts() throws Exception
	{
		logger.info("***Related Product Search test has started...");
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.productSearch(p.getProperty("productSearch1"));
			Thread.sleep(3000);
			ProductPage pp=new ProductPage(driver);
			pp.searchResults();
			
		} catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();
		}
		
		finally 
		{
			logger.info("***Related Product Search test has finished...");
		}	
	}
}
	
	
	

