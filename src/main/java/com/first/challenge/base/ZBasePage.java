package com.first.challenge.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.first.challenge.util.ZUtilPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZBasePage {

	public static Properties props;

	public static WebDriver driver;

	public ZBasePage() {
		props = new Properties();

		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\indeztruk\\eclipse-workspace\\SeleniumChallenge1\\src\\main\\java\\com\\first\\challenge\\config\\config.properties");
			props.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initilization() {
		String browser = props.getProperty("browser");

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(ZUtilPage.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ZUtilPage.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get("https://www.zoopla.co.uk/");

	}
}
