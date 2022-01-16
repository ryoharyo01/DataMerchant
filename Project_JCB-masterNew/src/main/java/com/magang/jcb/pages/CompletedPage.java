package com.magang.jcb.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class CompletedPage {
	private WebDriver driver;

	public CompletedPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://dev.ptdika.com/jcb/new/completed']")
	private WebElement completedPage;

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[2]/div/div[1]/h4")
	private WebElement txtDataCompleted;

	@FindBy(id = "area")
	private WebElement lstArea;

	@FindBy(id = "btn-filter")
	private WebElement btnFilter;

	@FindBy(css = "#data-worklist_filter > label > input")
	private WebElement searchBar;

	@FindBy(id = "btnSearch")
	private WebElement btnSearch;

	@FindBy(css = "#data-worklist > tbody > tr:nth-child(1) > td:nth-child(1) > div > a.btn.btn-primary.btn-sm")
	private WebElement vPhoto;

	@FindBy(css = "#data-worklist > tbody > tr:nth-child(1) > td:nth-child(1) > div > a.btn.btn-success.btn-sm")
	private WebElement vEDC;

	@FindBy(id = "myModalLabel")
	private WebElement myModalLabel;

	@FindBy(css = "#modalImage > div > div > div.modal-header > button")
	private WebElement closeBtn;

	@FindBy(css = "#data-worklist > tbody > tr:nth-child(1) > td:nth-child(2)")
	private WebElement txtCheck;

	@FindBy(id = "data-worklist_next")
	private WebElement nextData;

	@FindBy(id = "data-worklist_previous")
	private WebElement prevData;

	@FindBy(xpath = "//*[@id=\"sidebar\"]/div/div[1]/ul[2]/li[12]/a")
	private WebElement logout;

	public void logout() {
		logout.click();
	}

	public void changePage() {
		waiting();
		nextData.click();
		waiting();
		prevData.click();
	}

	public String getTxtCheck() {
		return txtCheck.getText().toLowerCase();
	}

	public void clearSearch() {
		searchBar.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		searchBar.sendKeys(Keys.BACK_SPACE);
		searchBar.sendKeys(Keys.ENTER);
	}

	public void viewPhoto() {
		vPhoto.click();
		waiting();
	}

	public void viewEDC() {
		vEDC.click();
		waiting();
	}

	public void close() {
		closeBtn.click();
	}

	public String getMyModalLabel() {
		return myModalLabel.getText().toLowerCase();
	}

	public void chooseArea() {
		lstArea.click();
		lstArea.sendKeys(Keys.DOWN);
		lstArea.sendKeys(Keys.ENTER);
	}

	public void testFilter() {
		btnFilter.click();
	}

	public void searchData(String string) {
		searchBar.sendKeys(string);
		waiting();
		btnSearch.click();

		waiting();

	}

	private void waiting() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toCompleted() {
		completedPage.click();

	}

	public String getTxtDataCompleted() {
		return txtDataCompleted.getText().toLowerCase();
	}

}
