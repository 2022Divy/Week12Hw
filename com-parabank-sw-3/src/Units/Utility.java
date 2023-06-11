package Units;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {
    //Click on elements
public void clickOnElement(By by){
    WebElement element = driver.findElement(by);
    element.click();
}
// Method for get text
    public String getTextFromElement(By by){
    return driver.findElement(by).getText();
    }
// method for send text to element
    public void sendTextToElement(By by, String text){
    WebElement element = driver.findElement(by);
    element.sendKeys(text);
    }

}
