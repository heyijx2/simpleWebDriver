package com.sinashow.webconfig;

import java.util.HashMap;
import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sinashow.webinterface.RegisterInterface;

public class RegisterPageConfig extends ElementAttribute implements RegisterInterface{
	private WebDriver driver;
	private By phoneNumber = By.id("phoneNum");
	private By username = By.id("userName");
	private By pw1 = By.id("password");
	private By pw2 = By.id("passwordAgain");
	private By checkCodetext = By.id("checkCode");
	private By checkCodeButton = By.id("checkCodeBtn");
	private By agreementButton = By.id("agree");
	private By registerButton = By.id("registerBtn");
	private By registrResult;
	
	private String phoneNumberMessage = "//*[@id=\"registerDialog\"]/div[2]/div/table/tbody/tr[1]/td[3]";
	private String usernameMessage = "//*[@id=\"registerDialog\"]/div[2]/div/table/tbody/tr[2]/td[3]";
	private String pw1Message = "//*[@id=\"registerDialog\"]/div[2]/div/table/tbody/tr[3]/td[3]";
	private String pw2Message = "//*[@id=\"registerDialog\"]/div[2]/div/table/tbody/tr[4]/td[3]";
	
	
	public HashMap<WebElement, String> mapElementMessage ;
	
	public RegisterPageConfig(WebDriver driver){
		this.driver = driver;
		mapElementMessage = new HashMap<WebElement, String>();
		openRegisterPage();
		
		mapElementMessage.put(this.getPhoneNumberTextElement(), phoneNumberMessage);
		mapElementMessage.put(this.getUserNameTextElement(), usernameMessage);
		mapElementMessage.put(this.getPassword1TextElement(), pw1Message);
		mapElementMessage.put(this.getPassword2TextElement(), pw2Message);

	}

	@Override
	public void openRegisterPage() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div[1]/a[2]")).click();
	}
	
	public String getRegisterResult(By Selector){
		return driver.findElement(Selector).getText();
	}

	@Override
	public void inputPhoneNumber(String number) {
		// TODO Auto-generated method stub
		this.getPhoneNumberTextElement().sendKeys(number);
	}

	@Override
	public void inputUsername(String username) {
		// TODO Auto-generated method stub
		this.getUserNameTextElement().sendKeys(username);
	}

	@Override
	public void inputPassword1(String pw) {
		// TODO Auto-generated method stub
		this.getPassword1TextElement().sendKeys(pw);
	}

	@Override
	public void inputPassword2(String pw) {
		// TODO Auto-generated method stub
		this.getPassword2TextElement().sendKeys(pw);
	}

	@Override
	public void inputCheckCode(String code) {
		// TODO Auto-generated method stub
		this.getCheckCodeTextElement().sendKeys(code);
	}

	@Override
	public void clickCheckCodeButton() {
		// TODO Auto-generated method stub
		this.getCheckCodeButtonElement().click();
	}

	@Override
	public void clickAgreementButton() {
		// TODO Auto-generated method stub
		this.getAgreementButtonElement().click();
	}

	@Override
	public void clickRegisterButton() {
		// TODO Auto-generated method stub
		this.getRegisterButtonElement().click();
	}

	@Override
	public WebElement getPhoneNumberTextElement() {
		// TODO Auto-generated method stub
		return getElement(phoneNumber);
	}

	@Override
	public WebElement getUserNameTextElement() {
		// TODO Auto-generated method stub
		return getElement(username);
	}

	@Override
	public WebElement getPassword1TextElement() {
		// TODO Auto-generated method stub
		return getElement(pw1);
	}

	@Override
	public WebElement getPassword2TextElement() {
		// TODO Auto-generated method stub
		return getElement(pw2);
	}

	@Override
	public WebElement getCheckCodeTextElement() {
		// TODO Auto-generated method stub
		return getElement(checkCodetext);
	}

	@Override
	public WebElement getCheckCodeButtonElement() {
		// TODO Auto-generated method stub
		return getElement(this.checkCodeButton);
	}

	@Override
	public WebElement getAgreementButtonElement() {
		// TODO Auto-generated method stub
		return getElement(this.agreementButton);
	}

	@Override
	public WebElement getRegisterButtonElement() {
		// TODO Auto-generated method stub
		return getElement(registerButton);
	}

	@Override
	public String getPhoneNumberText() {
		// TODO Auto-generated method stub
		return this.getPhoneNumberTextElement().getText();
	}

	@Override
	public String getUserNameText() {
		// TODO Auto-generated method stub
		return this.getUserNameTextElement().getAttribute("value");
	}

	@Override
	public String getPassword1Text() {
		// TODO Auto-generated method stub
		return this.getPassword1TextElement().getAttribute("value");
	}

	@Override
	public String getPassword2Text() {
		// TODO Auto-generated method stub
		return this.getPassword2TextElement().getText();
	}

	@Override
	public String getCheckCodeText() {
		// TODO Auto-generated method stub
		return this.getCheckCodeTextElement().getAttribute("value");
	}
	
	/**
	 * 获得手机号码验证提示
	 * @return
	 */
	public String getPhoneNumberMessage(){
		String s = driver.findElement(
				By.xpath("//*[@id=\"registerDialog\"]/div[2]/div/table/tbody/tr[1]/td[3]")
				).getText();
		return s;
	}
	
	/**
	 * 活动用户名验证提示
	 * @return
	 */
	public String getUserNameMessage(){
		String xpath = "//*[@id=\"registerDialog\"]/div[2]/div/table/tbody/tr[2]/td[3]/span";
		String s = getMessage(xpath);
		return s;
	}
	
	/**
	 * 获得密码验证提示
	 * @return
	 */
	public String getPw1Message(){
		String x = "//*[@id=\"registerDialog\"]/div[2]/div/table/tbody/tr[3]/td[3]/span";
		return getMessage(x);
	}
	
	/**
	 * 获得确认密码的验证提示
	 * @return
	 */
	public String getPw2Message(){
		String x = "//*[@id=\"registerDialog\"]/div[2]/div/table/tbody/tr[4]/td[3]/span";
		return getMessage(x);
	}
	
	/**
	 * 获得网站协议的连接地址
	 * @return
	 */
	public String getAgreementLink(){
		String x = "//*[@id=\"registerDialog\"]/div[2]/div/table/tbody/tr[6]/td[2]/a";
		String s = getElement(By.xpath(x)).getAttribute("href");
		return s;
	}
	
	public String getMessage(String xpath){
		String s = getElement(By.xpath(xpath)).getText();
		return s;
	}
	
	public String getMessage(By xpath){
		String s = getElement(By.xpath("//*[@id=\"registerDialog\"]/div[2]/div/table/tbody/tr[1]/td[3]")).getText();
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
