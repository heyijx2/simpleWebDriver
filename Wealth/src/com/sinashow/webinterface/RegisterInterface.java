package com.sinashow.webinterface;

import org.openqa.selenium.WebElement;


public interface RegisterInterface {
	/**
	 * 打开注册窗体
	 */
	public void openRegisterPage();
	
	public WebElement getPhoneNumberTextElement();
	
	public WebElement getUserNameTextElement();
	
	public WebElement getPassword1TextElement();
	
	public WebElement getPassword2TextElement();
	
	public WebElement getCheckCodeTextElement();
	
	public WebElement getCheckCodeButtonElement();
	
	public WebElement getAgreementButtonElement();
	
	public WebElement getRegisterButtonElement();
	
	public String getPhoneNumberText();
	
	public String getUserNameText();
	
	public String getPassword1Text();
	
	public String getPassword2Text();
	
	public String getCheckCodeText();
	
	
	public void inputPhoneNumber(String number);
	
	public void inputUsername(String username);
	
	/**
	 * 账户密码
	 * @param pw
	 */
	public void inputPassword1(String pw);
	
	/**
	 * 确认密码
	 * @param pw
	 */
	public void inputPassword2(String pw);
	
	
	/**
	 * 验证码
	 * @param code
	 */
	public void inputCheckCode(String code);
	
	
	/**
	 * 获取验证码按钮
	 */
	public void clickCheckCodeButton();
	
	/**
	 * 用户协议
	 */
	public void clickAgreementButton();
	
	/**
	 * 注册确定按钮
	 */
	public void clickRegisterButton();
	
}
