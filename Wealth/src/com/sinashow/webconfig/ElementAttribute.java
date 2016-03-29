package com.sinashow.webconfig;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import smile.heyi.excel.ReadExcel;
import smile.heyi.excel.UpdateExcel;

public class ElementAttribute {
	public final static int ONLY_ChineseCharacters = 0;
	public final static int ONLY_Number = 1;
	public final static int ONLY_EnglisLetters = 2;
	public final static int MIXED_NumberEnglisChinesse = 3;
	public final String specialCharacters = "!@#$%^&*()./><~`";
	
	/**
	 * 获取输入框内文字(增加不可见属性判断)
	 * @param element
	 * @return
	 */
	public String getText(WebElement element){

		boolean flag = element.isDisplayed();
		String s = null;
		if(flag){
			s = element.getText();
		}else{
			s = element.getAttribute("value");
		}
		
		return s;
	}
	
	/**
	 * 获得连接地址
	 * @param element
	 * @return
	 */
	public String getLinkUrl(WebElement element){
		String s = null;
		s = element.getAttribute("href");
		return s;
	}
	
	public boolean isSelect(WebElement element){
		boolean flag = element.isSelected();
		return flag;
	
	}
	
	/**
	 * 输入框最大可输入字符数
	 * @param element 测试元素对象
	 * @param inputType 输入字符类型：ONLY_ChineseCharacters、ONLY_Number、ONLY_EnglisLetters
	 * 、MIXED_NumberEnglisChinesse
	 * @return 最大字符数量
	 */
	public int getTextFileMaxLength(WebElement element, int inputType){
		int size = 0;
		String s = "";
		
		switch(inputType){
		case ONLY_ChineseCharacters:
			s = "我";
			break;
		case ONLY_Number:
			s = "1";
			break;
		case ONLY_EnglisLetters:
			s = "a";
			break;
		case MIXED_NumberEnglisChinesse:
			s = "a我1";
			break;
		}
		
		for(int i=0;i<=100;i++){
			s += s;
		}
		element.sendKeys(s);
		size = getText(element).length();
		
		return size;
	}
	
	/**
	 * 输入特殊字符测试
	 * @param element
	 */
	public void setTextFileSpecialCharacters(WebElement element){
		element.sendKeys(specialCharacters);
	}
	
	/**
	 * 判断元素是否存在
	 * @param driver
	 * @param locator
	 * @return
	 */
	public boolean isElementExsit(WebDriver driver, By locator) {
		boolean flag = false;
		try {
			WebElement element=driver.findElement(locator);
			flag=null!=element;
		} catch (NoSuchElementException e) {
			
		}
		return flag;
	}
	
	
	/**
	 * 封装获得元素方法，增加异常处理
	 * @param driver
	 * @param selector
	 * @return
	 * 
	 */
	public WebElement getElement(WebDriver driver,By selector){
		if(isElementExsit(driver,selector)){
			return driver.findElement(selector);
		}else{
			throw new DriverException(selector);
		}
	}
	
	
	/**
	 * 根据Excel指定格式，执行测试
	 * @param list
	 * @param driver
	 * @return
	 */
	
	public String runningExcelScripte(WebDriver driver, String excelPath, ArrayList<String> list){
		String result = "";
		String doing = list.get(1);
		if(doing.equals("modular")){
			runningModularFromExcel(excelPath,list,driver);
		}else{
			result = runningTestFromExcel(list,driver);
		}
		return result;
	}
	
	public void runningModularFromExcel(String path, ArrayList<String> list, WebDriver driver){
		String columnText = list.get(2);
		ReadExcel rexcel = new ReadExcel();
		rexcel.setPath(path, 3);
		ArrayList<Integer> rowList = rexcel.getRowNumber(2, columnText);
		ArrayList<String>[] doningList ;
		doningList = rexcel.getZoneToArrayList(4, 6, rowList.get(0), rowList.get(rowList.size()-1));
		for(ArrayList<String> l : doningList){
			runningTestFromExcel(l, driver);
		}
	}
	
	
	public String runningTestFromExcel(ArrayList<String> list, WebDriver driver){
		String xpath = list.get(0);
		String doing = list.get(1);
		String rueslt ;

		WebElement e ;
		
		String sssf = "";
		switch(doing){
		case "click":
			e = getElement(driver,By.xpath(xpath));
			e.click();
			break;
			
		case "clear":
			e = getElement(driver,By.xpath(xpath));
			e.clear();
			break;
			
		case "input":
			e = getElement(driver,By.xpath(xpath));
			rueslt = list.get(2);
			e.sendKeys(rueslt);
			break;
			
		case "sleep":
			rueslt = list.get(2);
			try {
				Thread.sleep(Integer.parseInt(rueslt));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
		case "text":
			e = getElement(driver,By.xpath(xpath));
			sssf = e.getText();
			if(sssf.equals("") || sssf == null){
				sssf = "空";
			}
			System.out.println("a"+sssf);
			break;
			
		case "displayed":
			e = getElement(driver,By.xpath(xpath));
			if(e.isDisplayed()){
				sssf = "显示";
			}else{
				sssf = "不显示";
			}
			break;
			
		case "enable":
			e = getElement(driver,By.xpath(xpath));
			if(e.isEnabled()){
				sssf = "可用";
			}else{
				sssf = "不可用";
			}
			break;
			
		case "selected":
			e = getElement(driver,By.xpath(xpath));
			if(e.isSelected()){
				sssf = "选中";
			}else{
				sssf = "未选";
			}
			break;
			
		case "attribute":
			e = getElement(driver,By.xpath(xpath));
			rueslt = list.get(2);
			sssf = e.getAttribute(rueslt);
			break;
			
		case "url":
			sssf = driver.getCurrentUrl();
			break;
		case "back":
			driver.navigate().back();
			break;
		case "refresh":
			driver.navigate().refresh();
			break;

		case "rightClick":
			e = getElement(driver,By.xpath(xpath));
			Actions rightClick = new Actions(driver);
			rightClick.contextClick(e).perform();
			break;
			
		case "moveTo":
			e = getElement(driver,By.xpath(xpath));
			Actions moveTo = new Actions(driver);
			moveTo.moveToElement(e).perform();
			break;
		
		case "open":
			rueslt = list.get(2);
			driver.get(rueslt);
			break;
		
			//关闭当前或最后一个打开的窗体
		case "close":
			driver.close(); 
			break;
			
			//webdriver整体退出
		case "exit":
			driver.quit();
			driver = null;
			break;
			
		}
		
		return sssf;
	}
	
	
}
