package au.foxsports.com.pages;

import au.foxsports.com.test.FoxSportsBaseTest;
import au.foxsports.com.util.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LatestFootballNewsPage extends FoxSportsBaseTest {
    @FindBy(css = "//*[contains(text(),'LATEST FOOTBALL NEWS')]")
    WebElement latestFootballNewsTitleEle;

    @FindBy(css = "a.article-snippet__header-link[href$='/news-story/de6104aa57b3ddaf45524bf3aaa34b9c']")
    WebElement descriptionTextEle;

    @FindBy(css = "img[src*='/04a5f1ba511a61768131b061f3a5f138?']")
    WebElement heroImageEle;

    public LatestFootballNewsPage() {
        PageFactory.initElements(driver, this);
    }

    public LatestFootballNewsPage validateLatestNewsPageTitle() throws InterruptedException {

        String actualLatestNewsPageTitle = driver.getTitle();
        String expectedLatestNewsPageTitle = getPageTittle();
        Assert.assertEquals(actualLatestNewsPageTitle, expectedLatestNewsPageTitle);

        return new LatestFootballNewsPage();
    }

    public LatestFootballNewsPage validateLatestFootballNewsArticleTitle() throws InterruptedException {

        //Verify LATEST FOOTBALL NEWS Title
        GeneralUtil.waitForDomStable((latestFootballNewsTitleEle));
        String latestFootballNewsTitle = driver.findElement(By.cssSelector("//*[contains(text(),'LATEST FOOTBALL NEWS')]")).getText();

        try {
            if (latestFootballNewsTitle == "LATEST FOOTBALL NEWS") {
                Assert.assertTrue(Boolean.parseBoolean(latestFootballNewsTitle));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return new LatestFootballNewsPage();
    }

    public LatestFootballNewsPage validateLatestFootballNewsPageDescription() throws InterruptedException {

        //Verify Description text
        String descriptionTextVerify = descriptionTextEle.getText();
        try {
            if (descriptionTextVerify.contains("‘I’m just the frontman’")) {
                Assert.assertTrue(Boolean.parseBoolean(descriptionTextVerify));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new LatestFootballNewsPage();
    }

    public LatestFootballNewsPage hasHeroImage() throws InterruptedException {

        //Get Hero Image
        WebElement heroImage = heroImageEle;
        try {
            if ((heroImage).isDisplayed()) {
                System.out.println("This is Hero Image");
            }
        } catch (Exception e) {
            System.out.println("Hero Image is not found" + e);
        }
        return new LatestFootballNewsPage();
    }

    @Override
    public String getPageTittle() {
        return "Latest Football News | FOX SPORTS";
    }

}
