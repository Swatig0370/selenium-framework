package com.selenium.ylp.pom.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	protected WebDriver driver;
	private By contactUsLk = By.id("contact-link");
	private By singInLk = By.className("login");
	
	public HomePage(WebDriver driver){
		this.driver  = driver;
	}
	
				
		//Feature methods
		public String getPageTitle(){
			
			String title = driver.getTitle();
			return title;
		}
		
		public boolean verifyBasePageTitle(){
			String expectedPageTitle = "My Store";
			return getPageTitle().contains(expectedPageTitle);
		}
		
		
		//Navigation methods
		public ContactUsPage clickContactUsBtn(){
			
			System.out.println("Clicking on Contact us button");
			//driver.findElement(By.id("contact-link")).click();
			
			WebElement contactUsLink = driver.findElement(contactUsLk);
			System.out.println("Passed step");
			if(contactUsLink.isDisplayed()&& contactUsLink.isEnabled())
			contactUsLink.click();
			
			else 
			System.out.println("Element not found !!");
			
			return new ContactUsPage(driver);
		}
		
		public SignInPage clickSignInBtn(){
			
			System.out.println("Clicking on Signin button");
			WebElement singInLink = driver.findElement(singInLk);
			
			if(singInLink.isDisplayed()|| singInLink.isEnabled())
				singInLink.click();
			
			else 
			System.out.println("Element not found !!");
			return new SignInPage(driver);
		}
				
		
}
