package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    public WebDriver driver;
    By cart = By.xpath("//a[@class='cart-icon']");
    By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By promoButton = By.xpath("//button[@class='promoBtn']");
    By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkOutItems(){
        driver.findElement(cart).click();
        driver.findElement(checkOutButton).click();
    }

    public boolean verifyPromoButton(){
        return driver.findElement(promoButton).isDisplayed();
    }

    public boolean verifyPlaceOrderButton(){
        return driver.findElement(placeOrder).isDisplayed();
    }

}
