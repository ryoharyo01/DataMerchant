package com.magang.jcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class LoginPages {
	private WebDriver driver;
	
	public LoginPages() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#page-container > div > div.login-content > form > div:nth-child(1) > input")
	private WebElement txtUsername;
	
	@FindBy(css = "#page-container > div > div.login-content > form > div:nth-child(2) > input")
	private WebElement txtPassword;
	
	@FindBy(css = "#page-container > div > div.login-content > form > div.login-buttons > button")
	private WebElement btnLogin;
	
	@FindBy(css = "#content > div > div > div > div.card-block > h4 > b")
	private WebElement txtMessage;
	
	public void inputUsername(String username) {
		txtUsername.sendKeys(username);
	}
	
	public void inputPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickButtonLogin() {
		btnLogin.click();
	}
	
	public String getMessageText() {
		return txtMessage.getText();
	}
}
