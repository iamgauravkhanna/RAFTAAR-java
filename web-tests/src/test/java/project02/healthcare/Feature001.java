package project02.healthcare;

import project02.pageObject.broker.Reusables;
import utils.*;
import utils.logging.LogUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Suite containing Tests using POM Model
 * 
 * @author Gaurav.Khanna
 * 
 */
public class Feature001 extends BaseTest {

	Reusables brokerReusableObj;

	@BeforeMethod
	public void beforeStartingTestMethod() {

		LogUtils.info("============ beforeStartingTestMethod() begins ============");

		brokerReusableObj = new Reusables(webDriverPool.get());

		LogUtils.info("============ beforeStartingTestMethod() ends ============");

	}

	@Test(description = "Test Case 001")
	public void TC001() {

		TestDataWriter.getInstance().putAllKeys(testDataMap);

		brokerReusableObj.loginBroker();
		
		brokerReusableObj.addEmployer();

		brokerReusableObj.createPackage();

		testDataMap.putAll(TestDataWriter.getInstance().getDataDictionary());

	}

}	