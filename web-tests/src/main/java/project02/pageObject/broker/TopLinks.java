package project02.pageObject.broker;

import utils.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopLinks extends BasePage {

	public final static By CLIENTS_TAB = By.xpath("//a[text()='Clients']");

	public TopLinks(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void clickClientsTab() {

		waitForPageLoaded();

		click(CLIENTS_TAB);

		click(CLIENTS_TAB);

	}
}