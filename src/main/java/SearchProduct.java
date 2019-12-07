import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct extends BaseSelenium
{

   public SearchProduct(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * This method is used to search product on the bases of search content.
     * @param lookingFor item to be search.
     * @throws InterruptedException
     */
    public void searchProduct(String lookingFor) throws InterruptedException
    {
        if (isDisplayed(By.xpath(".//*[@class='_2ISNhP _3AOFWO']//*[@class='_2AkmmA _29YdH8']")))
        {
            click(By.xpath(".//*[@class='_2ISNhP _3AOFWO']//*[@class='_2AkmmA _29YdH8']"));
        }

        By xpath = By.xpath("//input[@placeholder='Search for products, brands and more']");
        sendKeys(xpath, lookingFor);
        click(By.xpath(".//button[@class='vh79eN' and @type='submit']"));
    }

    /**
     * This method will give you the title of the page.
     * @return title of the page.
     */
    public String verifyTitle()
    {
        return getPageTitle();
    }

    /**
     * This method will help you to search product on the bases of filter.
     * @param productBrand product brand name.
     * @param productPriceRange product price range.
     */
    public PlaceOrder selectProduct(String productBrand, String productPriceRange)
    {
        selectBrand(productBrand);
        selectPriceRange(productPriceRange);
       return PageFactory.initElements(driver,PlaceOrder.class);
    }

    /**
     * This method will help you to click on checkbox for brand mention
     * @param brand name of the brand.
     */
    private void selectBrand(String brand)
    {
        try
        {
            By brandID = By.xpath(".//*[@class='_36jUgy']/div[@title='" + brand + "']");
            click(brandID);
        } catch (Exception e)
        {
            System.out.println("brands [" + brand + "] are not clicked. please check it again...");
            e.printStackTrace();
        }
    }

    /**
     * This method will help you to click on value for range mention
     * @param range name of the range.
     */
    private void selectPriceRange(String range)
    {
        try
        {
            By priceRange = By.xpath("//div[@class='_1YoBfV']//select[@class='fPjUPw']");
            selectBy(priceRange, range);

        } catch (Exception e)
        {
            System.out.println("Price Range [" + range + "] are not clicked. please check it again...");
            e.printStackTrace();
        }
    }
}
