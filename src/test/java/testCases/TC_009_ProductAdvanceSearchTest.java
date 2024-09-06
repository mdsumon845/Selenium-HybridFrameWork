package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductSearch;
import testBase.BaseClass;

public class TC_009_ProductAdvanceSearchTest  extends BaseClass{
	@Test(priority=1,groups={"Sanity","Master"})
	
	public void verifyProductAdvanceSearch() throws Exception 
	{
		logger.info("***Product Advance search verify has started ...");
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.clickSearchBtn();
			ProductSearch ps=new ProductSearch(driver);
			ps.scrollUptoPriceFillter();
			ps.priceFilltering();
			Thread.sleep(1000);
			ps.clickOnAppleBrand();
			Thread.sleep(1000);
			ps.clickInStockBtn();
			Thread.sleep(1000);
			ps.clickOnListIcon();
			Thread.sleep(3000);
			ps.ProductAdvanceSearchResults();	
		}catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();
		}
		finally 
		{
			logger.info("***Product Advance search verify has finished ...");
		}	
	}
}
