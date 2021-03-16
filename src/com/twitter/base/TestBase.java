package com.twitter.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() throws IOException {
		
	    prop = new Properties ();
		FileInputStream fis = new FileInputStream("C:\\Users\\sherif.helmy\\eclipse-workspace\\test\\src\\com\\twitter\\config\\config.properties");//path of file
	    prop.load(fis);
	    
	}
	
	public void initialization(String URL)
	{
		
		 System.setProperty("webdriver.chrome.driver","D:\\seleinum\\chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.get(URL);
		
	}

}
