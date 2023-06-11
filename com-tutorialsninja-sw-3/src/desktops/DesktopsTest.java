package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseurl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);

        select.selectByVisibleText("Name (Z - A)");
    }
    //1.4 Verify the Product will arrange in Descending order.

    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Mouse hover on Desktops Tab. and click
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);

        select.selectByVisibleText("Name (A - Z)");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        //2.5 Verify the Text "HP LP3065"
        String actualText = getTextFromElement(By.xpath("//div[@class='col-sm-4']/h1"));
        String expectedText = "HP LP3065";
        Assert.assertEquals("Verifying text", expectedText, actualText);
        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "11";
        String date = "30";

        driver.findElement(By.xpath("//span[@class='input-group-btn']/button/i")).click();

        while (true) {
            String monthYear = driver.findElement(By.className("picker-switch")).getText(); // Nov 2022
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String year1 = arr[1];

            System.out.println(mon);
            System.out.println(year1);

            if (mon.equalsIgnoreCase(month) && year1.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//th[@class='next']"));
            }
            List<WebElement> listOfDates = driver.findElements(By.xpath("//div[@class='bootstrap-datetimepicker-widget dropdown-menu top pull-right picker-open']/div/div/table/tbody/tr[5]"));
            //if (dt.getText().equalsIgnoreCase(date)) {
            //  dt.click();
            //  break;
        }

        //2.7.Enter Qty "1” using Select class.
         sendTextToElement(By.name("quantity"),"1");
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String actualText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String expectedText1 = "Success: You have added ";
        Assert.assertEquals("Verifying text", expectedText, actualText);
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));
        //2.11 Verify the text "Shopping Cart"
        String actualText2=getTextFromElement(By.xpath("//a[contains(text(),'Shopping Cart')]"));
        String expectedText2 = "Shopping Cart";
        Assert.assertEquals("Verifying text",expectedText2,actualText2);
        //2.12 Verify the Product name "HP LP3065"
        String actualText3=getTextFromElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        String expectedText3 = "HP LP3065";
        Assert.assertEquals("Verifying text",expectedText3,actualText3);
        //2.13 Verify the Delivery Date "2022-11-30"
        String actualText4 = getTextFromElement(By.xpath("//td[@class='text-left']/small"));
        String expectedText4 = "Delivery Date2022-11-30";
        Assert.assertEquals("Verifying text",expectedText4,actualText4);
        //2.14 Verify the Model "Product21"
        String actualText5 = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        String expectedText5 = "Product 21";
        Assert.assertEquals("Verifying text",expectedText5,actualText5);
        //2.15 Verify the Todat "£74.73"


    }
        @After
        public void teardown () {
            closeBrowser();
        }

    }

