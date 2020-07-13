package utils.listener;

import java.io.File;

import org.testng.IExecutionListener;

import utils.java.JavaUtil;
import utils.logging.LogUtils;

public class IExecutionListenerImpl implements IExecutionListener {

	private long startTime;

	public void onExecutionStart() {

		startTime = System.currentTimeMillis();

		System.setProperty("current.date.time", JavaUtil.getTimeStamp());

		String outputDirectory = System.getProperty("user.dir") + File.separator + "test-results" + File.separator
				+ "test-output_" + JavaUtil.getTimeStamp() + "_" + JavaUtil.generateRandomString();

		System.setProperty("logsDirectory", outputDirectory);

		System.setProperty("EnvironmentFilePath", "environment01.properties") ;

		JavaUtil.createDirectory(outputDirectory);

		LogUtils.info(
				".......................... TestNG is going to start. Let the game begins ..........................");

	}

	public void onExecutionFinish() {

		LogUtils.info(".......................... TestNG has finished, took around "
				+ (System.currentTimeMillis() - startTime) + " ..........................");

	}

}