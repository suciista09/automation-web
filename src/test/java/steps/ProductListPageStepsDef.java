package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartForm;
import pages.HeaderMenu;
import pages.ProductListPage;
import webdriver.WebDriverSetup;

public class ProductListPageStepsDef {
    ProductListPage productListPage = new ProductListPage(WebDriverSetup.driver, WebDriverSetup.wait);
    HeaderMenu headerMenu = new HeaderMenu(WebDriverSetup.driver);
    CartForm cartMenu = new CartForm(WebDriverSetup.driver, WebDriverSetup.wait);

    @And("user added product into cart from product list {string}")
    public void userAddedProductIntoCartFromProductList(String arg0) {
        headerMenu.goToCategories(arg0);
        Assert.assertTrue("User is not in " + arg0 + " product list page. ", productListPage.isInproductList(arg0));
        productListPage.userAddToCart(1);
    }

    @And("user are in product list page {string}")
    public void userAreInProductListPage(String arg0) {
        headerMenu.goToCategories(arg0);
    }

    @When("user sort product by {string}")
    public void userSortProductBy(String arg0) {
        String value = productListPage.getValueofSort(arg0);

        productListPage.selectSortByValue(value);
        productListPage.waituntilLoadingDisappear();
    }

    @Then("user verified that products are sorted by lowest price")
    public void userVerifiedThatProductsAreSortedByLowestPrice() {
        Assert.assertTrue("products are not sorted by lowest price", productListPage.isPriceSortByLowest());
    }
}
