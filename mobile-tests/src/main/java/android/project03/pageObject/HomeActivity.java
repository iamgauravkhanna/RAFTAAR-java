package project03.pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseActivity;
import utils.java.JavaUtil;

public class HomeActivity extends BaseActivity {

	public HomeActivity(AndroidDriver<AndroidElement> driverObj) {

		androidDriverObj = driverObj;
		
		JavaUtil.takeScreenShot(androidDriverObj);
	}

}