package utils.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.TestDataWriter;
import utils.java.JavaUtil;
import utils.logging.LogUtils;

public class ExtentManager2 {

	private static ExtentReports extentReportsObj;

	private static KlovReporter klovReporterObj = new KlovReporter();

	public static ExtentReports getInstance() {

		if (extentReportsObj == null)

		{
			LogUtils.info(TestDataWriter.getInstance().getDataDictionary().get("logsDirectory"));
			
			String reportLink = TestDataWriter.getInstance().getDataDictionary().get("logsDirectory") + "\\" + JavaUtil.generateRandomNumber(10) + ".html" ;

			TestDataWriter.getInstance().getDataDictionary().put("reportPath", reportLink);
			
			createInstance(reportLink);
			
			LogUtils.info(".............. Extent Report Instance ..............");

		}

		return extentReportsObj;
	}

	public static ExtentReports createInstance(String fileName) {

		ExtentHtmlReporter extenthtmlReporterObj = new ExtentHtmlReporter(fileName);

		extenthtmlReporterObj.config().setTestViewChartLocation(ChartLocation.BOTTOM);

		extenthtmlReporterObj.config().setChartVisibilityOnOpen(true);

		extenthtmlReporterObj.config().setTheme(Theme.STANDARD);
		
		String ReportTitle = "Report #" + JavaUtil.getCurrentTimeStamp() ;

		extenthtmlReporterObj.config().setDocumentTitle(ReportTitle);

		extenthtmlReporterObj.config().setEncoding("utf-8");

		extenthtmlReporterObj.config().setReportName(ReportTitle);

		extentReportsObj = new ExtentReports();

		// specify mongoDb connection
		klovReporterObj.initMongoDbConnection("localhost", 27017);

		// specify project
		// ! you must specify a project, other a "Default project will be used"
		klovReporterObj.setProjectName("RAFTAAR v4.0");

		// you must specify a reportName otherwise a default timestamp will be used
		klovReporterObj.setReportName(JavaUtil.getCurrentTimeStamp());

		// URL of the KLOV server
		// you must specify the served URL to ensure all your runtime media is uploaded
		// to the server
		klovReporterObj.setKlovUrl("http://localhost:8005/");

		extentReportsObj.attachReporter(extenthtmlReporterObj, klovReporterObj);

		return extentReportsObj;
	}
}