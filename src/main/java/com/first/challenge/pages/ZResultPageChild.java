package com.first.challenge.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.first.challenge.base.ZBasePage;
import com.first.challenge.util.ZUtilPage;

public class ZResultPageChild extends ZBasePage {

	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//h4[@class='ui-agent__name']")
	WebElement agentName;

	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//img[@class='js-lazy-loaded']")
	WebElement agentLogo;

	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//a[@class='ui-link']")
	WebElement agentNum;

	public ZResultPageChild() {
		PageFactory.initElements(driver, this);
	}

	public String getAgentName() {
		ZUtilPage.waitForElementToBeVisible(driver, agentName);
		return agentName.getText();
	}

	public String getAgentLogo() {
		ZUtilPage.waitForElementToBeVisible(driver, agentLogo);
		return agentLogo.getAttribute("src");
	}

	public String getAgentNum() {
		ZUtilPage.waitForElementToBeVisible(driver, agentNum);
		return agentNum.getText();
	}

	public ZAgentPage goToAgentPage() {
		agentName.click();
		return new ZAgentPage();
	}
}
