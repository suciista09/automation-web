package steps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartForm;
import webdriver.WebDriverSetup;

public class CartFormStepsDef {
    CartForm cartForm = new CartForm(WebDriverSetup.driver, WebDriverSetup.wait);

    @When("user proceed to checkout from cart form")
    public void userProceedToCheckoutFromCartForm() {
        Assert.assertTrue("User add to cart failed", cartForm.isAddToCartSuccess());
        cartForm.clickProceedToCheckout();
    }
}
