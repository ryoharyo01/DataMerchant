package com.magang.jcb.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class VisitOtherPage {
	private WebDriver driver;

	public VisitOtherPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content > h1")
	private WebElement pageHeader;

	@FindBy(css = "#content > div.row > div:nth-child(2) > form > div.panel.panel-info > div.panel-heading > h4")
	private WebElement panelTitle1;

	@FindBy(css = "#collateral > div.panel-heading > h4")
	private WebElement panelTitle2;

	@FindBy(id = "resume")
	private WebElement resume;

	@FindBy(xpath = "/html/body/div[5]/div[1]/div[2]/form/div[3]/div[2]/div/input")
	private WebElement other_resume;

	@FindBy(css = "#content > div.row > div:nth-child(2) > form > input")
	private WebElement submit;

	public void chooseOptions(String string) {
		resume.click();
		for (int i = 1; i <= 5; i++) {
			resume.sendKeys(Keys.DOWN);

		}
		resume.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		other_resume.sendKeys(string);

	}

	public void confirm() {
		submit.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String getPageHeader() {
		return pageHeader.getText();
	}

	public String getPanelTitle1() {
		return panelTitle1.getText();
	}

	public String getPanelTitle2() {
		return panelTitle2.getText();
	}

}
