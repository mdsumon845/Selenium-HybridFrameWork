package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_0013_RemovingProductFromCartPage  extends BaseClass{

	@Test(priority=1,groups= {"Sanity","Master"})
	
	public void verifyRemovingProductFromCart() 
	{
		logger.info("***Removing product from the Cart has started...");
		try 
		{
			//homePage
			HomePage hp=new HomePage(driver);
			hp.productSearch(p.getProperty("productSearch3"));
			//Cart page
			CartPage cartPage=new CartPage(driver);
			cartPage.addProductToCart();
			Thread.sleep(1000);
			cartPage.clickOnRemoveBtn();
			boolean expectedMgs=cartPage.getEmptyMessagsAfterRemovingProduct();
			Assert.assertEquals(expectedMgs, true);

		} catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();	
		}

		finally 
		{
			logger.info("***Removing product from the Cart has finished...");
		}		
	}
}
