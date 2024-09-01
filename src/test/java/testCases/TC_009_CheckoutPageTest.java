package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import testBase.BaseClass;

public class TC_009_CheckoutPageTest  extends BaseClass{
	@Test(priority=4,groups= {"Sanity","Master","E2E"})
	public void verifyCheckOutPage() 
	{
		logger.info("***CheckoutPage verify has started...");
		try 
		{
			CheckoutPage checkout=new CheckoutPage(driver);
			logger.info("***Fillout Billing Address has started...");
			checkout.setFirstName(name());
			checkout.setLastName(name());
			checkout.setCompanyName(name());
			checkout.setAddress1(Address1());
			checkout.setAddress2(Address2());
			checkout.setCity(city());
			checkout.setPostCode(postCode());
			checkout.selectCountry();
			checkout.selectState();
			checkout.setComment(comment());
			checkout.checkAgree();
			checkout.clickContinue();	
		} catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();
		}
		
		finally 
		{
			logger.info("***CheckoutPage verify has finished...");
		}		
	}
}
