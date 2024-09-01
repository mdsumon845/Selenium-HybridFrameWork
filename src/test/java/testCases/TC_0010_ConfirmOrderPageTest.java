package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ConfirmPage;
import testBase.BaseClass;

public class TC_0010_ConfirmOrderPageTest extends BaseClass{
	@Test(priority=5,groups= {"Sanity","Master","E2E"})
	public void verifyConfirmOrder() 
	{
		logger.info("***Order verify has started...");
		try 
		{
			//confirm page
			ConfirmPage confirm=new ConfirmPage(driver);
			confirm.clickConfirm();
			logger.info("***verifying expected message...");
			boolean expectedMgs=confirm.getOrderConfirmationMgs();
			Assert.assertTrue(expectedMgs);
		}catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();	
		}
		
		finally 
		{
			logger.info("***Order verify has finished...");
		}		
	}
}
