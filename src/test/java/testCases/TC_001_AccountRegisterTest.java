package testCases;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegisterTest  extends BaseClass{
	@Test(priority=1,groups= {"Regression","Master","E2E"})
	public void createAccount() 
	{
		logger.info("***TC_001_Account Registration has started...");
		try 
		{
			//home page
			HomePage home=new HomePage(driver);
			home.hoverMyAccount();
			home.clickRegister();
			//Registration page
			RegistrationPage register=new RegistrationPage(driver);
			register.SetFirstName(randomString().toLowerCase());
			register.SetlastName(randomString().toLowerCase());
			register.SetEmail(randomAlphaNumeric2()+"@gmail.com");
			register.SetTelephone(randomNumber());
			String password=randomAlphaNumeric();
			register.SetPassword(password);
			register.SetConfirmPassword(password);
			register.SetSubscribe();
			register.SetPrivacy();
			register.clickContinue();	
			logger.info("***Validating expected message ...");
			Assert.assertEquals(register.getConfirmationMessage(), "Your Account Has Been Created!");
			logger.info("***Validating expected message completed...");
		}
		catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();
		}
		finally 
		{
			logger.info("***Account Registration  has completed ...");
		}
	}
}
