package project02.healthcare;

import project02.pageObject.broker.Reusables;
import utils.*;
import utils.logging.LogUtils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test Suite containing Tests using POM Model
 */
public class Feature002 extends BaseTest {

	Reusables brokerReusableObj;

	@BeforeTest
	public void setUp1() {

		LogUtils.info("BeforeTest Method of TestClass02");

		brokerReusableObj = new Reusables(webDriverPool.get());

	}

	@Test(description = "Broker Logs In")
	public void TC002a() {

		brokerReusableObj.loginBroker();

	}

	@Test(dependsOnMethods = "TC002a", description = "Add Employer")
	public void TC002b() {

		brokerReusableObj.addEmployer();

	}

	@Test(dependsOnMethods = "TC002b", description = "Create Package")
	public void TC002c() {

		brokerReusableObj.createPackage();

	}

	@AfterTest
	public void tearDown() {

		// webDriverObj.quit();

	}

}