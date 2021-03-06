package project01.automationpractice;

import org.testng.annotations.Test;

import utils.BaseTest;
import project01.pageObject.Home;
import utils.TestDataWriter;

/**
 * 
 * Test Scripts using POM Model
 * 
 */
public class Feature001 extends BaseTest {

	@Test
	public void TC_001() {

		System.out.println( "WebDriverPool Details : " + webDriverPool.get().toString());

		Home homePageObj = new Home(webDriverPool.get());

		homePageObj.openHomePage();
		
		homePageObj.clickContactUs();
		
		TestDataWriter.getInstance().getDataDictionary().put("TC_ID", "001");

	}

	@Test
	public void TC_002() {

		System.out.println( "WebDriverPool Details : " + webDriverPool.get().toString());

		Home homePageObj = new Home(webDriverPool.get());

		homePageObj.openHomePage();

		homePageObj.clickContactUs();

		TestDataWriter.getInstance().getDataDictionary().put("TC_ID", "001");

	}

	@Test
	public void TC_003() {

		System.out.println( "WebDriverPool Details : " + webDriverPool.get().toString());

		Home homePageObj = new Home(webDriverPool.get());

		homePageObj.openHomePage();

		homePageObj.clickContactUs();

		TestDataWriter.getInstance().getDataDictionary().put("TC_ID", "001");

	}

}