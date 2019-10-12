package com.first.challenge.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.first.challenge.base.ZBasePage;

public class ZMainPage extends ZBasePage {

	@FindBy(id = "search-input-location")
	WebElement searchFld1;

	public ZMainPage() {
		PageFactory.initElements(driver, this);
	}

	public ZResultPage searchForSale(String location) {
		searchFld1.sendKeys(location);
		searchFld1.sendKeys(Keys.ENTER);

		return new ZResultPage();
	}

}
