package project03.phptravels;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utils.BaseTest;
import project03.pageObject.AdminPage;
import project03.pageObject.DashBoardPage;
import project03.pageObject.HomePage;

public class Feature001 extends BaseTest {

	WebDriver webDriverObj;
	HomePage homePageObj;
	AdminPage adminPageObj;
	DashBoardPage dashBoardObj;

	@Test
	public void TestMethod001() {

		homePageObj = new HomePage(webDriverPool.get());

		adminPageObj = new AdminPage(webDriverPool.get());

		dashBoardObj = new DashBoardPage(webDriverPool.get());

		homePageObj.openBrowser();
		
		//homePageObj.closePopUpMenus();

		homePageObj.verifyHomeFrontEndPresent();

		homePageObj.clickAdminLink();

		homePageObj.switchToAdminPage();

		adminPageObj.login();

		dashBoardObj.validateHomeTiles();
		
		// TestDataWriter.getInstance().getDataDictionary().put("TC_ID", "001");

	}
}