package com.sinashow.webinterface;

import org.openqa.selenium.WebElement;

public interface UserInfomationInterface {
	public WebElement getUserIdElement();
	
	/**
	 * 用户昵称
	 * @return
	 */
	public WebElement getNickNameElement();
	
	/**
	 * 用户名
	 * @return
	 */
	public WebElement getLoginNameElement();
	

	/**
	 * 单选按钮，性别男
	 * @return
	 */
	public WebElement getSex_ManElement();
	
	/**
	 * 单选男，性别女
	 * @return
	 */
	public WebElement getSex_WomanElement();
	
	/**
	 * 单选男，性别保密
	 * @return
	 */
	public WebElement getSex_SecretElement();
	
	/**
	 * 下拉菜单，所在地 省
	 * @return
	 */
	public WebElement getAddressProvinceElement();
	
	/**
	 * 下拉菜单，所在地 区
	 * @return
	 */
	public WebElement getAddressRegionElement();
	
	public WebElement getPhoneNumberElement();
	
	public WebElement getEmailElement();
	
	public WebElement getQQElement();
	
	public WebElement getWeiXinElement();
	
	/**
	 * 下拉菜单，投资兴趣
	 * @return
	 */
	public WebElement getInterestElement();
	
	/**
	 * 单选按钮，闲散资金0-10万
	 * @return
	 */
	public WebElement getMoney10Element();
	
	/**
	 * 单选按钮，闲散资金11-30万
	 * @return
	 */
	public WebElement getMoney30Element();
	
	/**
	 * 单选按钮，闲散资金30-50万
	 * @return
	 */
	public WebElement getMoney50Element();
	
	/**
	 * 单选按钮，闲散资金 50万以上
	 * @return
	 */
	public WebElement getMoney60Element();
	
	/**
	 * 保存按钮
	 * @return
	 */
	public WebElement getSaveElement();
	
	public String getNickNameText();
	
	public String getEmailText();
	
	public String getQQText();
	
	public String getWeiXinText();
	
	
	
	
}
