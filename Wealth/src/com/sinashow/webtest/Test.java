package com.sinashow.webtest;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import smile.heyi.excel.ReadExcel;
import smile.heyi.excel.UpdateExcel;

import com.sinashow.webconfig.TestConfig;

public class Test {
	private TestConfig testConfig;
	private UpdateExcel uexcel ;
	private ReadExcel rexcel;
	
	final private String excelPath = System.getProperty("user.dir")+"\\lib\\Test.xls";
	
	private String URL = "http://passport.cnblogs.com/register.aspx?ReturnUrl="
			+ "http://www.cnblogs.com/";
	private WebDriver driver;
	
	private WebElement email;
	private WebElement loginName ;
	private WebElement pw1 ;
	private WebElement pw2 ;
	private WebElement nickName ;
	
	public Test(){
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver1.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		
		testConfig = new TestConfig(driver);
		rexcel = new ReadExcel(excelPath);
		
		init();
	}
	
	public void init(){
		email = testConfig.getEmailElement();
		loginName = testConfig.getLoginName();
		pw1 = testConfig.getPassword1Element();
		pw2 = testConfig.getPassword2Element();
		nickName = testConfig.getNickNameElement();
		testEmail();
	}
	
	public void testEmail(){
		
		ArrayList<String> s = rexcel.getColumnToArrayList(5, 2, 5);
		ArrayList<String> r = new ArrayList<String>();
		for(int i=0;i<s.size();i++){
			email.sendKeys(s.get(i));
			loginName.click();
			String msg = testConfig.getEmailMessage();
			r.add(msg);
			email.clear();
		}
		driver.quit();
		
		uexcel = new UpdateExcel(excelPath);
		uexcel.updateColumn(7, 2, r);
	}
}
