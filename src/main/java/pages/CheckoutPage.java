package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

public class CheckoutPage {
    RemoteWebDriver driver;

    public CheckoutPage(RemoteWebDriver driver){
        this.driver = driver;
    }

    public void clickCheckOutProcess(){
        driver.findElementByCssSelector("p.cart_navigation a[title=\"Proceed to checkout\"]").click();
    }

    public boolean isInSummarySection(){
        return driver.findElementByCssSelector(".step_current.first").isDisplayed();
    }

    public boolean isInAddressSection(){
        return driver.findElementByCssSelector(".step_current.third").isDisplayed();
    }

    public boolean isInShippingSection(){
        return driver.findElementByCssSelector(".step_current.four").isDisplayed();
    }

    public boolean isInPaymentSection(){
        return driver.findElementByCssSelector(".step_current.last").isDisplayed();
    }

    public void clickTermOfService(){
        driver.findElementById("cgv").click();
    }

    public void chooseBankWire(){
        driver.findElementByCssSelector("#HOOK_PAYMENT a.bankwire").click();

        if (!driver.findElementByCssSelector("#module-bankwire-payment div#center_column form h3")
                .getText().equalsIgnoreCase("BANK-WIRE PAYMENT.")){
            throw  new NullPointerException("The Page Section is not on Bank Wire Payment");
        }

        driver.findElementByCssSelector("p.cart_navigation button[type=\"submit\"]").click();
    }

    public boolean isInOrderConfirmation(){
        return driver.findElementByCssSelector("h1.page-heading").getText()
                .equalsIgnoreCase("ORDER CONFIRMATION");
    }

    public void clickCheckOutProcessOnAddressSection() {
        driver.findElementByCssSelector("button[name=\"processAddress\"]").click();
    }

    public void clickCheckoutProcessOnShippingSection(){
        driver.findElementByCssSelector("button[name=\"processCarrier\"]").click();
    }

    public float getShippingCost(){
        String cost_ = driver.findElementById("total_shipping").getText();
        String cost_tmp = cost_.replace("$", "");

        return Float.parseFloat(cost_tmp);
    }

    public float getTaxes(){
        String cost_ = driver.findElementById("total_tax").getText();
        String cost_tmp = cost_.replace("$", "");

        return Float.parseFloat(cost_tmp);
    }
}
