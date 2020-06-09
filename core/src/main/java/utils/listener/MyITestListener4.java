package utils.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.TestDataWriter;
import utils.logging.LogUtils;

public class MyITestListener4 implements ITestListener {


	public void onStart(ITestContext context) {

		LogUtils.info("************************ Test Suite " + context.getName() + " Started ************************");

	}

	public void onFinish(ITestContext context) {

		LogUtils.info("************************ Test Suite " + context.getName() + " Ending ************************");

		ExtentTestManager4.endTest();

		ExtentManager4.getInstance().flush();

		TestDataWriter.getInstance().putKey("Report Link", ExtentManager4.getReportLink());
	}

	public void onTestStart(ITestResult result) {

		LogUtils.info(("*** Running Test Method " + result.getMethod().getMethodName() + "..."));

		LogUtils.startTestCase(result.getMethod().getMethodName());

		ExtentTestManager4.startTest(result.getMethod().getMethodName());
		
		TestDataWriter.getInstance().putKey("testcaseid", result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		LogUtils.info("*** Executed " + result.getMethod().getMethodName() + " test successfully...");

		LogUtils.endTestCase(result.getMethod().getMethodName());

		ExtentTestManager4.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {

		LogUtils.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");

		ExtentTestManager4.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestSkipped(ITestResult result) {

		LogUtils.info("*** Test " + result.getMethod().getMethodName() + " skipped...");

		ExtentTestManager4.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		LogUtils.info("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	public static ExtentTest getInstance() {

		return ExtentTestManager4.getTest();
	}

}