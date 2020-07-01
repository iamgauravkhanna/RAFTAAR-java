package project01.automationpractice.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;
import utils.logging.LogUtils;

public class Home extends BasePage {

	public static final String HOME_URL = "http://automationpractice.com";

	public Home(WebDriver driverObj) {

		System.out.println("Webdriver Object in Home Page : " + driverObj);

		webDriverObj = driverObj;

	}

	public void openHomePage() {

		LogUtils.logStep("Opening Home Page. URL : " + HOME_URL);
		
		openBrowser(HOME_URL);
		

	}

	public void clickContactUs() {
		
		LogUtils.logStep("Click on Contact Us Link");

		click(By.xpath("//a[text()='Contact us']"));

	}

}