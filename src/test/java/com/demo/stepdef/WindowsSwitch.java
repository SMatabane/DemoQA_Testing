package com.demo.stepdef;

import com.demo.base.BaseTest;
import com.demo.hooks.Hooks;
import com.demo.pages.SwitchWindowns;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class WindowsSwitch extends BaseTest {
    private SwitchWindowns service;
    String text;

    public WindowsSwitch(Hooks h) {
        service = h.getWindows();
    }

    @Given("I visit web {string}")
    public void visitWebsite(String url){
        getDriver().get(url);

    }
    @When("I switch open new window")
    public void switchWindows() throws InterruptedException{
        Set<String> handles = getWindiwHandles();
        for(String handle : handles){
            service.switchToWindow(handle);
            if(service.isShown(service.getBodyText())){
                break;
            }
        }
    }
    @Then("I should get {string}")
    public void alert(String expectedText){
        assertEquals(service.getBodyText().getText(),expectedText);
    }
}
