package au.foxsports.com.util;

import au.foxsports.com.test.FoxSportsBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GeneralUtil extends FoxSportsBaseTest {
    public static final int IMPLICIT_WAIT = 10;

    public static WebDriver.Timeouts implicitWait() {
        return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtil.IMPLICIT_WAIT));
    }

    public static WebElement waitForElementVisibility(By by) {
        WebDriverWait waitForElementEleStable = new WebDriverWait(driver, Duration.ofSeconds(10));
        return waitForElementEleStable.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitForElementClickable(By by) {
        WebDriverWait waitForElementEleStable = new WebDriverWait(driver, Duration.ofSeconds(10));
        return waitForElementEleStable.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForDomStable(WebElement latestNewsLinkEle) throws InterruptedException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForLongTime() throws InterruptedException {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
