package project04.newtours;

import org.testng.annotations.Test;
import project04.pageObject.Home;
import utils.BaseTest;

public class Feature001 extends BaseTest {

    @Test
    public void TestMethod001() {

        Home home = new Home(webDriverPool.get());

        home.openHomePage();

        home.clickContactUs();

    }
}