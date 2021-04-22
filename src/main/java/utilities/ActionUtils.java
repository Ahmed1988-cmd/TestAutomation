package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtils {


    // click on Element
    public static void clickOnElement (WebDriver driver, WebElement element)

    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 300);
            WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
            //element = wait.until(ExpectedConditions.visibilityOf(element));
            while (!el.isDisplayed()) {
                el = wait.until(ExpectedConditions.visibilityOf(element));
            }
            el.click();

        } catch (Exception e) {

            System.err.println(e.getMessage());
            System.err.println("Error, Could not find Clickable Element --> "+ element.getText());
        }
    }


    // Method For FillElement
    public static void fillElement(WebDriver driver, WebElement element, String text) {

        if (text != null || text.equalsIgnoreCase(""))
        {

            WebDriverWait wait = new WebDriverWait(driver, 300);
            WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
            try {
                while (!el.isDisplayed()) {
                    el = wait.until(ExpectedConditions.visibilityOf(element));
                }
                el.clear();
                el.sendKeys(text);

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error, Could not find visible element to enter text into it ");
            }
        } else {
            System.out.println("The entered Text is null or empty.");
        }
    }

    //Method for click On Element  UsingJavaScript
    public static void clickOnElementUsingJavaScript(WebDriver driver, WebElement element)

    {
        WebDriverWait wait = new WebDriverWait(driver, 300);
        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
        try {
            while (!el.isDisplayed()) {
                el = wait.until(ExpectedConditions.visibilityOf(element));
            }
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);

        } catch (Exception e) {
            System.err.println("Error, Could not find Clickable Element with JS");
        }
    }
    //instead of thread. sleep
    public static boolean verifyPageOpened(WebDriver driver, WebElement element, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
            while (!el.isDisplayed()) {
                el = wait.until(ExpectedConditions.visibilityOf(element));

            }
            return true;
        } catch (Exception e)

        {
            System.err.println("Error, Could not find TEXT");

            return false;
        }

    }

    public static void fillElement(WebDriver driver, WebElement searchText) {
    }
}
