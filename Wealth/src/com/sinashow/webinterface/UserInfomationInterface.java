package com.sinashow.webinterface;

import org.openqa.selenium.WebElement;

public interface UserInfomationInterface {
	public WebElement getUserIdElement();
	
	/**
	 * �û��ǳ�
	 * @return
	 */
	public WebElement getNickNameElement();
	
	/**
	 * �û���
	 * @return
	 */
	public WebElement getLoginNameElement();
	

	/**
	 * ��ѡ��ť���Ա���
	 * @return
	 */
	public WebElement getSex_ManElement();
	
	/**
	 * ��ѡ�У��Ա�Ů
	 * @return
	 */
	public WebElement getSex_WomanElement();
	
	/**
	 * ��ѡ�У��Ա���
	 * @return
	 */
	public WebElement getSex_SecretElement();
	
	/**
	 * �����˵������ڵ� ʡ
	 * @return
	 */
	public WebElement getAddressProvinceElement();
	
	/**
	 * �����˵������ڵ� ��
	 * @return
	 */
	public WebElement getAddressRegionElement();
	
	public WebElement getPhoneNumberElement();
	
	public WebElement getEmailElement();
	
	public WebElement getQQElement();
	
	public WebElement getWeiXinElement();
	
	/**
	 * �����˵���Ͷ����Ȥ
	 * @return
	 */
	public WebElement getInterestElement();
	
	/**
	 * ��ѡ��ť����ɢ�ʽ�0-10��
	 * @return
	 */
	public WebElement getMoney10Element();
	
	/**
	 * ��ѡ��ť����ɢ�ʽ�11-30��
	 * @return
	 */
	public WebElement getMoney30Element();
	
	/**
	 * ��ѡ��ť����ɢ�ʽ�30-50��
	 * @return
	 */
	public WebElement getMoney50Element();
	
	/**
	 * ��ѡ��ť����ɢ�ʽ� 50������
	 * @return
	 */
	public WebElement getMoney60Element();
	
	/**
	 * ���水ť
	 * @return
	 */
	public WebElement getSaveElement();
	
	public String getNickNameText();
	
	public String getEmailText();
	
	public String getQQText();
	
	public String getWeiXinText();
	
	
	
	
}
