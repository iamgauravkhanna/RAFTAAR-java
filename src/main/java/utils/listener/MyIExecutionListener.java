package utils.listener;

import org.testng.IExecutionListener;

import utils.logging.LogUtils;

public class MyIExecutionListener implements IExecutionListener {

	private long startTime;

	@Override
	public void onExecutionStart() {
		startTime = System.currentTimeMillis();
		LogUtils.info("TestNG is going to start");
	}

	@Override
	public void onExecutionFinish() {
		LogUtils.info("TestNG has finished, took around " + (System.currentTimeMillis() - startTime) + "ms");
	}

}