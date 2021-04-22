package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.ActionUtils;

public class nagwaHomePage extends PageBase
{
    WebDriver driver;

    public nagwaHomePage(WebDriver driver)

    {
        super(driver);
        this.driver = driver;
        Jse = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "/html/body/header/div[1]/div/div[3]/button/i")
    WebElement searchText;

    @FindBy(id = "txt_search_query")
    WebElement insertAdditionText;

    @FindBy(xpath = "//*[@id=\"btn_global_search\"]/i")
    WebElement ClickOnSearch;

    @FindBy(xpath = "/html//div[@class='globalWrapper']/div/div[@class='wrapper']//ul[@class='list']//a[@href='https://www.nagwa.com/en/lessons/618167584392/']")
    WebElement clickOnPropertiesAddition;

    @FindBy(xpath = "/html/body/div/div/div/div/aside/div/ul/li[2]/div/a")
    WebElement clickOnLessonWorksheet;

    public void nagwaLesson (String addition) throws InterruptedException
{

    ActionUtils.clickOnElement(driver,searchText);
    ActionUtils.fillElement(driver,insertAdditionText,addition);
    Thread.sleep(2000);
    ActionUtils.clickOnElement(driver,ClickOnSearch);
    Thread.sleep(3000);
    ActionUtils.clickOnElement(driver,clickOnPropertiesAddition);
    ActionUtils.clickOnElement(driver,clickOnLessonWorksheet);

        boolean result  = ActionUtils.verifyPageOpened(driver,clickOnPropertiesAddition,60);
        if(result) {
            ActionUtils.clickOnElement(driver, clickOnPropertiesAddition);
        }
        else
        {
            System.out.println("Time OUT!!!!");
            Assert.assertFalse(result);

        }

}


}
