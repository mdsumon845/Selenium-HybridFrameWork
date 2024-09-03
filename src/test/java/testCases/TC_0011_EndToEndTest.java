package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.OrderConfirmPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_0011_EndToEndTest  extends BaseClass {
	@Test(groups="E2E")
	
	public void EndToEndTest() throws Exception 
	{
		SoftAssert myassert=new SoftAssert();
		logger.info("Account Registration has started");
		HomePage hp=new HomePage(driver);
		hp.hoverMyAccount();
		hp.clickRegister();
		RegistrationPage regpage=new RegistrationPage(driver);
		regpage.SetFirstName(firstname().toUpperCase());
		regpage.SetlastName(lastName().toLowerCase());
		String email=email();
		regpage.SetEmail(email+"@gmail.com");
		regpage.SetTelephone(tel());
		String pass=pwd();
		regpage.SetPassword(pass);
		regpage.SetConfirmPassword(pass);
		regpage.selectSubscribe();
		regpage.selectPrivacy();
		regpage.clickContinue();
		logger.info("***Validating Account registration confirmation Mgs...");
		String expectedMgs=regpage.getConfirmationMessage();
		myassert.assertEquals(expectedMgs, "Your Account Has Been Created!");
		logger.info("***Clickcontinue btn from dashboard...");
		MyAccountPage mc=new MyAccountPage(driver);
		mc.ClickContinueAfterRegister();
		Thread.sleep(3000);
		
		logger.info("***searchProduct and add to cart...");
		hp.productSearch(p.getProperty("productSearch3"));
		CartPage cartpage=new CartPage(driver);
		cartpage.addProductToCart();
		boolean targetPage=cartpage.getCartPage();   //validation change into price
		myassert.assertEquals(targetPage, true);
		logger.info("***Navigate to the checkout page...");
		cartpage.clickCheckout();
		
		logger.info("***Fillup Billing AddressForm in the checkout page...");
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		Thread.sleep(3000);
		checkoutPage.setFirstName(firstname());
		checkoutPage.setLastName(lastName());
		checkoutPage.setCompanyName(CompanyName());
		checkoutPage.setAddress1(Address1());
		checkoutPage.setAddress2(Address2());
		checkoutPage.setCity(city());
		checkoutPage.setPostCode(postCode());
		checkoutPage.selectCountry();
		checkoutPage.selectState();
		checkoutPage.setComment(comment());
		checkoutPage.selectTermsAndConditions();
		checkoutPage.clickContinue();
		logger.info("***Validating expected text in the Order Confirm Page...");
		OrderConfirmPage confirm=new OrderConfirmPage(driver);
		boolean expectedPage=confirm.getTargetPage();
		myassert.assertTrue(expectedPage);
		logger.info("***Click confirm Order Button...");
		confirm.clickConfirmBtn();
		logger.info("***Validating expected Mgs After Order Confirmation...");
		boolean confirmMgs=confirm.getOrderConfirmationMgs();
		myassert.assertTrue(confirmMgs);
		
		myassert.assertAll();		
	}
}

