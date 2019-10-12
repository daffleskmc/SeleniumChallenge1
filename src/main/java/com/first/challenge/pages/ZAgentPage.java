package com.first.challenge.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.first.challenge.base.ZBasePage;

public class ZAgentPage extends ZBasePage {

	@FindBy(xpath = "//div[@class='sidebar sbt']//p[1]//strong")
	WebElement agentName;

	@FindBy(xpath = "//div[@class='sidebar sbt']//img[@class='agent_logo']")
	WebElement agentLogo;

	// @FindBy(xpath = "")
	// WebElement agentNum;

	public ZAgentPage() {
		PageFactory.initElements(driver, this);
	}

	public String getAgentName() {
		return agentName.getText();
	}

	public String getAgentLogo() {
		return agentLogo.getAttribute("src");
	}
}
