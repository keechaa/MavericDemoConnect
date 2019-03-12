package com.maveric.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MavericPortalPage {

	By QMSLoc = By.linkText("QMS");
	@FindBy(xpath = "//a[text()='Corporate']")
	WebElement corporate;

	@FindBy(xpath = "//a[text()='Point of Contact']")
	WebElement pointOfContact;
	WebDriver driver;
	WebDriverWait wait;

	public MavericPortalPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public String waitForQMSDisplay() {
		wait.until(ExpectedConditions.presenceOfElementLocated(QMSLoc));

		String titleafterlogin = driver.getTitle();
		System.out.println(titleafterlogin);
		return titleafterlogin;
	}

	public void mouseOver() {
		wait.until(ExpectedConditions.presenceOfElementLocated(QMSLoc));
		Actions action = new Actions(driver);
		action.moveToElement(corporate).pause(Duration.ofSeconds(2)).build().perform();
		// wait.until(ExpectedConditions.presenceOfElementLocated(pointOfContact)
		pointOfContact.click();
	}
}
