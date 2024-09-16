package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_003_LoginTest extends BaseClass{
	@Test(priority=2,groups={"Sanity","Master"})
	public void verify_Login() 
	{
		logger.info("***TC_003_Login test has started...");
		try 
		{	//homepage
			HomePage hp=new HomePage(driver);
			hp.hoverMyAccount();
			hp.clickLogin();
			//loginPage
			LoginPage lp=new LoginPage(driver);
			lp.SetEmail(p.getProperty("email"));
			lp.SetPassword(p.getProperty("password"));
			lp.clickLoginBtn();
			//myAccountPage
			logger.info("***Validating expected page ...");
			MyAccountPage mypage=new MyAccountPage(driver);
			boolean targetPage=mypage.isMyAccountPageExists();
			Assert.assertTrue(targetPage);	
		}
		catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();
		}

		finally 
		{
			logger.info("***TC_003_Login test has finished...");
		}	
	}
}
