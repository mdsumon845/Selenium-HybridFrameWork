package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC_007_ProductDetailsPageTest extends BaseClass {
	@Test(priority=1,groups={"Smoke","Master"})

	public void verifyProductDetailsPage() throws Exception 
	{
		logger.info("***Product Details page verify has started...");
		try 
		{
			//homePage
			HomePage hp=new HomePage(driver);
			hp.productSearch(p.getProperty("productSearch2"));
			//productPage
			ProductPage pp=new ProductPage(driver);	
			pp. productLinkClick() ;
			Thread.sleep(3000);
			logger.info("***verifying target Page...");
			ProductDetailsPage pdp=new ProductDetailsPage(driver);
			boolean targetPage=pdp.isProductCodeExists();
			Assert.assertTrue(targetPage);
		} catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();
		}

		finally 
		{
			logger.info("***Product Details page verify has finished...");
		}	
	}	



	@Test(priority=2,groups= {"Sanity","Master"})

	public void verifyReviewForm() 
	{
		logger.info("***Review form  test has started...");
		try 
		{
			//homePage
			HomePage hp=new HomePage(driver);
			hp.productSearch(p.getProperty("productSearch2"));
			//productPage
			ProductPage pp=new ProductPage(driver);	
			pp. productLinkClick() ;
			//product details page review form
			ProductDetailsPage pdp=new ProductDetailsPage(driver);
			pdp.setStarLabel();
			pdp.setName(fullName());
			pdp.setReview(review());
			pdp.clickReview();
			logger.info("***verifying expected Message...");
			boolean expectedMgs=pdp.getReviewConfirmationMgs();
			Assert.assertTrue(expectedMgs);
		} catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();
		}

		finally 
		{
			logger.info("***Review form  test has finished...");
		}	
	}	
}
