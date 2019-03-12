package com.maveric.initialization;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.maveric.utilities.PropertiesHandler;

public class LaunchActivies {
	public WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;

	@BeforeMethod
	@Parameters({ "browser" })
	public void initialisation(@Optional("ch") String browser) throws IOException {

		// System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");

		// driver = new ChromeDriver();

		System.out.println(browser);

		prop = PropertiesHandler.getPropertiesDetails("Utilities/data.properties");

		// Open and maximixe Browser//
		selectBrowser(browser);
		driver.manage().window().maximize();

		// Implicit and Explicit wait creation//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
	}

	public void selectBrowser(String browser) {
		switch (browser.toLowerCase()) {
		case "ch":
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "ff":
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
