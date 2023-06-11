package utils;

import browserfactory.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends baseTest {
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




    //This method will select by index number
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByIndex(index);
    }



    //This method will select by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    //This method will select by value
    public void selectByValueFromDropdown(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }


    //This method will select the option by contains text
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

}

