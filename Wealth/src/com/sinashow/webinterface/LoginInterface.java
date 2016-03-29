package com.sinashow.webinterface;

import org.openqa.selenium.WebElement;

public interface LoginInterface {
	
	/**
	 * �򿪵�¼ҳ��
	 */
	public void openLoginPage();
	
	public WebElement getLoginNameElement();
	
	public WebElement getPasswordElement();
	
	/**
	 * ��ס���뵥ѡ��ť
	 * @return
	 */
	public WebElement getRememberPwElement();
	
	/**
	 * ������������
	 * @return
	 */
	public WebElement getForgetPwElement();
	
	/**
	 * ��¼��ť
	 * @return
	 */
	public WebElement getLoginButtonElement();
	
	public String getLoginText();
	
	public String getPasswordText();
	
	public String getRememberPwState();
	
	public String getForgetPwLink();
}
