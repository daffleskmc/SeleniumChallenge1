package com.first.challenge.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.first.challenge.base.ZBasePage;
import com.first.challenge.pages.ZAgentPage;
import com.first.challenge.pages.ZMainPage;
import com.first.challenge.pages.ZResultPage;
import com.first.challenge.pages.ZResultPageChild;

public class ZResultPageTest extends ZBasePage {

	ZMainPage main;

	ZResultPage result;

	ZResultPageChild resultChild;

	ZAgentPage agent;

	public ZResultPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initilization();
		main = new ZMainPage();

	}

	@Test(priority = 1)
	public void testSearch() {
		// 1. Input location London
		result = main.searchForSale("London");

		// 2. Print all the price values in sorted order (descending order) on the
		// console
		List<String> list = result.getPriceListDesc();
		System.out.println(list);

		// 3. Select the 5th property on that list (its changing every minute, so it’s
		// dynamic)
		resultChild = result.getPriceList5th(5);

		// 4. Get agent name, logo and number
		String agentName = resultChild.getAgentName();
		String agentLogo = resultChild.getAgentLogo();
		String agentNum = resultChild.getAgentNum();

		Assert.assertNotNull(agentName);
		Assert.assertNotNull(agentLogo);
		Assert.assertNotNull(agentNum);

		// 5. click agent name
		agent = resultChild.goToAgentPage();

		// 6. check that the the properties listed there belong to the same mentioned
		// agent on the page.
		String agentName2 = agent.getAgentName();
		String agentLogo2 = agent.getAgentLogo();

		Assert.assertEquals(agentName, agentName2);
		Assert.assertEquals(agentLogo, agentLogo2);
	}

	@AfterMethod
	public void tearDown() {

	}
}
