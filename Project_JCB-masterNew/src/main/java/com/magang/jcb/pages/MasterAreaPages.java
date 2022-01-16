package com.magang.jcb.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.magang.jcb.drivers.DriverSingleton;

public class MasterAreaPages {
	private WebDriver driver;
	
	public MasterAreaPages() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//ul[@class=\"sub-menu\"]//li//a[contains(@href, \"https://dev.ptdika.com/jcb/new/area\")]")
	private WebElement gotoAreaPage;
	
	public void clickArea() {
		gotoAreaPage.click();
	}
	
	
	@FindBy(css = "#content > div.row > div:nth-child(1) > div > a")
	private WebElement btnAddNewArea;
	
	public void clickBtnAdd() {
		btnAddNewArea.click();
	}
	
	@FindBy(css = "#modalAdd > div > div > div.modal-body > form > fieldset > div > div > input")
	private WebElement txtArea;
	
	public void inputArea(String area) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(txtArea));
		txtArea.sendKeys(area);
	}
	
	@FindBy(css = "#modalAdd > div > div > div.modal-body > form > fieldset > button.btn.btn-sm.btn-primary.m-r-5")
	private WebElement btnSave;
	
	public void clickSave() {
		btnSave.click();
	}
}
