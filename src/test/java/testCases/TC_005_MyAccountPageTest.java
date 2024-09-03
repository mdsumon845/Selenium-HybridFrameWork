package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_005_MyAccountPageTest extends BaseClass{
	@Test(priority=1,groups= {"Smoke","Master"})
	public void editAccountInfo() 
	{
		logger.info("***EditAccountInfo test has started...");
		try 
		{
			//homePage
			HomePage hp=new HomePage(driver);
			hp.hoverMyAccount();
			//register
			hp.clickRegister();

			RegistrationPage register=new RegistrationPage(driver);
			logger.info("***fillout register form...");
			register.SetFirstName(randomString().toLowerCase());
			register.SetlastName(randomString().toLowerCase());
			register.SetEmail(email()+"@gmail.com");
			register.SetTelephone(tel());
			String password=pwd();
			register.SetPassword(password);
			register.SetConfirmPassword(password);
			register.selectSubscribe();
			register.selectPrivacy();
			register.clickContinue();	

			//myAccountPage
			MyAccountPage mypage=new MyAccountPage(driver);
			mypage.editBtnClick();
			mypage.clearFirstName();
			mypage.setFirstName(randomString());
			mypage.clearLastName();
			mypage.setLastName(randomString());
			mypage.clearEmail();
			mypage.setEmail(email()+"@gmail.com");
			mypage.clearTelNum();
			mypage.setTelePhoneNum(tel());
			mypage.clickContinueBtn();

			logger.info("***verifying expected message...");
			boolean targetPage=mypage.getEditInfoConfirmationMessage();
			Assert.assertTrue(targetPage);	
			mypage.clickLogout();
		}
		catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();	
		}

		finally 
		{
			logger.info("***EditAccountInfo test has finished...");
		}	
	}


	@Test(priority=2,groups= {"Sanity","Master"})

	public void changePassword() 
	{
		logger.info("***Change password test has started...");
		try 
		{
			//homePage
			HomePage hp=new HomePage(driver);
			hp.hoverMyAccount();
			//register
			hp.clickRegister();

			RegistrationPage register=new RegistrationPage(driver);
			logger.info("***fillout register form...");
			register.SetFirstName(randomString().toLowerCase());
			register.SetlastName(randomString().toLowerCase());
			register.SetEmail(email()+"@gmail.com");
			register.SetTelephone(tel());
			String password=pwd();
			register.SetPassword(password);
			register.SetConfirmPassword(password);
			register.selectSubscribe();
			register.selectPrivacy();
			register.clickContinue();	

			//myAccountPage
			MyAccountPage mypage=new MyAccountPage(driver);
			mypage.clickPasswordLink();
			String pass=pwd();
			mypage.setPassword(pass);
			mypage.setConfirmPassword(pass);
			mypage.clickContinueBtn();

			logger.info("***verifying confirmation message...");
			boolean confirmMgs=mypage.getPasswordConfirmationMessage();
			Assert.assertTrue(confirmMgs);	
			mypage.clickLogout();
		}
		catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();
		}

		finally 
		{
			logger.info("***Change Password test has finished...");
		}	
	}


	@Test(priority=3,groups= {"Sanity","Master"})
	public void setAddressBook() 
	{
		logger.info("***setAddress book test has started...");
		try 
		{
			//homePage
			HomePage hp=new HomePage(driver);
			hp.hoverMyAccount();
			//register
			hp.clickRegister();

			RegistrationPage register=new RegistrationPage(driver);
			logger.info("***fillout register form...");
			register.SetFirstName(randomString().toLowerCase());
			register.SetlastName(randomString().toLowerCase());
			register.SetEmail(email()+"@gmail.com");
			register.SetTelephone(tel());
			String password=pwd();
			register.SetPassword(password);
			register.SetConfirmPassword(password);
			register.selectSubscribe();
			register.selectPrivacy();
			register.clickContinue();	

			//myAccountPage
			MyAccountPage mypage=new MyAccountPage(driver);
			mypage.clickAddressBookLink();
			mypage.clickNewAddressBtn();
			mypage.setFirstName(randomString());
			mypage.setLastName(randomString());
			mypage.setCompanyName(randomString());
			mypage.setAddress1(Address1());
			mypage.setAddress2(Address2());
			mypage.setCity(randomString());
			mypage.setPostCode(postCode() );
			mypage.selectCountry();
			mypage.selectState();
			mypage.clickDefaultAddress();
			mypage.clickContinueBtn();

		} catch(Exception e) 
		{
			Assert.fail();
		}

		finally 
		{
			logger.info("***setAddress book test has finished...");	
		}
	}


	@Test(priority=4,groups= {"Sanity","Master"})
	public void verifySubscriptionInfo() 
	{
		logger.info("***verifySubscriptionInfo has started...");
		try {

			//homePage
			HomePage hp=new HomePage(driver);
			hp.hoverMyAccount();
			//register
			hp.clickRegister();

			RegistrationPage register=new RegistrationPage(driver);
			logger.info("***fillout register form...");
			register.SetFirstName(randomString().toLowerCase());
			register.SetlastName(randomString().toLowerCase());
			register.SetEmail(email()+"@gmail.com");
			register.SetTelephone(randomNumber());
			String password=pwd();
			register.SetPassword(password);
			register.SetConfirmPassword(password);
			register.selectSubscribe();
			register.selectPrivacy();
			register.clickContinue();	
			//myAccount page
			MyAccountPage mypage=new MyAccountPage(driver);
			mypage.clickSubscriptionBtn();
			mypage.clickYesSubscritionBtn();
			mypage.clickContinueBtn();
			logger.info("***Validating confirmation message ...");
			boolean confirmationMgs=mypage.getSubscriptionConfirmationMgs();
			Assert.assertTrue(confirmationMgs);
		}
		catch(Exception e) {
			Assert.fail();
		}

		finally 
		{
			logger.info("***verifySubscriptionInfo has finished...");
		}	
	}


	@Test(priority=5,groups= {"Sanity","Master"})

	public void verifyLogout() 
	{
		logger.info("***verifyLogout has started...");
		try {

			//homePage
			HomePage hp=new HomePage(driver);
			hp.hoverMyAccount();
			//register
			hp.clickRegister();

			RegistrationPage register=new RegistrationPage(driver);
			logger.info("***fillout register form...");
			register.SetFirstName(randomString().toLowerCase());
			register.SetlastName(randomString().toLowerCase());
			register.SetEmail(email()+"@gmail.com");
			register.SetTelephone(tel());
			String password=pwd();
			register.SetPassword(password);
			register.SetConfirmPassword(password);
			register.selectSubscribe();
			register.selectPrivacy();
			register.clickContinue();	
			//myAccount page
			MyAccountPage mypage=new MyAccountPage(driver);
			mypage.clickLogout();
			logger.info("***Validating confirmation message ...");
			boolean confirmationMgs=mypage.getLogoutConfirmationMgs();
			Assert.assertEquals(confirmationMgs, true);
		}
		catch(Exception e) {
			Assert.fail();
		}

		finally 
		{
			logger.info("***verifyLogout has finished...");
		}	
	}


	@Test(priority=6,groups= {"Sanity","Master"})
	public void createAffiliateAccount() throws Exception 
	{
		logger.info("***createAffiliateAccount test has started...");
		try 
		{
			//homePage
			HomePage hp=new HomePage(driver);
			hp.hoverMyAccount();
			//register
			hp.clickRegister();

			RegistrationPage register=new RegistrationPage(driver);
			logger.info("***fillout register form...");
			register.SetFirstName(randomString().toLowerCase());
			register.SetlastName(randomString().toLowerCase());
			register.SetEmail(email()+"@gmail.com");
			register.SetTelephone(tel());
			String password=pwd();
			register.SetPassword(password);
			register.SetConfirmPassword(password);
			register.selectSubscribe();
			register.selectPrivacy();
			register.clickContinue();	
			//myAccount page
			MyAccountPage mypage=new MyAccountPage(driver);
			mypage.clickMyAccountLink();
			mypage.clickAffiliateAccountLink();
			mypage.setCompanyName(randomString());
			mypage.setWebSite(randomString());
			mypage.setTaxID(randomNumber());
			mypage.clickBankTransfer();
			mypage.setBankName(randomString());
			mypage.setBranchNumber(randomNumber());
			mypage.setSwiftCode(randomNumber());
			mypage.setAccountName(randomString());
			mypage.setAccountNumber(randomNumber());
			mypage.setAgree();
			mypage.clickContinueBtn();
			logger.info("***Validating confirmation message ...");
			boolean confirmationMgs=mypage.getAccountCreateConfirmationMessage();
			Assert.assertTrue(confirmationMgs);	
		} catch(Exception e) 
		{
			Assert.fail();
		}

		finally 
		{
			logger.info("***createAffiliateAccount test has finished...");	
		}	
	}
}
