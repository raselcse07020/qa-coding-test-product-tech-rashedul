package au.foxsports.com.test;

import au.foxsports.com.basepage.FoxSportsBasePage;
import au.foxsports.com.util.GeneralUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class FoxSportsBaseTest extends FoxSportsBasePage {
    public Properties properties;
    public String projectDir = System.getProperty("user.dir");
    public FileInputStream inputStream;
    public String browserName;

    public WebDriver getWebDriver() {
        return driver;
    }

    public FoxSportsBaseTest() {
    }

    public FoxSportsBaseTest(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setUp() throws IOException {
        //Get properties File
        String configFilePath = projectDir + "/src/test/resources/config.properties";
        properties = new Properties();

        //Load Properties File
        try {
            inputStream = new FileInputStream(configFilePath);

            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Configuration properties file is not found");
        }

        //Get data from properties file
        browserName = properties.getProperty("browserName");

        if (browserName.equals("firefox")) {
            //initializing and starting the firefox browser
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            GeneralUtil.implicitWait();

        } else if (browserName.equals("chrome")) {
            //initializing and starting the chrome browser
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            GeneralUtil.implicitWait();
        } else if (browserName.equals("firefoxBrowserHeadless")) {
            //initializing and starting the chrome browser with Headless Mode
            WebDriverManager.firefoxdriver().setup();
            //create object of firefox options
            FirefoxOptions options = new FirefoxOptions();
            //add the headless argument
            options.addArguments("--headless");

            //pass the options parameter in the firefox driver declaration
            driver = new FirefoxDriver(options);

        } else if (browserName.equals("chromeBrowserHeadless")) {
            //initializing and starting the chrome browser with Headless Mode
            WebDriverManager.chromedriver().setup();
            //create object of chrome options
            ChromeOptions options = new ChromeOptions();
            //add the headless argument
            options.addArguments("--headless");

            //pass the options parameter in the Chrome driver declaration
            driver = new ChromeDriver(options);
        } else {
            System.out.println("Browser not found");
        }

        // driver.get("https://www.foxsports.com.au");
        String url = properties.getProperty("applicationUrl");
        driver.get(url);
        GeneralUtil.implicitWait();

        driver.navigate().refresh();

    }

    @Override
    public String getPageTittle() {
        return driver.getTitle();
    }

}
