package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CheckoutPage;
import webdriver.WebDriverSetup;

public class CheckoutPageStepsDef {
    CheckoutPage checkoutPage = new CheckoutPage(WebDriverSetup.driver);

    @And("user completed checkout process using payment {string}")
    public void userCompletedCheckoutProcessUsingPayment(String arg0) {
        Assert.assertTrue("User is not on summary section. ", checkoutPage.isInSummarySection());
        checkoutPage.clickCheckOutProcess();
        Assert.assertTrue("User is not on address section. ", checkoutPage.isInAddressSection());
        //checkoutPage.clickCheckOutProcess();
        checkoutPage.clickCheckOutProcessOnAddressSection();
        Assert.assertTrue("User is not on shipping section", checkoutPage.isInShippingSection());
        checkoutPage.clickTermOfService();
        checkoutPage.clickCheckoutProcessOnShippingSection();
        Assert.assertTrue("User is not on payment section. ", checkoutPage.isInPaymentSection());

        if (arg0.equalsIgnoreCase("Bank-Wire Payment")){
            checkoutPage.chooseBankWire();
        }else {
            throw new NullPointerException("can not find payment method: " + arg0);
        }
    }

    @Then("user verify order is confirmed")
    public void userVerifyOrderIsConfirmedUsing() {
        Assert.assertTrue("User is not on order confirmation page. ", checkoutPage.isInOrderConfirmation());
    }
}
