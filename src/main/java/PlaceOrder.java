import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrder extends SearchProduct
{

    public PlaceOrder(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * This method will help you to click on buynow button of the item.
     * @param size size of the item you want.
     * @throws InterruptedException
     */
    public void clickForFirstItem(String size) throws InterruptedException
    {
        if (isDisplayed(By.xpath(".//*[@class='bhgxx2 col-12-12']//*[@class='_3O0U0u']/div[1]")))
        {
            click(By.xpath(".//*[@class='bhgxx2 col-12-12']//*[@class='_3O0U0u']/div[1]"));
        }

        switchWindow(1);
        selectSize(size);

        By buynow = By.xpath("//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c' and text()='BUY NOW']");
        click(buynow);
    }

    /**
     * This method will make sure the user is not logged-in.
     * @return true if user is not logged-in.
     */
    public boolean isLoginReqired()
    {
        return isDisplayed(By.xpath("//span[contains(text(),'Login or Signup')]"));
    }

    /**
     * This method will select the shoes size.
     * @param productSize no of size of shoes.
     * @throws InterruptedException
     */
    private void selectSize(String productSize) throws InterruptedException
    {
        By size = By.xpath("//a[@class='_1TJldG _2I_hq9 _2UBURg'][contains(text(),'" + productSize + "')]");
        click(size);
    }

}
