package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseurl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        clickOnElement(By.className("dropdown-toggle"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //1.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);

        select.selectByVisibleText("Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.

        }
    public void verifyThatUserPlaceOrderSuccessfully(){
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        clickOnElement(By.className("dropdown-toggle"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //2.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);

        select.selectByVisibleText("Price (High > Low)");
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//div[@class='caption']/h4/a"));
        //2.5 Verify the text “MacBook”
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        String expectedText="MacBook";
        Assert.assertEquals("Verifying text",expectedText,actualText);
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.id("button-cart"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualText1 = getTextFromElement(By.className("alert alert-success alert-dismissible"));
        String expectedText1 = "Success: You have added ";
        Assert.assertEquals("Verifying text", expectedText1, actualText1);
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/a[2]"));
        //2.9 Verify the text "Shopping Cart"
        String actualText2=getTextFromElement(By.xpath("//ul[@class='breadcrumb']/li[2]/a"));
        String expectedText2="Shopping Cart";
        Assert.assertEquals("Verify Text", expectedText2,actualText2);
        //2.10 Verify the Product name "MacBook"
        String actualText3=getTextFromElement(By.xpath("//td[@class='text-left']/a"));
        String expectedText3="MacBook";
        Assert.assertEquals("Verify Text", expectedText3,actualText3);
        //2.11 Change Quantity "2"
        clickOnElement(By.className("form-control"));
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[4]/div/span/button/i"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualText4=getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/i"));
        String expectedText4="Success: You have modified your shopping cart!";
        Assert.assertEquals("Verify Text", expectedText4,actualText4);
        //2.14 Verify the Total £737.45
        String actualText5=getTextFromElement(By.xpath("//td[contains(text(),'£737.45')]"));
        String expectedText5="£737.45";
        Assert.assertEquals("Verify Text", expectedText5,actualText5);
        //2.15 Click on “Checkout” button
        clickOnElement(By.className("btn btn-primary"));
        //2.16 Verify the text “Checkout”
        String actualT=getTextFromElement(By.xpath("//div[@id='content']/h1"));
        String expectedT="Checkout";
        Assert.assertEquals("Verify Text", expectedT,actualT);

        //2.17 Verify the Text “New Customer”
        String actualT1=getTextFromElement(By.xpath("//div[@class='panel-body']/div/div/h2"));
        String expectedT1="New Customer";
        Assert.assertEquals("Verify Text", expectedT1,actualT1);


        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//div[@class='col-sm-6']/div[2]/label/input"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.id("button-account"));
        //2.20 Fill the mandatory fields

        //2.21 Click on “Continue” Button
        clickOnElement(By.className("btn btn-primary"));
        //2.22 Add Comments About your order into text area
        clickOnElement(By.name("comment"));
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//div[@class='buttons']/div/a/b"));
        //2.24 Click on “Continue” button
        clickOnElement(By.id("button-payment-method"));
        //2.25 Verify the message “Warning: Payment method required!”
        String actualT2=getTextFromElement(By.xpath("//div[@id='accordion']/div[3]/div[2]/div/div"));
        String expectedT2="Warning: Payment method required!";
        Assert.assertEquals("Verify Text", expectedT2,actualT2);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
