import Utility.Constant;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCase_01 extends BaseTest
{
    private String expectedTitle = "Shoes - Buy Products Online at Best Price in India - All Categories | Flipkart.com";
    private SearchProduct searchProduct = null;
    private PlaceOrder order = null;

    @Test(priority = 1, description = " This Test cases will search shoes & verify the search result page.")
    public void searchShoesAndValidateResultPage() throws InterruptedException
    {
        searchProduct = new SearchProduct(driver);

        Reporter.log("Searching the shoes.");
        searchProduct.searchProduct(Constant.SHOES);
        Reporter.log("the shoes searching successfully.");


        Reporter.log("verifying title of the page.");
        Assert.assertEquals(searchProduct.verifyTitle(), expectedTitle);
        Reporter.log("The title of the page verified successfully.");

        Reporter.log("Searching the product on bases of brand and price filter");
        order = searchProduct.selectProduct(Constant.BRANDS, String.valueOf(Constant.PRICE.₹1000));
        Reporter.log("the product searched successfully.");
    }

    @Test(priority = 2, description = "This Test cases will search shoes and place the order.")
    public void selectProductAndPlaceOrder() throws InterruptedException
    {
        Reporter.log("clicking on first product from search list and click on buy now button");
        order.clickForFirstItem("8");
        Reporter.log("buy now button clicked successfully.");

        Reporter.log("Verify that, login page is asked for order completion.");
        Assert.assertTrue(order.isLoginReqired());
        Reporter.log("Verified that, login page is asked for order completion successfully.");

    }

}
