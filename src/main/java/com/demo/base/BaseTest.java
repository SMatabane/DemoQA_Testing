package com.demo.base;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.demo.utilities.PropertiesFile;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	
	private static ThreadLocal<RemoteWebDriver> d = new ThreadLocal<>();
	private PropertiesFile pt;
	//get the driver
	public static WebDriver getDriver() {
		return  d.get();
	}
	
	
	//setting browser
	public void setUp() {
		loadProperties();
		String browser=pt.getProperties("browser");
		
		switch(browser.toLowerCase()) {
		   case "chrome":
			  // WebDriverManager.chromedriver().setup();
			   ChromeOptions cot=new ChromeOptions();
			   cot.addArguments().setPageLoadStrategy(PageLoadStrategy.NORMAL);
		       
			   d.set(new ChromeDriver(cot)); 
			   break;
			   
		   case "edge":
			   WebDriverManager.edgedriver().setup();
			   EdgeOptions eot=new EdgeOptions();
			   eot.addArguments().setPageLoadStrategy(PageLoadStrategy.NORMAL);
		       
			   d.set(new EdgeDriver(eot));
			   break;
			   
			default:
				System.out.println("Invalid browser");
			   
			   
			
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(
				Duration.ofSeconds(Integer.parseInt(pt.getProperties("implicitwait"))));
		
		
	}
	
	public void loadProperties() {
		pt = new PropertiesFile();
	}

	public Set<String> getWindiwHandles(){
		return getDriver().getWindowHandles();
	}

	/**
	 * switch to newWindow
	 * @return
	 * @throws InterruptedException
	 */
	public void switchToWindow(String windowHandle) throws InterruptedException {
		getDriver().switchTo().window(windowHandle);
	}
}
