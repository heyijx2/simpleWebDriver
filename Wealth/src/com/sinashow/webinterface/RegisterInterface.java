package com.sinashow.webinterface;

import org.openqa.selenium.WebElement;


public interface RegisterInterface {
	/**
	 * ��ע�ᴰ��
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
	 * �˻�����
	 * @param pw
	 */
	public void inputPassword1(String pw);
	
	/**
	 * ȷ������
	 * @param pw
	 */
	public void inputPassword2(String pw);
	
	
	/**
	 * ��֤��
	 * @param code
	 */
	public void inputCheckCode(String code);
	
	
	/**
	 * ��ȡ��֤�밴ť
	 */
	public void clickCheckCodeButton();
	
	/**
	 * �û�Э��
	 */
	public void clickAgreementButton();
	
	/**
	 * ע��ȷ����ť
	 */
	public void clickRegisterButton();
	
}
