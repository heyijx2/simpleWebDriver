package com.sinashow.webconfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sinashow.webinterface.TestInterface;

public class TestConfig implements TestInterface {
	private By email = By.id("ctl00_holderLeft_txt_email");
	private By loginName = By.id("ctl00_holderLeft_txt_userName");
	private By pw1 = By.id("ctl00_holderLeft_txt_pwd");
	private By pw2 = By.id("ctl00_holderLeft_txt_confirm_pwd");
	private By nickName = By.id("ctl00_holderLeft_txt_display_name");
	
	private WebDriver driver;
	
	public TestConfig(WebDriver driver){
		this.driver = driver;
	}
	
	@Override
	public WebElement getEmailElement() {
		// TODO Auto-generated method stub
		return driver.findElement(email);
	}

	@Override
	public WebElement getLoginName() {
		// TODO Auto-generated method stub
		return driver.findElement(loginName);
	}

	@Override
	public WebElement getNickNameElement() {
		// TODO Auto-generated method stub
		return driver.findElement(nickName);
	}

	@Override
	public WebElement getPassword1Element() {
		// TODO Auto-generated method stub
		return driver.findElement(pw1);
	}

	@Override
	public WebElement getPassword2Element() {
		// TODO Auto-generated method stub
		return driver.findElement(pw2);
	}

	@Override
	public String getEmailMessage() {
		// TODO Auto-generated method stub
		String s = driver.findElement(By.id("tip_email")).getText();
		
		return s;
	}

	@Override
	public String getLoginNameMessage() {
		// TODO Auto-generated method stub
		String s = driver.findElement(By.id("tip_userName")).getText();
		return s;
	}

	@Override
	public String getNicNameMessage() {
		// TODO Auto-generated method stub
		String s = driver.findElement(By.id("tip_display_name")).getText();
		return s;
	}

	@Override
	public String getPassword1Message() {
		// TODO Auto-generated method stub
		String s = driver.findElement(By.id("tip_pwd")).getText();
		return s;
	}

	@Override
	public String getPassowrd2Message() {
		// TODO Auto-generated method stub
		String s = driver.findElement(By.id("tip_confirm_pwd")).getText();
		return s;
	}

}
