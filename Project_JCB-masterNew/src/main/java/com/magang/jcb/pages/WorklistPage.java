package com.magang.jcb.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class WorklistPage {
	private WebDriver driver;

	public WorklistPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(8) > a")
	private WebElement worklstPage;

	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li")
	private List<WebElement> lstItem;

	@FindBy(css = "#content > div > div:nth-child(1) > div > strong")
	private WebElement alertSuccess;

	@FindBy(id = "id_area")
	private WebElement idArea;

	@FindBy(id = "btn-filter")
	private WebElement btnFilter;

	@FindBy(css = "#data-worklist_filter > label > input")
	private WebElement searchBar;

	@FindBy(id = "btnSearch")
	private WebElement btnSearch;

	@FindBy(css = "#data-worklist > tbody > tr:nth-child(1) > td:nth-child(2) > a.btn.btn-primary.btn-icon.btn-circle")
	private WebElement visitBtn;

	@FindBy(css = "#data-worklist > tbody > tr:nth-child(1) > td:nth-child(2) > a.btn.btn-danger.btn-icon.btn-circle")
	private WebElement conditionBtn;

	@FindBy(id = "data-worklist_next")
	private WebElement nextPage;

	@FindBy(id = "data-worklist_previous")
	private WebElement prevPage;
	
	public WebElement getAlertSuccess() {
		return alertSuccess;
	}

	public void toWorklist() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		worklstPage.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toNewData() {
		for (WebElement webElement : lstItem) {
			System.out.println(webElement.getText());
		}
		lstItem.get(0).click();
	}
	
	public void toAddNewData() {
		lstItem.get(3).click();
		
	}

	public void chooseArea() {
		idArea.click();
		idArea.sendKeys(Keys.DOWN);
		idArea.sendKeys(Keys.ENTER);
		btnFilter.click();

	}

	public void clickFilter() {
		btnFilter.click();
	}

	public void searchItem(String string) {
		searchBar.sendKeys(string);
		btnSearch.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void toVisitItem() {
		visitBtn.click();
	}

	public void toOtherCondition() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conditionBtn.click();
	}

	public void toNextPrev() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextPage.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prevPage.click();

	}
}
