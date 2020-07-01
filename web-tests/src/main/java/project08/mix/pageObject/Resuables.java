package web.project08.mix.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;

public class Resuables extends BasePage {

	public Resuables(WebDriver driver) {

		webDriverObj = driver;

	}

	public void runTest() {

		openBrowser("http://automationpractice.com/");
		
		waitForPageLoaded();
		
		By element = By.xpath("//a[text()='Contact us']");
		
		click(element);
		
		waitFor(element);
		
		waitFor(element, 55);
		
		closeBrowser();
		
	}

}