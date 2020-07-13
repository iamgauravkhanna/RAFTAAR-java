package utils.listener;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.java.JavaUtil;

public class ExtentManager {

	private static ExtentReports extent;

	private static String reportFileName = "Test-Automaton-Report-" + JavaUtil.getCurrentTimeStamp() + ".html";

	private static String fileSeperator = System.getProperty("file.separator");	

	/*
	 * private static String reportFilepath = System.getProperty("user.dir") +
	 * fileSeperator + "test-results" + fileSeperator ;
	 */

	private static String reportFilepath = System.getProperty("logsDirectory") + fileSeperator;

	private static String reportFileLocation = reportFilepath + fileSeperator + reportFileName;

	private static KlovReporter klov = new KlovReporter();

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {
		
		System.out.println("Report File Path : " + reportFilepath);

		//String fileName = getReportPath(reportFilepath);

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFileLocation);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Raftaar 4.0");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Raftaar 4.0");
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		extent = new ExtentReports();

		// specify mongoDb connection
		klov.initMongoDbConnection("localhost", 27017);

		// specify project
		// ! you must specify a project, other a "Default project will be used"
		klov.setProjectName("Raftaar 4.0");

		// you must specify a reportName otherwise a default timestamp will be used
		klov.setReportName(JavaUtil.getCurrentTimeStamp());

		// URL of the KLOV server
		// you must specify the served URL to ensure all your runtime media is uploaded
		// to the server
		klov.setKlovUrl("http://localhost:8005/");

		extent.attachReporter(htmlReporter, klov);

		// extent.attachReporter(htmlReporter);

		// Set environment details
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("AUT", "QA");

		//LogUtils.info(fileName);

		return extent;
	}

	// Create the report path
	public static String getReportPath(String path) {
		
		File testDirectory = new File(path);
		
		if (!testDirectory.exists()) {
		
			if (testDirectory.mkdir()) {
			
				System.out.println("Directory: " + path + " is created!");
				
				return reportFileLocation;
			
			} else {
			
				System.out.println("Failed to create directory: " + path);
				
				return System.getProperty("user.dir");
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
		return reportFileLocation;
	}

	public static String getReportLink() {

		return reportFileLocation;

	}
	
}