package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	public static WebDriver driver;
	public  Logger logger;
	public Properties p;
 
	 @BeforeClass(groups= {"Sanity","Regression","Master","E2E"})
	 @Parameters({"os","browser"})
	 public void setup(String os,String br) throws Exception 
	 {
		 //loading properties file
		 FileReader file=new FileReader("./src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		 
		 logger=LogManager.getLogger(this.getClass());    //log4j
		 
		 //for remotely
		 if(p.getProperty("execution_env").equalsIgnoreCase("remote")) 
		 {
			DesiredCapabilities capabilities=new  DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) 
			{
				capabilities.setPlatform(Platform.WIN10);
			}else if(os.equalsIgnoreCase("mac")) 
			{
				capabilities.setPlatform(Platform.MAC);
			}else if(os.equalsIgnoreCase("linux")) 
			{
				capabilities.setPlatform(Platform.LINUX);	
			}
			else 
			{
				System.out.println("No matching os");
				return;
			}
			//browser
			switch(br.toLowerCase()) 
			{
				case "chrome":capabilities.setBrowserName("chrome");break;
				case "firefox":capabilities.setBrowserName("firefox");break;
				case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
				default:System.out.println("Invalid browser ");return;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);	
		 }
		 
		 //for local
		 if(p.getProperty("execution_env").equalsIgnoreCase("local")) 
		 {
			 switch(br.toLowerCase()) 
			 {
				 case "chrome":driver=new ChromeDriver();break;
				 case "edge":driver=new EdgeDriver();break;
				 case "firefox":driver=new FirefoxDriver();break;
				 default:System.out.println("Invalid browser name...");return;
			 } 		
		 }
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get(p.getProperty("appURL"));  //reading URL from properties file
		 driver.manage().window().maximize();	  
	 }
 
	 @AfterClass(groups= {"Sanity","Regression","Master"})
	 public void tearDown() 
	 {
		 driver.close();
	 }
	
	 //these user defined mehthods are created for generating random String,number,email,password
	 public String randomString() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(10);
		return generatedString ;	 
	 }
	 
	 public String randomNumber() 
	 {
		String generatedNumber= RandomStringUtils.randomNumeric(11);
		return generatedNumber ;	 
	 }
	 
	 public String randomAlphaNumeric() 
	 {
		 String str= RandomStringUtils.randomAlphabetic(5);
		String num= RandomStringUtils.randomNumeric(3);
		return (str+"@"+num); 
	 }
	 
	 public String randomAlphaNumeric2() 
	 {
		 String str= RandomStringUtils.randomAlphabetic(5);
		String num= RandomStringUtils.randomNumeric(3);
		return (str+num);	 
	 }
	 
	 public String Address1() 
	 {
		String str= RandomStringUtils.randomAlphabetic(15);
		String num1= RandomStringUtils.randomNumeric(1);
		String num2= RandomStringUtils.randomNumeric(2);
		return (str+num1+"-"+num2);		 
	 }
	 
	 public String Address2() 
	 {
		String str= RandomStringUtils.randomAlphabetic(15);
		String num1= RandomStringUtils.randomNumeric(1);
		String num2= RandomStringUtils.randomNumeric(3);
		return (str+num1+"-"+num2);		 
	 }
	 
	 public String city() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(15);
		return generatedString ;	 
	 }
	 
	 public String postCode() 
	 {
		String num1= RandomStringUtils.randomNumeric(3);
		String num2= RandomStringUtils.randomNumeric(4);
		return (num1+"-"+num2);		 
	 }
	 
	 public String name() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(15);
		return generatedString ;	 
	 }
	 
	 public String review() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(200);
		return generatedString ;	 
	 }
	 
	 public String comment() 
	 {
		String generatedString= RandomStringUtils.randomAlphabetic(200);
		return generatedString ;	 
	 }
	 
	 public String captureScreen(String tname) throws IOException 
	 {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());	
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);	
		return targetFilePath;
	}
}
