package au.foxsports.com.test;

import au.foxsports.com.pages.FoxSportsHomePage;
import au.foxsports.com.util.GeneralUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class FoxSportHomePageTest extends FoxSportsBaseTest {
    FoxSportsHomePage homePage;

    @BeforeMethod
    public void init() throws IOException {
        setUp();
        homePage = new FoxSportsHomePage();
    }

    @Test()
    public void navigateToLatestNewsPageShouldSucceed() throws InterruptedException {
        GeneralUtil.implicitWait();
        homePage.getLatestNewsPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
