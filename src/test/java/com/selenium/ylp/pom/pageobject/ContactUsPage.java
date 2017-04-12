package com.selenium.ylp.pom.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

	protected WebDriver driver;
	
	private By subjectHeadingDrpDwn = By.id("id_contact");
	private By emailTb = By.id("email");
	private By orderIdTb = By.id("id_order");
	private By chooseFileTb= By.id("fileUpload");
	private By sendBtn= By.id("submitMessage");
	private By messageTb= By.id("message");
	private By successmsg = By.xpath("//*[@id=\"center_column\"]/p"); 
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//Feature methods
			public String getPageTitle(){
				
				String title = driver.getTitle();
				return title;
			}
			
			public boolean verifyBasePageTitle(){
				String expectedPageTitle = "Contact us - My Store";
				return getPageTitle().contains(expectedPageTitle);
			}
			
			public boolean verifySendMessage(){
				
				
				Select subDD = new Select(driver.findElement(subjectHeadingDrpDwn));
				subDD.selectByVisibleText("Customer service");
				
				enterEmailId("swati@gmail.com");
				orderId("12");
				chooseFile("F:\testingJava.txt");
				msgTextBox("Testing the contact Us page features");
				sendBtn();
												
				return getSuccessMsg().contains("successfully");
						
			}
			
			public void enterEmailId(String emailid){
				
				WebElement email = driver.findElement(emailTb);
				
				if (email.isDisplayed())
					email.sendKeys(emailid);
								
			}
			
			
			public void orderId(String orderId){
				
				WebElement order = driver.findElement(orderIdTb);
				
				if (order.isDisplayed())
					order.sendKeys(orderId);
								
			}
			
			
			public void chooseFile(String filePath){
				
				WebElement uploadFile = driver.findElement(chooseFileTb);
				
				if (uploadFile.isDisplayed())
					uploadFile.sendKeys(filePath);
				
											
			}
			
		
			public void msgTextBox(String message){
				
				WebElement msgtb = driver.findElement(messageTb);
				
				if (msgtb.isDisplayed())
					msgtb.sendKeys(message);
								
			}
			
			public void sendBtn(){
				
				WebElement sendbtn = driver.findElement(sendBtn);
				
				if (sendbtn.isDisplayed())
					sendbtn.click();
								
			}
			
			public String getSuccessMsg(){
				
				String strsuccmsg = null;
				
				WebElement succmsg = driver.findElement(successmsg);
				
				if (succmsg.isDisplayed() && succmsg.isEnabled())
					strsuccmsg = succmsg.getText();
				
				return strsuccmsg;
				
			}
	

}
