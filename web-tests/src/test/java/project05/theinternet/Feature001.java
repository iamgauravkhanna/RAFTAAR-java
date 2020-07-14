package project05.theinternet;

import org.testng.annotations.Test;
import project05.pageObject.Home;
import utils.BaseTest;

public class Feature001 extends BaseTest {

    @Test
    public void TestMethod001() {

        Home home = new Home(webDriverPool.get());

        home.openHomePage();

    }
}