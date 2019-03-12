package web.project03.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;
import utils.logging.LogUtils;

public class HomePage extends BasePage {

	By homeFrontEndText = By.xpath("//*[contains(text(),'Front-End')]");

	By AdminLink = By.xpath("//*[contains(text(),'http://www.phptravels.net/admin')]");
	
	By PopUpNoThanksText = By.xpath("//button[@id=\"onesignal-popover-cancel-button\"]");

	public HomePage(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void verifyHomeFrontEndPresent() {

		assertPresent(homeFrontEndText);

	}

	public void openBrowser() {
		
		LogUtils.logStep("Opening Browser");

		openBrowser("http://phptravels.com/demo/");

	}

	public void clickAdminLink() {

		click(AdminLink);

	}

	public void switchToAdminPage() {

		// switchToWindow("Administator Login");

	}
	
	public void closePopUpMenus() {
		
		click(PopUpNoThanksText);
		click(By.xpath("//div[@class='mc-closeModal']"));
	}

}
