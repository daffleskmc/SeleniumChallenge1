package com.first.challenge.util;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZUtilPage {

	public static long PAGE_LOAD_TIMEOUT = 40;

	public static long IMPLICIT_TIMEOUT = 40;

	public static long EXPLICIT_TIMEOUT = 40;

	public static void waitForPageLoad(WebDriver driver, List<WebElement> e) {
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfAllElements(e));
	}

	public static void moveElementToView(WebDriver driver, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", e);
	}

	public static void waitForElementToBeVisible(WebDriver driver, WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
}
