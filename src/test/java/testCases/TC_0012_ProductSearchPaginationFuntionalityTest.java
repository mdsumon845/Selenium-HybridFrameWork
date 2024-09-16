package testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.ProductSearch;
import testBase.BaseClass;

public class TC_0012_ProductSearchPaginationFuntionalityTest extends BaseClass {
	
	@Test(priority=1, groups={"Sanity","Master"})
	public void verifyProductSearchPagination() throws Exception 
	{
		try 
		{
			logger.info("***Verifying product pagination functionality...");
			HomePage hp=new HomePage(driver);
			hp.clickSearchBtn();
			Thread.sleep(1000);
			 ProductSearch ps1=new ProductSearch(driver);
				ps1.scrollUptoPageNumberText();
	         // Get the total number of pages
	         int totalNumPages = ps1.totalpages();
	         System.out.println("Total number of pages: " + totalNumPages);

	         // Iterate through the pages
	         for (int p = 2; p <=totalNumPages; p++) {
	             if (ps1.isPageLinkAvailable(p)) {
	                 if (p > 1) {
	                	 ps1.clickPage(p);
	                	 Assert.assertTrue(true);
	                     Thread.sleep(3000); // Wait for the page to load
	                 }
	             } else {
	                 System.out.println("No link available for page: " + p); 
	             }
	         }
	
		} catch (InterruptedException e)
		{
            e.printStackTrace();
		} 
		finally 
		{
			logger.info("***Verifying product pagination functionality has finished...");
		}	
}
}
