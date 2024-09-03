package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_002_HomePageTest extends BaseClass {	
	@Test(priority=1,groups={"Sanity","Master"})
	public void logoDisplay() 
	{
		logger.info("***Logo display test has started...");
		try 
		{
			HomePage home=new HomePage(driver);
			boolean logo=home.logoPresence();
			Assert.assertTrue(logo);
			logger.info("test is passed");
		}catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();
		}
		finally 
		{
			logger.info("***Logo display test has finished...");
		}
	}

	@Test(priority=2,groups= {"Unit","Master"})

	public void verifySearchBarIsPresence() 
	{
		logger.info("***searchBar verify has started...");
		try 
		{
			//homepage
			HomePage hp=new HomePage(driver);
			logger.info("***Validating searchBar ...");
			boolean searchBar=hp.searchBarPresence();
			Assert.assertTrue(searchBar);	
		}catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();
		}
		finally 
		{
			logger.info("***searchBar verify has finished...");
		}	
	}


	@Test(priority=3,groups= {"Unit","Master"})
	public void verifySearchBarIsEnable() 
	{
		logger.info("***searchBarEnablity verify has started...");
		try 
		{
			//homepage
			HomePage hp=new HomePage(driver);
			logger.info("***Validating searchBarEnblity ...");
			boolean enable=hp.searchBarEnablity();
			Assert.assertTrue(enable);
		}catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();
		}

		finally 
		{
			logger.info("***searchBarEnablity verify has finished...");
		}	
	}


	@Test(priority=4,groups= {"Unit","Master"})

	public void verifyCategoryList() 
	{
		logger.info("*** Category list varify has started...");
		try 
		{
			HomePage hp=new HomePage(driver);
			int categoryList=hp.categoryList();
			logger.info("***Validating categoryList ...");
			Assert.assertEquals(categoryList, 9);
		}catch(Exception e) 
		{
			logger.error(("Test is failed")+e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail();
		}

		finally 
		{
			logger.info("***Category list varify has finished...");
		}
	}	
}
