package steps;

import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.AuthenticationPage;
import pages.HeaderMenu;
import webdriver.WebDriverSetup;

public class AuthPageStepsDef {
    AuthenticationPage authenticationPage = new AuthenticationPage(WebDriverSetup.driver);
    HeaderMenu headerMenu = new HeaderMenu(WebDriverSetup.driver);

    @And("user logged in into system")
    public void userLoggedInIntoSystem() {
        headerMenu.clickSignIn();
        Assert.assertTrue("User is not in Authentication Page.", authenticationPage.isInAuthPage());
        authenticationPage.login("suci.test@mailinator.com", "testing123");
        Assert.assertTrue("User is not logged in yet", headerMenu.isLoggedInUser());
    }

    @And("user logged in into system using {string} {string}")
    public void userLoggedInIntoSystemUsing(String arg0, String arg1) {
        headerMenu.clickSignIn();
        Assert.assertTrue("User is not in Authentication Page.", authenticationPage.isInAuthPage());
        authenticationPage.login(arg0, arg1);
        Assert.assertTrue("User is not logged in yet", headerMenu.isLoggedInUser());
    }
}
