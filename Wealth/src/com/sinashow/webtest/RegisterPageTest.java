package com.sinashow.webtest;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import smile.heyi.excel.ReadExcel;
import smile.heyi.excel.UpdateExcel;

import com.sinashow.webconfig.ElementAttribute;
import com.sinashow.webconfig.RegisterPageConfig;

public class RegisterPageTest extends ElementAttribute{
	private WebDriver driver;
	final private String url = "http://www.1318.com/";
	final private String casePath = System.getProperty("user.dir")+"\\CASE\\自动化CASE模板.xls";
	
	private RegisterPageConfig regist;
	private ReadExcel rexcel ;
	private UpdateExcel uexcel ;
	
	public RegisterPageTest(){
		
		init();//初始化
//		this.testPhoneNumber();
//		this.testUserName();
//		this.testPw1();
//		this.testPw2();
		driver.quit();
		driver = null;
	}
	
	
	private void init(){
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver1.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
//		regist = new RegisterPageConfig(driver);//实现注册页面配置类
		
		rexcel = new ReadExcel();
		rexcel.setPath(casePath,2);
		ArrayList<String>[] list = rexcel.getZoneToArrayList(4,6,172,173);
		int row = 172;
		for(ArrayList<String> l : list){
			
			String s = this.runningExcelScripte(driver,casePath,l);
			System.out.println(s);
			uexcel = new UpdateExcel(casePath,2);
			uexcel.updateCell(8, row, s);
			row++;
		}
	}
	
	

	/**
	 * 测试手机号码的方法
	 */
	private void testPhoneNumber(){
		ArrayList<String> testNumber = rexcel.getColumnToArrayList(6, 30, 51);
		uexcel = new UpdateExcel(casePath);
		ArrayList<String> reuslt = new ArrayList<String>();
		for(int i=0;i<testNumber.size();i=i+2){
			String s = getPhoneNumberMessage(testNumber.get(i));
			reuslt.add("提示："+s);
			reuslt.add("页面没有任何反应");
		}
		
		uexcel.updateColumn(8, 30, reuslt);
	}
	private String getPhoneNumberMessage(String input){
		return this.getMessage(regist.getPhoneNumberTextElement(), input);
	}

	
	/**
	 * 测试用户名的方法
	 */
	private void testUserName(){
		ArrayList<String> testNumber = rexcel.getColumnToArrayList(6, 52, 71);
		uexcel = new UpdateExcel(casePath);
		ArrayList<String> reuslt = new ArrayList<String>();
		for(int i=0;i<testNumber.size();i=i+2){
			String s = getUserNameMessage(testNumber.get(i));
			reuslt.add("提示："+s);
			reuslt.add("页面没有任何反应");
		}
		
		uexcel.updateColumn(8, 52, reuslt);
	}
	private String getUserNameMessage(String input){
		return this.getMessage(regist.getUserNameTextElement(), input);
	}
	
	/**
	 * 测试密码框的方法
	 */
	private void testPw1(){
		ArrayList<String> testNumber = rexcel.getColumnToArrayList(6, 72, 83);
		uexcel = new UpdateExcel(casePath);
		ArrayList<String> reuslt = new ArrayList<String>();
		for(int i=0;i<testNumber.size();i=i+2){
			String s = getPw1Message(testNumber.get(i));
			reuslt.add("提示："+s);
			reuslt.add("页面没有任何反应");
		}
		
		uexcel.updateColumn(8, 72, reuslt);
	}
	private String getPw1Message(String input){
		return this.getMessage(regist.getPassword1TextElement(), input);
	}
	
	/**
	 * 测试确定密码的方法
	 */
	private void testPw2(){
		regist.inputPassword1("12345623");
		String s1 = getPw2Message("12345623");
		String s2 = getPw2Message("123456231");
		
		uexcel = new UpdateExcel(casePath);
		uexcel.updateCell(8, 84, s1);
		uexcel.updateCell(8, 85, "页面没有反应");
		uexcel.updateCell(8, 86, s2);
		uexcel.updateCell(8, 87, "页面没有反应");
		
	}
	private String getPw2Message(String input){
		return this.getMessage(regist.getPassword2TextElement(), input);
	}
	
	public void userNameMaxNumber(){
		init();
		String un1 = "12345678901234567890";
		System.out.println("长度："+un1.length()+" 输入内容："+un1);
		regist.inputUsername(un1);
		String s = regist.getUserNameText();
		System.out.println("长度："+s.length()+" 输入内容："+s);
		
	}
	
	private String getMessage(WebElement e, String input){
		String str = regist.mapElementMessage.get(e);
		e.sendKeys(input);
		regist.getCheckCodeTextElement().click();
		String r = regist.getMessage(str);
		regist.getPhoneNumberTextElement().clear();
		return r;
	}
	

	
}
