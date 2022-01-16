package com.magang.jcb.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magang.jcb.drivers.DriverSingleton;

public class WorklistAddPage {
	private WebDriver driver;

	public WorklistAddPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content > div > div.col-lg-12.m-b-5.ui-sortable > div > div.panel-heading.ui-sortable-handle > h4")
	private WebElement panelTitle;

	@FindBy(css = "select[name='city']")
	private WebElement city;

	@FindBy(css = "select[name='area']")
	private WebElement area;

	@FindBy(css = "select[name='batch']")
	private WebElement batch;

	@FindBy(xpath = "//input[@name='merchant_name']")
	private WebElement merchant_name;

	@FindBy(css = "#content > div > div.col-lg-12.m-b-5.ui-sortable > div > div.panel-body > form > div:nth-child(5) > div > textarea")
	private WebElement address;

	@FindBy(css = "input[name='address_by_floor']")
	private WebElement address_by_floor;

	@FindBy(css = "input[name='category']")
	private WebElement category;

	@FindBy(xpath = "//input[@name='pic']")
	private WebElement pic;

	@FindBy(xpath = "//input[@name='no_telp_pic']")
	private WebElement no_telp_pic;

	@FindBy(css = "select[name='pic_position']")
	private WebElement pic_position;

	@FindBy(id = "other_position")
	private WebElement other_position;

	@FindBy(css = "select[name='merchant_accept_jcb_card']")
	private WebElement merchant_accept_jcb_card;

	@FindBy(id = "other_jcb")
	private WebElement other_jcb;

	@FindBy(css = "select[name='business_issue']")
	private WebElement business_issue;

	@FindBy(id = "other_issue")
	private WebElement other_issue;

	@FindBy(css = ".fa.fa-save")
	private WebElement submit;

	@FindBy(css = "button[name='submit'][type='reset']")
	private WebElement cancel;

	public WebElement getPanelTitle() {
		return panelTitle;
	}

	public void chooseCity() {
		city.click();
		_sendKeys(city);

	}

	public void chooseArea() {
		area.click();
		_sendKeys(area);

	}

	public void chooseBatch() {
		batch.click();
		_sendKeys(batch);

	}

	public void fillName(String string) {
		merchant_name.sendKeys(string);

	}

	public void fillAddress(String string) {
		address.sendKeys(string);

	}

	public void fillAddrFloor(String string) {
		address_by_floor.sendKeys(string);

	}

	public void fillCategory(String string) {
		category.sendKeys(string);

	}

	public void fillPIC(String string) {
		pic.sendKeys(string);

	}

	public void fillPhone(String string) {
		no_telp_pic.sendKeys(string);

	}

	public void choosePosition(String string) {
		pic_position.click();
		for (int i = 0; i < 1; i++) {
			pic_position.sendKeys(Keys.DOWN);
		}
		pic_position.sendKeys(Keys.ENTER);
//		waiting();
//		other_position.sendKeys(string);

	}
	
	public void chooseAcceptCard(String string) {
		merchant_accept_jcb_card.click();
		for (int i = 0; i < 5; i++) {
			merchant_accept_jcb_card.sendKeys(Keys.DOWN);
		}
		merchant_accept_jcb_card.sendKeys(Keys.ENTER);
		waiting();
		other_jcb.sendKeys(string);

	}
	
	public void chooseIssue(String string) {
		business_issue.click();
		for (int i = 0; i < 4; i++) {
			business_issue.sendKeys(Keys.DOWN);
		}
		business_issue.sendKeys(Keys.ENTER);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
		waiting();
		other_issue.sendKeys(string);

	}
	
	public void submitForm() {
		submit.click();
		waiting();
		
	}
	
	public void cancelForm() {
		cancel.click();
		waiting();
		
	}

	private void waiting() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}

	}

	private void _sendKeys(WebElement webElement) {
		webElement.sendKeys(Keys.DOWN);
		webElement.sendKeys(Keys.ENTER);

	}

}
