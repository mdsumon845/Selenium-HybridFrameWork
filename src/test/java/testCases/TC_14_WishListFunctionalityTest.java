package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductPage;
import pageObjects.ProductSearch;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC_14_WishListFunctionalityTest  extends BaseClass{
	@Test(priority=1,groups= {"Sanity","Master"})
	
	public void verifyWishListFunctionality() throws Exception 
	{
		logger.info("***WishList Functionality Verify has Started...");
		try 
		{
			HomePage hp=new HomePage(driver);
			logger.info("***Product searching...");
			hp.productSearch(p.getProperty("productSearch4"));
			ProductPage pp=new ProductPage(driver);
			pp.scrollUptoProductIsAvailable();
			ProductSearch ps=new ProductSearch(driver);
			ps.clickOnListIcon();
			logger.info("***Click on wishlist button...");
			pp.clickOnWishListBtn();
			pp.clickOnLoginBtn();
			logger.info("***users login to the System...");
			LoginPage lp=new LoginPage(driver);
			lp.SetEmail(p.getProperty("email"));
			lp.SetPassword(p.getProperty("password"));
			lp.clickLoginBtn();
			Thread.sleep(1000);
			logger.info("***After login navigates to the my account page...");
			MyAccountPage mypage=new MyAccountPage(driver);
			mypage.clickOnWishListLink();
			WishListPage wp=new WishListPage(driver);
			logger.info("***verifying expected Mgs in the WishList page...");
			boolean expectedText=wp.getMyWishListText();
			Assert.assertEquals(expectedText, true);
			logger.info("***Click on the Add to Cart button from WishList page...");
			wp.clickOnAddtoCartBtn();
			wp.clickOnViewCart();
			CartPage cart=new CartPage(driver);
			logger.info("***verifying expected Mgs in the Cart page...");
			boolean targetText=cart.getShoppingCartText();
			Assert.assertEquals(targetText, true);
			logger.info("***Click on Wishlist icon in the Cart page...");
			cart.clcikOnWishListBtn();
			logger.info("***verifying Products are still displayed on the WishList page...");
			boolean productPresence=wp.isProductIsDisplayed();
			Assert.assertEquals(productPresence, false);
		} catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();	
		}
		finally 
		{
			logger.info("***WishList Functionality Verify has finished...");
		}		
		
		
		
		
	}
}
