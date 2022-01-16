package com.magang.jcb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class DashboardPages {
	private WebDriver driver;
	
	public DashboardPages() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > a")
	private WebElement btnDashboard;
	
	public void gotoDashboardPage() {
		btnDashboard.click();
	}
	
	@FindBy(css = "#content > div:nth-child(3) > div:nth-child(1) > div > div.stats-info > h4")
	private WebElement txtMonthlyVisit;
	
	public String getMonthly() {
		return txtMonthlyVisit.getText();
	}
	
	@FindBy(css = "#content > div:nth-child(3) > div:nth-child(2) > div > div.stats-info > h4")
	private WebElement txtUnvisit;
	
	public String getUnvisit() {
		return txtUnvisit.getText();
	}
	
	@FindBy(css = "#content > div:nth-child(3) > div:nth-child(3) > div > div.stats-info > h4")
	private WebElement txtMonthlyPrice;
	
	public String getMonthlyPrice() {
		return txtMonthlyPrice.getText();
	}
	
	@FindBy(css = "#content > div:nth-child(3) > div:nth-child(4) > div > div.stats-info > h4")
	private WebElement txtTotalPrice;
	
	public String getTotalPrice() {
		return txtTotalPrice.getText();
	}
	
	@FindBy(css = "#content > div:nth-child(4) > div > div > div.panel-heading.ui-sortable-handle > h4")
	private WebElement txtSummaryByArea;
	
	public String getSummary() {
		return txtSummaryByArea.getText();
	}
}
