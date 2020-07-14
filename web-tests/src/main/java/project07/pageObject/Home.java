package project07.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;

public class Home extends BasePage {

	public static final String HOME_URL = "https://opensource-demo.orangehrmlive.com/";

	public Home(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void openHomePage() {

		openBrowser(Home.HOME_URL);

	}

}