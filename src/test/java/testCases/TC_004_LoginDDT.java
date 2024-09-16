package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid-login success -system/test pass -logout
Data is valid- login failed- System/testFail

Data is invalid-login success- System/test fail- logout
data is invalid -login failed -System/test pass
*/

public class TC_004_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven") //getting data provider from different class
	public void verify_LoginDDT(String email,String pwd,String exp) throws Exception 
	{
		logger.info("***TC_004LoginDDT has started...");
		try 
		{
			//homePage
			HomePage hp=new HomePage(driver);
			hp.hoverMyAccount();
			hp.clickLogin();
			//loginPage
			LoginPage lp=new LoginPage(driver);
			lp.SetEmail(email);
			lp.SetPassword(pwd);
			lp.clickLoginBtn();
			//myAccountPage
			MyAccountPage mypage=new MyAccountPage(driver);
			boolean targetPage=mypage.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("Valid")) 
			{
				 if(targetPage==true) 
				 {
					 mypage.clickLogout();	
					 Assert.assertTrue(true);
				 }else 
				 {
					 Assert.assertTrue(false);
				 }
			}
			
			if(exp.equalsIgnoreCase("Invalid")) 
			{
				 if(targetPage==true) 
				 {
					 mypage.clickLogout();	 
					 Assert.assertTrue(false);	
				 }else 
				 {
					Assert.assertTrue(true); 
				 }
			}
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		
		finally 
		{
			logger.info("***TC_004LoginDDT has finished...");
		}
		Thread.sleep(3000);		
	}
}
