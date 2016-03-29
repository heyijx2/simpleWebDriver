package com.sinashow.webinterface;

import org.openqa.selenium.WebElement;

public interface TestInterface {
	public WebElement getEmailElement();
	
	public WebElement getLoginName();
	
	/**
	 * ��ȡ�ǳ�Ԫ��
	 * @return
	 */
	public WebElement getNickNameElement();
	
	public WebElement getPassword1Element();
	
	public WebElement getPassword2Element();
	
	/**
	 * Email��֤��ʾ
	 * @return
	 */
	public String getEmailMessage();
	
	/**
	 * �û�����֤��ʾ
	 * @return
	 */
	public String getLoginNameMessage();
	
	public String getNicNameMessage();
	
	public String getPassword1Message();
	
	public String getPassowrd2Message();
	
	
}
