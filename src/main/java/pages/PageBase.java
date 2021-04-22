package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase

{

    public JavascriptExecutor Jse;
    public Select select;



    //Create Constructor
    public PageBase (WebDriver driver)

    {
        PageFactory.initElements(driver,this);
    }


    protected static void ClickOn (WebElement button)
    {
        button.click();
    }


    protected static void FillElement (WebElement Element , String Value )
    {
        Element.sendKeys(Value);
    }


    //Method For ScrollDown
    public void ScrollDown()
    {
        Jse.executeScript("scrollBy(0,500)");
    }

    //Method For ScrollUP
    public void ScrollUP()
    {
        Jse.executeScript("scrollBy(0,-400)");
    }

    //Method For Clear Element
    public void clearTXT ( WebElement element)
    {
        element.clear();
    }

}
