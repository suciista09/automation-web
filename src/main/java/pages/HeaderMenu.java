package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

public class HeaderMenu {
    RemoteWebDriver driver;

    public HeaderMenu(RemoteWebDriver driver){
        this.driver = driver;
    }

    public void clickSignIn(){
        driver.findElementByCssSelector(".login").click();
    }

    public boolean isLoggedInUser(){
        return driver.findElementByCssSelector(".logout").isDisplayed();
    }

    public void goToCategories(String category){
        if (category.equalsIgnoreCase("women")){
            driver.findElementByLinkText("Women").click();
        }else if (category.equalsIgnoreCase("Dresses")){
            driver.findElementByLinkText("Dresses").click();
        }else if (category.equalsIgnoreCase("T-shirts")){
            driver.findElementByLinkText("T-shirts").click();
        }else {
            throw new NullPointerException("Undefined categories");
        }
    }
}
