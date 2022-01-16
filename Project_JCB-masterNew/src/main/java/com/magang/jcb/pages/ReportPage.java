package com.magang.jcb.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class ReportPage {
private WebDriver driver;
	
	public ReportPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[href='https://dev.ptdika.com/jcb/new/report']")
	private WebElement reportPage;
	
	@FindBy(xpath = "//h1[@class='page-header']")
	private WebElement txtReport;
	
	@FindBy(id = "kategori")
	private WebElement kategori;
	
	@FindBy(id = "datepicker-autoClose")
	private WebElement startDate;
	
	@FindBy(id = "datepicker-autoClose2")
	private WebElement endDate;
	
	@FindBy(xpath = "//td[@class='active day']")
	private WebElement datePicker;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement processBtn;
	
	@FindBy(xpath = "//a[@class='btn btn-success']")
	private WebElement newTempBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Logout']")
	private WebElement logout;

	public String getTxtReport() {
		return txtReport.getText();
	}
	
	public void toReport() {
		reportPage.click();
	}
	
	public void chooseKategori() {
		kategori.click();
		kategori.sendKeys(Keys.DOWN);
		kategori.sendKeys(Keys.DOWN);
		kategori.sendKeys(Keys.ENTER);
		kategori.click();
		kategori.sendKeys(Keys.DOWN);
		kategori.sendKeys(Keys.ENTER);
		
	}
	
	public void chooseSDate(String date) {
		startDate.click();
		startDate.sendKeys(date);
		startDate.click();
		datePicker.click();
		
	}
	
	public void chooseEDate(String date) {
		endDate.click();
		endDate.sendKeys(date);
		endDate.click();
		datePicker.click();
		
	}
	
	public void downloadReport() {
		processBtn.click();
		
	}
	
	public void downloadReport2() {
		newTempBtn.click();
		
	}
	
	public void logout() {
		this.logout.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
