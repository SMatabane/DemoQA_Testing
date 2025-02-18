package com.demo.stepdef;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import com.demo.base.BaseTest;
import com.demo.hooks.Hooks;
import com.demo.services.FormService;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormStep extends BaseTest{
	
	private FormService service;
	
	public FormStep(Hooks h) {
		service = h.getService();
	}
	
	
	@Given("I visit {string}")
	public void openPage(String url) {
		
		getDriver().get(url);
	}
	
	@When("I fill in the details")
	public void fillform(DataTable table) {
		List<Map<String,String>> tableData = table.asMaps(String.class,String.class);
	    Map<String,String> details = tableData.get(0);
	    service.submit(details);	}
	
	@Then("submit the form and get confirmation text")
	public void formsumbit() {
		assertTrue(service.TitleDisplayed());
	}
	
	}
