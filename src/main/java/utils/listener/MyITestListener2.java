package utils.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.DataDictionary;
import utils.logging.LogUtils;

public class MyITestListener2 implements ITestListener {

	private static ExtentReports extentReportsObj;

	private static ThreadLocal<ExtentTest> extentTestPoolObj = new ThreadLocal<ExtentTest>();

	public void onStart(ITestContext context) {

		extentReportsObj = ExtentManager2.getInstance();

		LogUtils.info("Extent Reports Version 3 Test Suite started!");

		// test.get().info("Extent Reports Version 3 Test Suite started!");
	}

	public void onFinish(ITestContext context) {

		LogUtils.info(("Extent Reports Version 3  Test Suite is ending!"));

		extentTestPoolObj.get().info("Extent Reports Version 3  Test Suite is ending!");

		extentReportsObj.flush();

		LogUtils.info("Report Path => " + DataDictionary.getInstance().getDataDictionary().get("reportPath"));
	}

	public void onTestStart(ITestResult result) {

		LogUtils.info((result.getMethod().getMethodName() + " started!"));

		ExtentTest extentTestObj = extentReportsObj.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());

		extentTestPoolObj.set(extentTestObj);

		extentTestPoolObj.get().info((result.getMethod().getMethodName() + " started!"));

	}

	public void onTestSuccess(ITestResult result) {

		LogUtils.info((result.getMethod().getMethodName() + " passed!"));

		extentTestPoolObj.get().pass("Test passed");
	}

	public void onTestFailure(ITestResult result) {

		LogUtils.info((result.getMethod().getMethodName() + " failed!"));

		extentTestPoolObj.get().fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {

		LogUtils.info((result.getMethod().getMethodName() + " skipped!"));

		extentTestPoolObj.get().skip(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		LogUtils.info(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));

		extentTestPoolObj.get()
				.info(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));

	}

	public static ExtentTest getInstance() {

		return extentTestPoolObj.get();
	}

}