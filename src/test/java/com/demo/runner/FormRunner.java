package com.demo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"./src/test/resources/feature/formfeature.feature"},
glue= {"com\\demo\\stepdef","com\\demo\\hooks"}
,plugin="pretty")
public class FormRunner extends AbstractTestNGCucumberTests{

}
