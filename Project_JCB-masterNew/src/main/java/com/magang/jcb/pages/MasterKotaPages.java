package com.magang.jcb.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.magang.jcb.drivers.DriverSingleton;

public class MasterKotaPages {
	private WebDriver driver;
	
	public MasterKotaPages() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class=\"sub-menu\"]//li//a[contains(@href, \"https://dev.ptdika.com/jcb/new/master/city\")]")
	private WebElement gotoKota;
	
	public void clickGotoKota() {
		gotoKota.click();
	}
	
	
	@FindBy(css = "#content > div.row > div:nth-child(1) > div > a")
	private WebElement btnAddKota;
	
	public void clickBtnAddKota() {
		btnAddKota.click();
	}
	
	@FindBy(name = "city")
	private WebElement txtInputKota;
	
	public void inputKota(String inputKota) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(txtInputKota));
		txtInputKota.sendKeys(inputKota);
	}
	
	@FindBy(css = "#modalAdd > div > div > div.modal-body > form > fieldset > button.btn.btn-sm.btn-primary.m-r-5")
	private WebElement btnSaveInputKota;
	
	public void clickSaveKota() {
		btnSaveInputKota.click();
	}
}
