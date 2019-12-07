import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BaseSelenium
{
    public WebDriver driver;

    BaseSelenium(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed(By locator)
    {
        try
        {
            highlighting(locator);
            explicitWait(locator, 30);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e)
        {
            System.out.println("locator [" + locator + "] is not displayed.");
            e.printStackTrace();
        }
        return false;
    }

    public String getPageTitle()
    {
        try
        {
            return driver.getTitle();
        } catch (Exception e)
        {
            System.out.println("Error to get page title.");
            e.printStackTrace();
        }
        return null;
    }


    public void click(By locater) throws InterruptedException
    {
        highlighting(locater);
        Thread.sleep(2000);
        driver.findElement(locater).click();
        Thread.sleep(1000);
    }

    public void sendKeys(By locater, String value) throws InterruptedException
    {
        try
        {
            highlighting(locater);
            driver.findElement(locater).sendKeys(value);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void selectBy(By locator, String value)
    {
        try
        {
            new Select(driver.findElement(locator)).selectByVisibleText(value);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void highlighting(By locators) throws InterruptedException
    {
        WebElement ele = driver.findElement(locators);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", ele);
        Thread.sleep(2000);
    }

    public void explicitWait(By locator, int seconds) throws InterruptedException
    {
        highlighting(locator);
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void switchWindow(int noOfWindows)
    {
        ArrayList<String> secTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(secTab.get(noOfWindows));
    }
}
