package Utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    public WebDriver driver;

    public GenericUtils(WebDriver driver){
        this.driver = driver;
    }

    public void switchWindowToChild(){
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i = s1.iterator();
        String parentWindow = i.next();
        String childWindow = i.next();
        driver.switchTo().window(childWindow);
    }
}
