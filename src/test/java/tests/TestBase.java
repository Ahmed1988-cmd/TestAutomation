
package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class TestBase

{

    public static WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void startdriver (@Optional("chrome") String browserName)
    {
        if (browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println(driver+"Start Testing  ChromeDriver");


        }
        else if (browserName.equalsIgnoreCase("chrome-headless"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1800");
            driver = new ChromeDriver(options);
        }

        else if (browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        driver.get("https://www.nagwa.com/en/");

        Alert alert = driver.switchTo().alert();

    }

    @AfterMethod
    public void StopDriver()
    {
        driver.close();
    }


}
