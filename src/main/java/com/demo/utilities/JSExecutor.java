package com.demo.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.demo.base.BaseTest;

public  class JSExecutor extends BaseTest{
	
	public static void clickElements(WebElement elem) {
		
		JavascriptExecutor jse = getJavascriptExecutor();
		jse.executeScript("arguments[0].click();", elem);
		
	}
	
	public static void scrollToElement(WebElement element) {
		JavascriptExecutor jse = getJavascriptExecutor();
		 jse.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	private static JavascriptExecutor getJavascriptExecutor() {
		return (JavascriptExecutor)getDriver();
	
	}
	
	
	
	

}
