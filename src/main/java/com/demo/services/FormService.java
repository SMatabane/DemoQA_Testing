package com.demo.services;


import java.util.List;
import java.util.Map;

import com.demo.pages.FormPage;

public class FormService {
	
	private FormPage page;
	
	
	
	public FormService(FormPage page) {
		this.page = page;
	}

	/**
	 * @param fname
	 * @param lname
	 * @param email
	 * @param number
	 * @param data
	 * @param adress
	 * @param gender
	 * @param hobby
	 */
	public void submit(Map<String,String> datas) {
		String fname=datas.get("FirstName");
		String lname=datas.get("LastName");
		String email=datas.get("Email");
		String gender=datas.get("Gender");
		String number=datas.get("mobile");
		String date=datas.get("Date");
		String subject=datas.get("Subjects");
		String adress=datas.get("address");
		String hobby = datas.get("hobbies");
		String states=datas.get("state").trim();
		String city=datas.get("city").trim();
		
				
		page.sendkeys(fname, lname, email,gender, number, date,subject,hobby, adress);
		page.selectState(states);
		page.selectCity(city);
		
		
	}
	
	public boolean TitleDisplayed() {
		return page.IsShown();
	}
	
	

}
