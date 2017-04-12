package com.selenium.ylp.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseSetup {

	
	private WebDriver driver;
	static String driverPath = "F:\\MVCSpring\\YLPPOMFW\\src\\test\\resources\\browser\\";
	
	//Method to get the WebDriver object.
	public WebDriver getDriver(){
		
		return driver;
	}
	
	private void setDriver(String browserType, String appURL){
		
		if(browserType.equalsIgnoreCase("CH"))
			driver = initChromeDriver(appURL);
		
		else if (browserType.equalsIgnoreCase("FF"))
			driver = initFirefoxDriver(appURL);
		
		else if (browserType.equalsIgnoreCase("IE"))
			driver = initIEDriver(appURL);
		
		else{ 
			System.out.println("Browser : "+ browserType + "is invaild, launching the Chrome browser as default..");
			driver = initChromeDriver(appURL);
		}
		
	}	
		private static WebDriver initChromeDriver(String appURL){
			
			System.out.println("Launching google chrome with new profile..");
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(appURL);
			return driver;
		}
		private WebDriver initIEDriver(String appURL) {
			
			System.out.println("Launching Internet Explorer with new profile..");
			System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.navigate().to(appURL);
			return driver;
		}

		private WebDriver initFirefoxDriver(String appURL) {
			
			System.out.println("Launching Firefox with new profile..");
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			WebDriver driver = new FirefoxDriver(cap);
			driver.manage().window().maximize();
			driver.navigate().to(appURL);
			return driver;
		}
	
		@Parameters({"browserType", "appURL"})
		@BeforeClass
		public void initializeTestBaseSetup(String browserType, String appURL){
			
			setDriver(browserType,appURL);
					
		}
		
		
		@AfterClass
		public void tearDown(){
			driver.quit();
		}

}
