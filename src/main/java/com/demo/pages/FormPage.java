package com.demo.pages;

import java.io.File;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.base.BaseTest;
import com.demo.utilities.ActionClass;
import com.demo.utilities.JSExecutor;

public class FormPage extends BaseTest{
	
  private ActionClass a;
	
	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstNameTextField;
	
	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='uploadPicture']")
	private WebElement uploadPictureBtn;
	
	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement email;
	
	@FindBy(xpath = "//input[contains(@id,'gender-radio')]")
	private List<WebElement> gender;
	
	@FindBy(xpath = "//input[@id='userNumber']")
	private WebElement number;
	
	@FindBy(xpath = "//input[@id='dateOfBirthInput']")
	private WebElement dates;
	
	@FindBy(xpath = "//input[@id='subjectsInput']")
	private WebElement subjects;
	
	@FindBy(xpath = "//input[contains(@id,'hobbies-checkbox')]")
	private List<WebElement> hobbiesElm;
	
	@FindBy(xpath = "//input[@id='uploadPicture']")
	private WebElement files;
	
	@FindBy(xpath = "//textarea[@id='currentAddress']")
	private WebElement address;
	
	@FindBy(xpath = "//input[@id='react-select-3-input']")
	private WebElement stateinput;
	
	@FindBy(xpath = "//input[@id='react-select-4-input']")
	private WebElement cityinput;
	
	@FindBy(xpath = "//button[@id='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//div[contains(@class,'modal-title')]")
	private WebElement title;
	
	@FindBy(xpath="following-sibling::div//input")
	private WebElement siblin2;
	
	@FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthSelect;
 
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearSelect;
    
    private By sibling = By.xpath("//following-sibling::label");
    
    

	
	
	
	public FormPage() {
		PageFactory.initElements(getDriver(), this);
		a=new ActionClass();
		
	}
	
	/**
	 * This method sends keys to the webform
	 * @param firstNameTextField
	 * @param lastName
	 * @param email
	 * @param number
	 * @param date
	 * @param address
	 */
	public void sendkeys(String firstName,
			String lastName,
			String email,
			String g,
			String number,
			String date,
			String subject,
			String hobby,
			String address) {
        
		
		JSExecutor.scrollToElement(firstNameTextField);
		a.sendKeys(firstNameTextField, firstName);
		a.sendKeys(this.lastName, lastName);
		a.sendKeys(this.email, email);
		selectGender(g);
		a.sendKeys(this.number, number);
		a.sendKeys(this.dates, date);
		a.enterKey(dates);
		subjects(subject);
		SelectHobbies(hobby);
		uploadPicture();
		a.sendKeys(this.address, address);
	}
	
	
	//
	/**
	 * This method selects genders
	 * @param genders
	 */
	public void selectGender(String genders) {
			for(WebElement element : gender){
				//String radioGender = element.findElement(sibling).getText();
				if(element.getDomAttribute("value").equalsIgnoreCase(genders)){
					//siblings.click();  
					a.clicks(element);
					
					
				}
			
		}
		
	}
	
	public void subjects(String subject) {
		JSExecutor.scrollToElement(subjects);
		for(String subj:subject.split(",")) {			
			subjects.sendKeys(subj);
		    a.enterKey(subjects);
		}
		
		
	}
	
    public void SelectHobbies(String hobbies){
    	
        for(WebElement element : hobbiesElm){
        	String h = element.findElement(sibling).getText();
            if(hobbies.contains(h)){
               a.clicks(element);
            }       
    	}	
	}
    
    
    /**
     * This method selects state
     * @param state
     */
    public void selectState(String state) {
    	

     a.sendKeys(stateinput, state);
     a.enterKey(stateinput);
    	
    	
    }
    
    public void selectCity(String city) {
    	
    	  a.sendKeys(cityinput, city);
    	  a.enterKey(cityinput);

    }
    
    /**
     * This method uploads picture
     */
    public void uploadPicture(){
        File file = new File("src/test/resources/testData/1734626710419.gif");
        String filePath = file.getAbsolutePath();
        uploadPictureBtn.sendKeys(filePath);
}
    
    //
    public boolean IsShown() {
    	submitBtn.submit();
    	WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOf(title));
    	
    	
    	return title.isDisplayed();
    	
    }

	private void openDatePicker() {
		JSExecutor.clickElements(dates);
	}

	public void selectDate(String date) {
		openDatePicker();

		WebElement ActualDay = getDriver().findElement(By.xpath("//div[contains(@aria-label,'" + date+ "')]"));
		JSExecutor.clickElements(ActualDay);
	}
	
}