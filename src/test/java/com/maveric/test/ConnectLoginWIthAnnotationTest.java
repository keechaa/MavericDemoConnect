package com.maveric.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.maveric.initialization.LaunchActivies;
import com.maveric.pageobjects.MavericLoginPage;
import com.maveric.pageobjects.MavericPortalPage;

public class ConnectLoginWIthAnnotationTest extends LaunchActivies {

	@Test(priority = 1)
	public void positiveCredentialCheck() throws IOException {

		String url = prop.getProperty("url");
		String userName = prop.getProperty("username");
		String password = prop.getProperty("password");
		String expectedtitle = prop.getProperty("expectedtitle");
		// Load URl//
		driver.get(url);

		MavericLoginPage login = new MavericLoginPage(driver);
		MavericPortalPage portal = new MavericPortalPage(driver, wait);

		System.out.println(login.getNoOfLinks());
		login.sendUserName(userName);
		login.sendPassword(password);
		login.clickLogin();
		String titleafterlogin = portal.waitForQMSDisplay();

		if (expectedtitle.equals(titleafterlogin)) {
			System.out.println("Matched");
		} else {
			System.out.println("Not Matched");
		}
		Assert.assertEquals(titleafterlogin, expectedtitle, "Validations on PositiveCredentials check");
	}
}
