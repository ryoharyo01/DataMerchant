package com.magang.jcb.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements DriverStrategy {
	public WebDriver setStrategy() {
		System.setProperty("webdriver.chrome.driver", "D:/App/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
		
	}
}
