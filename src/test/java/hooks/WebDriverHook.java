package hooks;

import io.cucumber.core.gherkin.Argument;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.StepArgument;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import webdriver.WebDriverSetup;

import java.net.MalformedURLException;

public class WebDriverHook {

    @Before
    public void webDriverInitialization() throws MalformedURLException {
        WebDriverSetup.initialize();
    }

    @After
    public void quitBrowser(Scenario scenario){

        if (scenario.isFailed()){
            TakesScreenshot screenshot = (TakesScreenshot) WebDriverSetup.driver;
            byte[] imageByte = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(imageByte, "image/png", scenario.getId());
        }
        WebDriverSetup.quit();
    }

    @AfterStep
    public void afterStep(Scenario scenario){

        //System.out.println("Step: " + step.getArgument().toString());
        //System.out.println("Argument: " + stepArgument.toString());
    }
}
