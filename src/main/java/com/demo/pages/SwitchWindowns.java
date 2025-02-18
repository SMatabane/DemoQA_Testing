package com.demo.pages;

import com.demo.base.BaseTest;

import com.demo.utilities.ActionClass;
import com.demo.utilities.JSExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Set;

public class SwitchWindowns extends BaseTest {


	
	@FindBy(xpath = "//button[@id='tabButton']")
	private WebElement tab;
	
	@FindBy(xpath = "//button[@id='windowButton']")
	private WebElement newWindow;

	@FindBy(xpath="//h1[@id='sampleHeading']")
	private WebElement BodyText;
	
	@FindBy(xpath = "//button[@id='messageWindowButton']")
	private WebElement newWindowMessage;

	public SwitchWindowns() {
		PageFactory.initElements(getDriver(), this);

	}

	public boolean isShown(WebElement element){
		ActionClass actionClass = new ActionClass();
		actionClass.explicitWait(getDriver(),
				element,
				Duration.ofSeconds(2));
		return element.isDisplayed();
	}

	public WebElement getBodyText() {
		return BodyText;
	}
}
