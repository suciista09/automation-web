package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthenticationPage {
    RemoteWebDriver driver;

    public AuthenticationPage(RemoteWebDriver driver){
        this.driver = driver;
    }

    public boolean isInAuthPage(){
        return driver.getTitle().equalsIgnoreCase("Login - My Store") &&
                driver.findElementById("create-account_form").isDisplayed() &&
                driver.findElementById("login_form").isDisplayed();
    }

    public void typeEmail(String email){
        driver.findElementById("email").sendKeys(email);
    }

    public void typePassword(String password){
        driver.findElementById("passwd").sendKeys(password);
    }

    public void clickSignInButton(){
        driver.findElementById("SubmitLogin").click();
    }

    public void login(String email, String password){
        typeEmail(email);
        typePassword(password);
        clickSignInButton();
    }

}
