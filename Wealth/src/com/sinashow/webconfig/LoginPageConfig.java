package com.sinashow.webconfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sinashow.webinterface.LoginInterface;

public class LoginPageConfig extends ElementAttribute implements LoginInterface {
	private WebDriver driver ;
	private By loginName;
	private By password;
	private By rememberpw;
	private By forgetpw;
	private By loginButton;

	public LoginPageConfig(WebDriver driver){
		this.driver = driver;
	}
	
	
	@Override
	public void openLoginPage() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.LoginInterface#getLoginNameElement()
	 */
	@Override
	public WebElement getLoginNameElement() {
		// TODO Auto-generated method stub
		return getElement(loginName);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.LoginInterface#getPasswordElement()
	 */
	@Override
	public WebElement getPasswordElement() {
		// TODO Auto-generated method stub
		return  getElement(password);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.LoginInterface#getRememberPwElement()
	 */
	@Override
	public WebElement getRememberPwElement() {
		// TODO Auto-generated method stub
		return getElement(rememberpw);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.LoginInterface#getForgetPwElement()
	 */
	@Override
	public WebElement getForgetPwElement() {
		// TODO Auto-generated method stub
		return getElement(forgetpw);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.LoginInterface#getLoginButtonElement()
	 */
	@Override
	public WebElement getLoginButtonElement() {
		// TODO Auto-generated method stub
		return getElement(loginButton);
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.LoginInterface#getLoginText()
	 */
	@Override
	public String getLoginText() {
		// TODO Auto-generated method stub
		return this.getLoginNameElement().getAttribute("value");
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.LoginInterface#getPasswordText()
	 */
	@Override
	public String getPasswordText() {
		// TODO Auto-generated method stub
		return this.getPasswordElement().getAttribute("value");
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.LoginInterface#getRememberPwState()
	 */
	@Override
	public String getRememberPwState() {
		// TODO Auto-generated method stub
		boolean flag = this.getRememberPwElement().isSelected();
		String s = null;
		if(flag){
			s = "被选中";
		}else{
			s = "未选中";
		}
		return s;
	}

	/* (non-Javadoc)
	 * @see com.sinashow.webinterface.LoginInterface#getForgetPwLink()
	 */
	@Override
	public String getForgetPwLink() {
		// TODO Auto-generated method stub
		return this.getLinkUrl(this.getForgetPwElement());
	}
	
	private WebElement getElement(By selector){
		if(isElementExsit(driver,selector)){
			return driver.findElement(selector);
		}else{
			throw new DriverException(selector);
		}
	}

}
