package au.foxsports.com.pages;

import au.foxsports.com.test.FoxSportsBaseTest;
import au.foxsports.com.util.GeneralUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FoxSportsHomePage extends FoxSportsBaseTest {
    @FindBy(css = "label.fnhmt__tb")
    WebElement leftHamburgerMenuEle;

    @FindBy(css = "li.fnhmbsi label.fnhmbsi__sl--for[for='\uD83C\uDF540\uD83D\uDCCB3\uD83D\uDCCB\uD83D\uDE2E']")
    WebElement footballLinkEle;

    @FindBy(css = "div.fnhmbl__m div.fnhmbl__sc li.fnhmbsi a.fnhmbsi__h[href='/football/latest-news'] span.fnhmbsi__d")
    WebElement latestNewsLinkEle;

    public FoxSportsHomePage() {
        PageFactory.initElements(driver, this);
    }

    public LatestFootballNewsPage getLatestNewsPage() throws InterruptedException {
        //Explicit Wait for few seconds
        GeneralUtil.waitForDomStable(leftHamburgerMenuEle);

        //click on Three Line Icon
        leftHamburgerMenuEle.click();

        //Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");

        //Click on Football Link
        footballLinkEle.click();

        //Wait for few seconds

        GeneralUtil.waitForDomStable((latestNewsLinkEle));

        //Click on Latest News link
        latestNewsLinkEle.click();

        GeneralUtil.waitForDomStable((latestNewsLinkEle));

        return new LatestFootballNewsPage();
    }

    @Override
    public String getPageTittle() {
        return driver.getTitle();
    }
}
