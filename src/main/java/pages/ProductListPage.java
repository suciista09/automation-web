package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductListPage {
    RemoteWebDriver driver;
    WebDriverWait wait;

    public ProductListPage(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isInproductList(String category){
        return driver.getTitle().equalsIgnoreCase(category + " - My Store");
    }

    public void hoverToProduct(int index){
        WebElement element = driver.findElementByXPath("(//div[@class=\"product-container\"])["+ index + "]");
        Actions actions = new Actions(driver);
        actions.moveToElement(element).pause(3000).build().perform();
    }

    public void clickToProductAfterHover(int index){
        WebElement element = driver.findElementByCssSelector("a.button[data-id-product=\""+index+"\"]");
        Actions actions = new Actions(driver);
        actions.moveToElement(element).pause(3000).click().build().perform();
    }

    public String getProductName(int index){
        return driver.findElementByXPath("(//div[@class=\"right-block\"]//a[@class=\"product-name\"])[" + index + "]").getText();
    }

    public float getPrice(int index){
        String price_ = driver.findElementByXPath("(//div[@class=\"right-block\"]//div[@class=\"content_price\"])[1]").getText();
        String price_tmp = price_.replace("$", "");

        return Float.parseFloat(price_tmp);
    }

    public void userAddToCart(int index){
        WebElement parentElement = driver.findElementByXPath("(//div[@class=\"product-container\"])["+ index + "]");
        Actions actions = new Actions(driver);
        actions.moveToElement(parentElement).pause(3000);

        WebElement buttonAddToCart = driver.findElementByCssSelector("a.button[data-id-product=\""+index+"\"]");
        actions.moveToElement(buttonAddToCart);
        actions.click().build().perform();
    }

    public boolean isPriceSortByLowest(){
        List<WebElement> webElements = driver.findElementsByClassName("div.right-block span.price");
        int size = webElements.size();

        for (int i = 0 ; i < size - 1 ; i++){
            if (Integer.parseInt(webElements.get(i).getText()) > Integer.parseInt(webElements.get(i+1).getText())){
                return false;
            }
        }

        return true;
    }

    public void selectSortByValue(String value){
        Select select = new Select(driver.findElementById("selectProductSort"));

        select.selectByValue(value);
    }

    public void waituntilLoadingDisappear(){
        wait.until(ExpectedConditions.invisibilityOf(driver.findElementByCssSelector(".product_list img[src=\"http://automationpractice.com/img/loader.gif\"]")));
    }

    public String getValueofSort(String text){
        switch (text){
            case "Price: Lowest first":
                return "price:asc";

            case "Price: Highest first":
                return "price:desc";
        }
        throw new NullPointerException("can not find value");
    }
}
