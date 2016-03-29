package com.sinashow.webinterface;

import org.openqa.selenium.WebElement;

public interface LoginInterface {
	
	/**
	 * 打开登录页面
	 */
	public void openLoginPage();
	
	public WebElement getLoginNameElement();
	
	public WebElement getPasswordElement();
	
	/**
	 * 记住密码单选按钮
	 * @return
	 */
	public WebElement getRememberPwElement();
	
	/**
	 * 忘记密码连接
	 * @return
	 */
	public WebElement getForgetPwElement();
	
	/**
	 * 登录按钮
	 * @return
	 */
	public WebElement getLoginButtonElement();
	
	public String getLoginText();
	
	public String getPasswordText();
	
	public String getRememberPwState();
	
	public String getForgetPwLink();
}
