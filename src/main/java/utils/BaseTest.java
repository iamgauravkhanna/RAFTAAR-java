package utils;

import java.util.HashMap;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import utils.java.JavaUtil;
import utils.logging.LogUtils;

public class BaseTest {

	public WebDriver webDriverObj ;

	public HashMap<String, String> testDataMap = new HashMap<String, String>();

	private BrowserFactory browserFactoryObj;

	private String outputDirectory;
	
	public ThreadLocal<WebDriver> webDriverPool = new ThreadLocal<WebDriver>();

	public BaseTest() {

/*		System.setProperty("current.date.time", JavaUtil.getTimeStamp());

		String fileSeperator = System.getProperty("file.separator");

		outputDirectory = System.getProperty("user.dir") + fileSeperator + "test-results" + fileSeperator + "logs"
				+ fileSeperator + "test-output_" + JavaUtil.getTimeStamp() + "_" + JavaUtil.generateRandomString();

		System.setProperty("logsDirectory", outputDirectory);

		JavaUtil.createDirectory(outputDirectory);*/

		PropertyConfigurator.configure("log4j.properties");

	}

	@BeforeMethod
	public void setUp() {

		LogUtils.info("..................... setUp() begins .....................");

		TestDataWriter.getInstance().putKey("logsDirectory", outputDirectory);

		TestDataWriter.getInstance().putKey("User", "Gaurav.Khanna");

		browserFactoryObj = new BrowserFactory();

		webDriverPool.set(browserFactoryObj.getBrowser());

		testDataMap.putAll(TestDataWriter.getInstance().getDataDictionary());

		LogUtils.info("..................... setUp() ends .....................");

	}

	@AfterMethod
	public void cleanUp() {

		TestDataWriter.getInstance().putAllKeys(testDataMap);

/*		LogUtils.info("..................... Closing Browser .....................");

		webDriverPool.get().manage().deleteAllCookies();

		webDriverPool.get().quit();*/

		testDataMap.putAll(TestDataWriter.getInstance().getDataDictionary());

	}

	@AfterTest
	public void tearDown() {

		LogUtils.info("..................... All Methods in Test Are Executed .....................");

	}
	
	@AfterSuite
	public void stepsToBeDoneAfterSuite() {
		
		JavaUtil.printHashMapValues(testDataMap);
	}

}