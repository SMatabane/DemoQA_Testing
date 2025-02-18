package com.demo.utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.base.BaseTest;


public class ActionClass extends BaseTest{
	private Actions action;
	
	
	public ActionClass() {
		
		action=new Actions(getDriver());
	}
	
	//send keys
	public void sendKeys(WebElement elm,String text) {
		action.sendKeys(elm,Keys.CLEAR).sendKeys(elm, text).perform();
	
	}
	
	//click on product
	public void clicks(WebElement elem) {
		//action.click(elem).perform();
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", elem);
		
		
	}
	
	public void enterKey(WebElement el) {
		action.sendKeys(el,Keys.ENTER).perform();
	}
	
	//moving to element
	public void moveToElem(WebElement elm) {
		action.moveToElement(elm);
	}
	
	//dragg and drop
	public void DragandDrop(WebElement el1,WebElement el2) {
		action.dragAndDrop(el1, el2).perform();
	}
	
	public void explicitWait(WebDriver driver, WebElement element, Duration timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	

}
