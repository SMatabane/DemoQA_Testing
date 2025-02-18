package com.demo.hooks;

import com.demo.base.BaseTest;
import com.demo.pages.FormPage;
import com.demo.pages.SwitchWindowns;
import com.demo.services.FormService;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTest{
	
	public FormService page;
	public SwitchWindowns spage;
	
	
	
	@Before
	public void setUp() {
		super.setUp();
		FormPage p=new FormPage();
		page=new FormService(p);
		spage=new SwitchWindowns();
		
	}
	
	public  FormService getService() {
		return page;
	}
	public  SwitchWindowns getWindows(){return spage;}
	
	@After
	public void tearDown() {
		getDriver().quit();

	}

}
