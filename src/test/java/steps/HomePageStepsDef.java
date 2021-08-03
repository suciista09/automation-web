package steps;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.HomePage;
import webdriver.WebDriverSetup;

public class HomePageStepsDef {
    HomePage homePage = new HomePage(WebDriverSetup.driver);

    @Given("user open homepage")
    public void userOpenHomepage() {
        homePage.openPage();
        Assert.assertTrue("User is not in homepage. ", homePage.isInHomePage());
    }
}
