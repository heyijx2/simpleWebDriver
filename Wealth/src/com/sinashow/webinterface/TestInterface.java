package com.sinashow.webinterface;

import org.openqa.selenium.WebElement;

public interface TestInterface {
	public WebElement getEmailElement();
	
	public WebElement getLoginName();
	
	/**
	 * 获取昵称元素
	 * @return
	 */
	public WebElement getNickNameElement();
	
	public WebElement getPassword1Element();
	
	public WebElement getPassword2Element();
	
	/**
	 * Email验证提示
	 * @return
	 */
	public String getEmailMessage();
	
	/**
	 * 用户名验证提示
	 * @return
	 */
	public String getLoginNameMessage();
	
	public String getNicNameMessage();
	
	public String getPassword1Message();
	
	public String getPassowrd2Message();
	
	
}
