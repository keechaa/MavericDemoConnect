package com.maveric.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MavericLoginPage {

	@FindBy(xpath = "(//input[@type='text'])")
	WebElement userNameEle;

	@FindBy(name = "LoginForm[password]")
	WebElement passwordEle;

	@FindBy(how = How.NAME, using = "yt0")
	WebElement logIn;

	@FindBy(xpath = "//div[text()='Invalid user name']")
	WebElement errorEle;

	@FindBy(tagName = "a")
	List<WebElement> linksEle;

	/*
	 * @FindAll(@FindBy(tagName = "a")) List<WebElement> linksEle1;
	 */

	// By errorLoc = By.xpath("//div[text()='Invalid user name']");
	WebDriver driver;

	public MavericLoginPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void sendUserName(String userName) {

		userNameEle.sendKeys(userName);
	}

	public void sendPassword(String password) {

		passwordEle.sendKeys(password);
	}

	public void clickLogin() {

		logIn.click();
	}

	public String getActualError() {
		String actualError = errorEle.getText();
		System.out.println(actualError);
		return actualError;

	}

	public int getNoOfLinks() {
		// List<WebElement> linksEle = driver.findElements(By.tagName("a"));
		int noOfLinks = linksEle.size();
		return noOfLinks;
	}
}
