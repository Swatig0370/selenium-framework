package com.selenium.ylp.pom.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.ylp.pom.base.TestBaseSetup;
import com.selenium.ylp.pom.pageobject.HomePage;


/*
 * extend the TestBaseSetup here to use 
 * the elements and methods of this class 
 */

public class HomePageTest extends TestBaseSetup{
	
	private WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		driver = getDriver();
	}
	
	@Test
	public void verifyHomePage(){
		System.out.println("Home page test...");
		HomePage homepage = new HomePage(driver);
		Assert.assertTrue(homepage.verifyBasePageTitle(),"Home page title doesn't match");
	}
	
	
	
	
	}
