package au.foxsports.com.test;

import au.foxsports.com.pages.FoxSportsHomePage;
import au.foxsports.com.pages.LatestFootballNewsPage;
import au.foxsports.com.util.GeneralUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class LatestFootballNewsPageTest extends FoxSportsBaseTest {
    FoxSportsHomePage homePage;
    LatestFootballNewsPage latestFootballNewsPage;

    @BeforeMethod
    public void init() throws IOException, InterruptedException {
        setUp();
        homePage = new FoxSportsHomePage();
        latestFootballNewsPage = homePage.getLatestNewsPage();
        latestFootballNewsPage = latestFootballNewsPage.validateLatestNewsPageTitle();
    }

    @Test()
    public void latestNewsPageTitleShouldSucceed() throws InterruptedException {
        GeneralUtil.implicitWait();
        latestFootballNewsPage.validateLatestNewsPageTitle();
    }

    @Test(enabled = true)
    public void latestFootballNewsTitleShouldSucceed() throws InterruptedException {
        GeneralUtil.implicitWait();
        latestFootballNewsPage.validateLatestFootballNewsArticleTitle();
    }

    @Test(enabled = true)
    public void latestFootballNewsPageDescriptionShouldSucceed() throws InterruptedException {
        GeneralUtil.implicitWait();
        latestFootballNewsPage.validateLatestFootballNewsPageDescription();
    }

    @Test(enabled = true)
    public void heroImageIsPresentShouldSucceed() throws InterruptedException {
        GeneralUtil.implicitWait();
        latestFootballNewsPage.hasHeroImage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
