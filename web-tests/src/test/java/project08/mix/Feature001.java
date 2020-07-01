package web.project08.mix;

import org.testng.annotations.Test;

import utils.BaseTest;
import web.project08.mix.pageObject.Resuables;

public class Feature001 extends BaseTest {

	Resuables resuablesObj ;
	
	@Test(description = "Examples for WebDriver")
	public void TestMethod001() {
		
		resuablesObj = new Resuables(webDriverPool.get());
		
		resuablesObj.runTest();

	}
}