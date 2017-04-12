package com.selenium.ylp.pom.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.ylp.pom.base.TestBaseSetup;
import com.selenium.ylp.pom.pageobject.ContactUsPage;
import com.selenium.ylp.pom.pageobject.HomePage;

public class ContactUsPageTest extends TestBaseSetup {
	
	private WebDriver driver ;
	private HomePage homepage;
	private ContactUsPage contact;
	
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
		System.out.println("");
		
	}
	
	@BeforeTest
	public void OpenConatctUsPage(){
		
		homepage = new HomePage(driver);
		contact = homepage.clickContactUsBtn();
	}
	
	@Test(priority = 1)
	public void verifyContactUs(){
		
		
		System.out.println("Contact us page test...");
		Assert.assertTrue(contact.verifyBasePageTitle(),"Contact Us page title doesn't match");
		
	}
	
	@Test(priority = 2)
	public void verifyMessageSend(){
				
		Assert.assertTrue(contact.verifySendMessage(), "Error: Message was not submitted successfully!!");
	}
	
	
}
