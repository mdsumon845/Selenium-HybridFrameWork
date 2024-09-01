package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//locators
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement mgsHeading;
	@FindBy(xpath="(//a[normalize-space()='Logout'])[2]") WebElement btnLogout;
	@FindBy(xpath="//a[normalize-space()='Edit Account']") WebElement btnEditAccount;
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTel;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") 
	WebElement confirmationMgs;
	@FindBy(xpath="//a[normalize-space()='Password']") WebElement passworBtndLink;
	@FindBy(xpath="//input[@id='input-password']") WebElement textPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement textConfirmPassword;
	@FindBy(xpath="//a[normalize-space()='Address Book']") WebElement linkAddressbook;
	@FindBy(xpath="//a[normalize-space()='New Address']") WebElement btnNewAddress;
	@FindBy(xpath="//input[@id='input-company']") WebElement textCompany;
	@FindBy(xpath="//input[@id='input-address-1']") WebElement textAddress1;
	@FindBy(xpath="//input[@id='input-address-2']") WebElement textAddress2;
	@FindBy(xpath="//input[@id='input-city']") WebElement textCity;
	@FindBy(xpath="//input[@id='input-postcode']") WebElement textPostCode;
	@FindBy(xpath="//select[@id='input-country']") WebElement selectCountry;
	@FindBy(xpath="//select[@id='input-zone']") WebElement selectState;
	@FindBy(xpath="//input[@value='1']") WebElement btnDefaultAddress;
	@FindBy(xpath="//a[normalize-space()='Newsletter']") WebElement subscriptionNewsletter;
	@FindBy(xpath="//label[@for='input-newsletter-yes']") WebElement btnSubscriptionYes;
	@FindBy(xpath="(//a[normalize-space()='Logout'])[2]") WebElement linkLogout;
	@FindBy(xpath="//h1[@class='page-title my-3']") WebElement logoutConfirmationMgs;
	@FindBy(xpath="//i[@class='fas fa-2x mb-1 fa-bullhorn']") WebElement linkAffiliateAccount;
	@FindBy(xpath="//input[@id='input-website']") WebElement txtWebsite;
	@FindBy(xpath="//input[@id='input-tax']") WebElement txtTaxId;
	@FindBy(xpath="//input[@value='bank']") WebElement radioBtnBankTransfer;
	@FindBy(xpath="//input[@id='input-bank-name']") WebElement txtBankName;
	@FindBy(xpath="//input[@id='input-bank-branch-number']") WebElement txtBranchNumber;
	@FindBy(xpath="//input[@id='input-bank-swift-code']") WebElement txtSwiftCode;
	@FindBy(xpath="//input[@id='input-bank-account-name']") WebElement txtAccountName;
	@FindBy(xpath="//input[@id='input-bank-account-number']") WebElement txtAccountNumber;
	@FindBy(xpath="//input[@name='agree']") WebElement checkboxAgreeLink;
	@FindBy(xpath="//a[normalize-space()='My Account']") WebElement linkMyAccount;

	//action method
	public boolean isMyAccountPageExists() 
	{
		try 
		{
			return (mgsHeading.isDisplayed());	
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public void editBtnClick() 
	{
		btnEditAccount.click();
	}

	public void setFirstName(String firstName) 
	{
		txtFirstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) 
	{
		txtLastName.sendKeys(lastName);
	}


	public void setEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}

	public void setTelePhoneNum(String Tel) 
	{
		txtTel.sendKeys(Tel);
	}

	public void clickContinueBtn() 
	{
		btnContinue.click();
	}

	public boolean getEditInfoConfirmationMessage() 
	{
		try 
		{
			return confirmationMgs.isDisplayed();			
		}catch(Exception e) 
		{
			return false;	
		}
	}


	public void clearFirstName() 
	{
		txtFirstName.clear();
	}

	public void clearLastName() 
	{
		txtLastName.clear();
	}

	public void clearEmail() 
	{
		txtEmail.clear();
	}

	public void clearTelNum() 
	{
		txtTel.clear();
	}

	public void clickPasswordLink()
	{
		passworBtndLink.click();
	}


	public void setPassword(String pwd) 
	{
		textPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) 
	{
		textConfirmPassword.sendKeys(pwd);
	}


	public boolean getPasswordConfirmationMessage() 
	{
		try 
		{
			return confirmationMgs.isDisplayed();			
		}catch(Exception e) 
		{
			return false;	
		}
	}

	public void clickAddressBookLink() 
	{
		linkAddressbook.click();
	}

	public void clickNewAddressBtn() 
	{
		btnNewAddress.click();
	}

	public void setCompanyName(String com) 
	{
		textCompany.sendKeys(com);
	}

	public void setAddress1(String add1) 
	{
		textAddress1.sendKeys(add1);
	}

	public void setAddress2(String add2) 
	{
		textAddress2.sendKeys(add2);
	}

	public void setCity(String city) 
	{
		textCity.sendKeys(city);
	}

	public void setPostCode(String postcode) 
	{
		textPostCode.sendKeys(postcode);
	}

	public void selectCountry() 
	{
		WebElement country=selectCountry;
		Select countrysSelect=new Select(country);
		countrysSelect.selectByVisibleText("United Arab Emirates"); //here use config properties
	}

	public void selectState() 
	{
		WebElement state=selectState;
		Select stateSelect=new Select(state);
		stateSelect.selectByVisibleText("Dubai");//here use config properties
	}

	public void clickDefaultAddress() 
	{
		btnDefaultAddress.click();
	}

	public void clickSubscriptionBtn() 
	{
		subscriptionNewsletter.click();
	}

	public void clickYesSubscritionBtn() 
	{
		btnSubscriptionYes.click();
	}

	public boolean getSubscriptionConfirmationMgs() 
	{
		try 
		{
			return confirmationMgs.isDisplayed();			
		}catch(Exception e) 
		{
			return false;	
		}
	}


	public void clickLogout()
	{
		btnLogout.click();	
	}

	public boolean getLogoutConfirmationMgs() 
	{
		try 
		{
			return logoutConfirmationMgs.isDisplayed();
		}catch(Exception e) 
		{
			return false;
		}
	}

	public void clickMyAccountLink() 
	{
		linkMyAccount.click();
	}
	
	public void clickAffiliateAccountLink() 
	{
		linkAffiliateAccount.click();
	}

	public void setWebSite(String web) 
	{
		txtWebsite.sendKeys(web);
	}

	public void setTaxID(String id) 
	{
		txtTaxId.sendKeys(id);
	}

	public void clickBankTransfer() 
	{
		radioBtnBankTransfer.click();
	}

	public void setBankName(String name) 
	{
		txtBankName.sendKeys(name);
	}

	public void setBranchNumber(String num) 
	{
		txtBranchNumber.sendKeys(num);
	}

	public void setSwiftCode(String code) 
	{
		txtSwiftCode.sendKeys(code);
	}

	public void setAccountName(String accountName) 
	{
		txtAccountName.sendKeys(accountName);
	}

	public void setAccountNumber(String accountNum) 
	{
		txtAccountNumber.sendKeys(accountNum);
	}

	public void setAgree() 
	{
		checkboxAgreeLink.click();
	}

	public boolean getAccountCreateConfirmationMessage() 
	{
		try 
		{
			return confirmationMgs.isDisplayed();
		}catch(Exception e) 
		{
			return false;
		}
	}
}
