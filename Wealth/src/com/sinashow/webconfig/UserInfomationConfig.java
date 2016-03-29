package com.sinashow.webconfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.sinashow.webinterface.UserInfomationInterface;

public class UserInfomationConfig extends ElementAttribute implements UserInfomationInterface {

	private WebDriver driver;
	private By userID;
	private By nickName;
	private By loginName;
	private By sexMan;
	private By sexWoman;
	private By sexSecret;
	private By addressProvince;
	private By addressRegion;
	private By phoneNumber;
	private By QQ;
	private By email;
	private By saveButton;
	private By weixin;
	private By interest;
	
	public UserInfomationConfig(WebDriver driver){
		this.driver = driver;
	}
	
	
	@Override
	public WebElement getUserIdElement() {
		// TODO Auto-generated method stub
		return  getElement(userID);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.UserInfomationInterface#getNickNameElement()
	 */
	@Override
	public WebElement getNickNameElement() {
		// TODO Auto-generated method stub
		return  getElement(nickName);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.UserInfomationInterface#getLoginNameElement()
	 */
	@Override
	public WebElement getLoginNameElement() {
		// TODO Auto-generated method stub
		return  getElement(loginName);
	}

	@Override
	public WebElement getSex_ManElement() {
		// TODO Auto-generated method stub
		return  getElement(sexMan);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.UserInfomationInterface#getSex_WomanElement()
	 */
	@Override
	public WebElement getSex_WomanElement() {
		// TODO Auto-generated method stub
		return  getElement(sexWoman);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.UserInfomationInterface#getSex_SecretElement()
	 */
	@Override
	public WebElement getSex_SecretElement() {
		// TODO Auto-generated method stub
		return  getElement(sexSecret);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.UserInfomationInterface#getAddressProvinceElement()
	 */
	@Override
	public WebElement getAddressProvinceElement() {
		// TODO Auto-generated method stub
		return  getElement(addressProvince);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.UserInfomationInterface#getAddressRegionElement()
	 */
	@Override
	public WebElement getAddressRegionElement() {
		// TODO Auto-generated method stub
		return  getElement(addressRegion);
	}

	@Override
	public WebElement getPhoneNumberElement() {
		// TODO Auto-generated method stub
		return  getElement(phoneNumber);
	}

	@Override
	public WebElement getEmailElement() {
		// TODO Auto-generated method stub
		return  getElement(email);
	}

	@Override
	public WebElement getQQElement() {
		// TODO Auto-generated method stub
		return  getElement(QQ);
	}

	@Override
	public WebElement getWeiXinElement() {
		// TODO Auto-generated method stub
		return  getElement(weixin);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.UserInfomationInterface#getInterestElement()
	 */
	@Override
	public WebElement getInterestElement() {
		// TODO Auto-generated method stub
		return  getElement(interest);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.UserInfomationInterface#getMoney10Element()
	 */
	@Override
	public WebElement getMoney10Element() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.UserInfomationInterface#getMoney30Element()
	 */
	@Override
	public WebElement getMoney30Element() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.UserInfomationInterface#getMoney50Element()
	 */
	@Override
	public WebElement getMoney50Element() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.UserInfomationInterface#getMoney60Element()
	 */
	@Override
	public WebElement getMoney60Element() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.UserInfomationInterface#getSaveElement()
	 */
	@Override
	public WebElement getSaveElement() {
		// TODO Auto-generated method stub
		return  getElement(saveButton);
	}

	@Override
	public String getNickNameText() {
		// TODO Auto-generated method stub
		String s = getText(this.getNickNameElement());
		return s;
	}

	@Override
	public String getEmailText() {
		// TODO Auto-generated method stub
		String s = getText(this.getEmailElement());
		return s;
	}

	@Override
	public String getQQText() {
		// TODO Auto-generated method stub
		String s = getText(this.getQQElement());
		return s;
	}

	@Override
	public String getWeiXinText() {
		// TODO Auto-generated method stub
		String s = getText(this.getWeiXinElement());
		return s;
	}
	
	/**
	 * 获得投资兴趣下拉菜单当前选中的文字
	 * @return
	 */
	public String getInterestText(){
		String s = "";
		Select select = new Select(this.getInterestElement());
		s = select.getFirstSelectedOption().getText();
		return s;
	}
	
	/**
	 * 根据下拉菜单ID，获得投资兴趣显示的文字
	 * @param index 索引ID，从0开始
	 * @return
	 */
	public String getInterestText(int index){
		String s = "";
		Select select = new Select(this.getInterestElement());
		int max = select.getOptions().size();
		
		if(index<0) index = 0;
		if(index>max) index = max;
		
		select.selectByIndex(index);
		s = select.getFirstSelectedOption().getText();
		
		return s;
	}
	
	public String getAddressRegionText(){
		String s = "";
		s = this.getSelectText(this.getAddressRegionElement(), true, 0);
		return s;
	}
	
	public String getAddressRegionText(int index){
		String s = "";
		s = this.getSelectText(this.getAddressRegionElement(), false, index);
		return s;
	}
	
	/**
	 * 获得当前下拉菜单选中的文字
	 * @return
	 */
	public String getAddressProvinceText(){
		String s = "";
		s = this.getSelectText(this.getAddressProvinceElement(), true, 0);
		return s;
	}
	
	/**
	 * 获得下拉菜单指定ID的文字
	 * @param index 索引ID，从0开始
	 * @return
	 */
	public String getAddressProvinceText(int index){
		String s = "";
		s = this.getSelectText(this.getAddressProvinceElement(), false, index);
		return s;
	}
	
	
	private String getSelectText(WebElement e, boolean isFirst, int index){
		String s = "";
		Select select = new Select(e);
		if(isFirst){
			s = select.getFirstSelectedOption().getText();
		}else{
			int max = select.getOptions().size();
			
			if(index<0) index = 0;
			if(index>max) index = max;
			
			select.selectByIndex(index);
			s = select.getFirstSelectedOption().getText();
		}
		return s;
	}
	
	private WebElement getElement(By selector){
		if(isElementExsit(driver,selector)){
			return driver.findElement(selector);
		}else{
			throw new DriverException(selector);
		}
	}

}
