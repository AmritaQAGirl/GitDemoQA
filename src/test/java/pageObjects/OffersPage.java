package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    public WebDriver driver;
    By search = By.id("search-field");
    By productName = By.xpath("//tbody/tr/td[text()='Tomato']");

    public OffersPage(WebDriver driver){
        this.driver = driver;
    }

    public void search(String name){
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName(){
       return driver.findElement(productName).getText();
    }




}
