package com.sinashow.webconfig;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class DriverException extends NoSuchElementException{
	public DriverException(){
		super("WebDriver�쳣");
		System.out.println(super.getMessage());
	}
	
	public DriverException(String message){
		super(message);
	}
	
	public DriverException(By selector){
		super("�Ҳ���Ԫ�أ�"+selector);
	}
}
