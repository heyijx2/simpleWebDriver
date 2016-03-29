package com.sinashow.util;

import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import smile.heyi.excel.ReadExcel;

public class TestCaseExcel {
	private int startRow=2;
	private int endRow=10;
	final private String excelPath = System.getProperty("user.dir")
			+"\\CASE\\自动化CASE模板.xls";
	private String url = "http://www.1318.com/";
	private ArrayList<String> excelList;
	
	private WebDriver driver ;
	private ReadExcel rexcel ;
	
	public TestCaseExcel(){
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver1.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		rexcel = new ReadExcel();
		rexcel.setPath(excelPath, 2);
		
		startTest();
		
	}
	
	public void startTest(){
		while(startRow != endRow){
			excelList = rexcel.getRowToArrayList(startRow, 4, 6);
			try{
				runningExcelScripte(driver,excelPath,excelList);
			}catch(Exception e){
				System.out.println("异常");
				startRow--;
				startTest();
			}
			System.out.println("请确认");
			String doiing = (new Scanner(System.in)).next();
			
			if(doiing.equals("b")){
				startRow--;
			}else{
				startRow++;
			}
		}
	}
	
	public boolean isElementExsit(WebDriver driver, By locator) {
		boolean flag = false;
		try {
			WebElement element=driver.findElement(locator);
			flag=null!=element;
		} catch (NoSuchElementException e) {
			
		}
		return flag;
	}
	
	private String runningTestFromExcel(ArrayList<String> list, WebDriver driver){
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
	
	public WebElement getElement(WebDriver driver,By selector){
		if(isElementExsit(driver,selector)){
			return driver.findElement(selector);
		}else{
			return null;
		}
	}
}
