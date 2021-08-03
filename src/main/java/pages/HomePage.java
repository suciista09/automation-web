package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage {
    RemoteWebDriver driver;

    public HomePage(RemoteWebDriver driver){
        this.driver = driver;
    }

    public void openPage(){
        driver.get("http://automationpractice.com/");
    }

    public boolean isInHomePage(){
        return driver.getTitle().equalsIgnoreCase("My Store");
    }
}
