package com.maveric.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MavericPointOfContactPage {

	By administrationContact1 = By.xpath("//span[text()='Administration Contact']");
	// By row1 = By.xpath("//table[@id='yw0-body-table']/tbody/tr");

	@FindBy(xpath = "//table[@id='yw0-body-table']/tbody/tr")
	List<WebElement> rows;

	@FindBy(xpath = "//span[text()='Administration Contact']")
	WebElement administrationContact;

	WebDriver driver;
	WebDriverWait wait;

	public MavericPointOfContactPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public int getNoOfRowsInTable() {
		wait.until(ExpectedConditions.presenceOfElementLocated(administrationContact1));
		administrationContact.click();
		// List<WebElement> rows = driver.findElements(row1);
		int rowSize = rows.size();
		return rowSize;
	}

	public List<String> getadminstrativecontacts() {
		List<String> listOfEmailsIds = new ArrayList<String>();

		for (int i = 1; i <= rows.size(); i++) {

			String email = driver.findElement(By.xpath("//table[@id='yw0-body-table']/tbody/tr[" + i + "]/td[5]"))
					.getText();
			// System.out.println(email);
			listOfEmailsIds.add(email);
		}
		return listOfEmailsIds;
	}

	public List<String> getadminstrativecolumn(int coloumnNum) {
		List<String> listOfEmailsIds = new ArrayList<String>();

		for (int i = 1; i <= rows.size(); i++) {

			String CoulmnEle = driver
					.findElement(By.xpath("//table[@id='yw0-body-table']/tbody/tr[" + i + "]/td[" + coloumnNum + "]"))
					.getText();
			// System.out.println(CoulmnEle);
			listOfEmailsIds.add(CoulmnEle);
		}
		return listOfEmailsIds;

	}
}
