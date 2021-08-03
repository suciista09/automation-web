package webdriver;

import config.DataConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverSetup {

    public static RemoteWebDriver driver;
    public static WebDriverWait wait;

    public static void initialize() throws MalformedURLException {
        DataConfig dataConfig = new DataConfig();
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        //driver = new ChromeDriver();
        if (dataConfig.getData("remote").equals("true")){
            driver = new RemoteWebDriver(new URL(dataConfig.getData("remoteUrl")), options);
        }else{
            driver = new ChromeDriver();
        }


        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public static void quit(){
        driver.quit();
    }
}
