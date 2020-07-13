package utils.listener;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import utils.TestDataWriter;
import utils.logging.LogUtils;

import utils.listener.* ;

public class ITestListenerImpl implements ITestListener {

	public void onStart(ITestContext context) {

		LogUtils.info("************************ Test Suite " + context.getName() + " Started ************************");

	}

	public void onFinish(ITestContext context) {

		LogUtils.info("************************ Test Suite " + context.getName() + " Finished ************************");

		ExtentTestManager.endTest();

//		ExtentManager.getInstance().flush();

		TestDataWriter.getInstance().putKey("Report Link", ExtentManager.getReportLink());
	}

	public void onTestStart(ITestResult result) {

		LogUtils.info(("*** Running Test Method " + result.getMethod().getMethodName() + "..."));

		LogUtils.startTestCase(result.getMethod().getMethodName());

//		ExtentTestManager.startTest(result.getMethod().getMethodName());
		
		TestDataWriter.getInstance().putKey("testcaseid", result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		LogUtils.info("*** Executed " + result.getMethod().getMethodName() + " test successfully...");

		LogUtils.endTestCase(result.getMethod().getMethodName());

//		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {

		LogUtils.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");

//		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestSkipped(ITestResult result) {

		LogUtils.info("*** Test " + result.getMethod().getMethodName() + " skipped...");

//		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		LogUtils.info("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	public static ExtentTest getInstance() {

		return ExtentTestManager.getTest();
	}

}