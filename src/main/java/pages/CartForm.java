package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartForm {
    RemoteWebDriver driver;
    WebDriverWait wait;

    public CartForm(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isAddToCartSuccess(){
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElementById("layer_cart")));

        return driver.findElementById("layer_cart").isDisplayed() &&
                driver.findElementByCssSelector("div.layer_cart_product h2").getText().equals("Product successfully added to your shopping cart");
    }

    public void clickProceedToCheckout(){
        driver.findElementByCssSelector("a[title=\"Proceed to checkout\"]").click();
    }
}
