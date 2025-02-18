package com.demo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	private Properties pt;
	public PropertiesFile(){
	try {
		FileInputStream fs=new FileInputStream(".\\src\\main\\resources\\Config\\config.properties");
		pt=new Properties();
		pt.load(fs);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("File not found" + e.getMessage());
	}catch (IOException eo) {
		System.out.println("File not found" + eo.getMessage());
	}
	
	}
	
	public String getProperties(String p) {
		return pt.getProperty(p);
		
	}

}
