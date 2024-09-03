package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import testBase.BaseClass;

public class TC_008_CartPageTest extends BaseClass{
	@Test(priority=4,groups={"Smoke","Master"})
	public void verifyAddToCartProduct() throws Exception 
	{
		logger.info("***varifying addToCartProduct has started...");
		try 
		{
			//homePage
			HomePage hp=new HomePage(driver);
			hp.productSearch(p.getProperty("productSearch3"));
			//Cart page
			CartPage cartPage=new CartPage(driver);
			cartPage.verifyProductsForAddingIntoCart();

		} catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();	
		}
		finally 
		{
			logger.info("***varifying addToCartProduct has finished...");
		}			
	}


	@Test(priority=3,groups={"Smoke","Master"})

	public void addingProductToCart() 
	{
		logger.info("***Adding product to the Cart has started...");
		try 
		{
			//homePage
			HomePage hp=new HomePage(driver);
			hp.productSearch(p.getProperty("productSearch3"));
			//Cart page
			CartPage cartPage=new CartPage(driver);
			cartPage.addProductToCart();
			cartPage.clickCheckout();

		} catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();	
		}

		finally 
		{
			logger.info("***Adding product to the Cart has finished...");
		}		
	}
}

