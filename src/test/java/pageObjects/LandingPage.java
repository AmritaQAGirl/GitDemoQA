package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;
    By search = By.xpath("//input[@type='search']");
    By productName = By.xpath("//div[@class='product']/div/following-sibling::h4");
    By topDeals = By.linkText("Top Deals");
    By increment = By.cssSelector("a.increment");
    By addToCart = By.cssSelector(".product-action button");

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchText(String name){
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public void topDealsClick(){
        driver.findElement(topDeals).click();
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }

    public void increment(int quantity){
        int i = quantity-1;
        while (i>0){
            driver.findElement(increment).click();
            i--;
        }
    }

    public void addToCart(){
        driver.findElement(addToCart).click();
    }

}
