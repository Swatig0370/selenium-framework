package com.selenium.ylp.pom.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	protected WebDriver driver;
	
	public HomePage(WebDriver driver) {
	
		// Create an object of pagefactory and assign the webdriver objcet. 
				PageFactory.initElements(driver, this);
	}
	
	//Create the list of web Elements on Home Page.
	
	//Home Page link in YourLogo image.
	@FindBy(id = "header_logo")
	private WebElement homePageLink;
		
	//Search Box
	@FindBy(id = "search_query_top")
	private WebElement searchBox;
		
	//Search Button
	@FindBy(name = "submit_search")
	private WebElement searchBtn;
	
	//Cart button
	@FindBy(linkText = "Cart")
	private WebElement cartBtn;
	
	//ContactUs link
	@FindBy(id = "contact-link")
	private WebElement contactUsLink;
		
	//Signin Link
	@FindBy(linkText = "Sign in")
	private WebElement singInLink;
		
	//NewsLetter mail id text box
	@FindBy(id = "newsletter-input")
	private WebElement newsLtrMailidTB;
	
	//NewsLetter mail id button
	@FindBy(name = "submitNewsletter")
	private WebElement newsLtrMailidBtn;
	
	//Women Tab
	@FindBy(linkText = "Women")
	private WebElement womenTab;
	
	//Dresses Tab
	@FindBy(linkText = "Dresses")
	private WebElement dressesTab;
	
	//T-Shirts Tab
	@FindBy(linkText = "T-shirts")
	private WebElement tShirtsTab;
	
	
		//Home Page link in YourLogo image.
		public void homepagelink()
		{
			homePageLink.click();
		}
		
		//Search Box
		public void searchtextbox(String text)
		{
			searchBox.sendKeys(text);
		}
		
		//Search Button
		public void searchbtn()
		{
			searchBtn.click();
		}
		
		//Cart button
		public void cartbtn()
		{
			cartBtn.click();
		}

		//ContactUs link
		public void contactuslnk()
		{
			contactUsLink.click();
		}
		
		//Signin Link
		public void signinlnk()
		{
			singInLink.click();
		}
		
		//NewsLetter mail id text box
		public void newsmailidtb(String text)
		{
			newsLtrMailidTB.sendKeys(text);
		}
		
		//NewsLetter mail id button
		public void newsmailbtn()
		{
			newsLtrMailidBtn.click();
		}
		
		//Women Tab
		public void womentab()
		{
			womenTab.click();
		}
		
		//Dresses Tab
		public void dressestab()
		{
			dressesTab.click();
		}
		
		//T-Shirts Tab
		public void tshirttab()
		{
			tShirtsTab.click();
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
			
			if(contactUsLink.isDisplayed()|| contactUsLink.isEnabled())
			contactUsLink.click();
			
			else 
			System.out.println("Element not found !!");
			return new ContactUsPage(driver);
		}
		
		public SignInPage clickSignInBtn(){
			System.out.println("Clicking on Signin button");
			
			if(singInLink.isDisplayed()|| singInLink.isEnabled())
				singInLink.click();
			
			else 
			System.out.println("Element not found !!");
			return new SignInPage(driver);
		}
				
		
}
