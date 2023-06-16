package Electronics;

import Utils.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElectronicsTest extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseurl);
    }
    @Test
    public void text_verified(){
        //1.1 Mouse Hover on “Electronics” Tab
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/a"));
        //1.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//div[@class='category-grid sub-category-grid']/div/div[2]/div/h2/a"));
        //1.3 Verify the text “Cell phones”
        String actualText=getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        String expectedText="Cell phones";
        Assert.assertEquals("Verifying text",expectedText,actualText);
    }
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully(){
        //2.1 Mouse Hover on “Electronics” Tab
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/a"));
        //2.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//div[@class='category-grid sub-category-grid']/div/div[2]/div/h2/a"));
        //2.3 Verify the text “Cell phones”
        String actualText=getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        String expectedText="Cell phones";
        Assert.assertEquals("Verifying text",expectedText,actualText);
        //2.4 Click on List View Tab
        clickOnElement(By.className("viewmode-icon list"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));
        //2.6 Verify the text “Nokia Lumia 1020”
        String actualText1=getTextFromElement(By.xpath("//div[@class='page-body']/form/div[2]/div/div[2]/div/h1"));
        String expectedText1="Nokia Lumia 1020";
        Assert.assertEquals("Verifying text",expectedText,actualText);
        //2.7 Verify the price “$349.00”
        String actualText2=getTextFromElement(By.id("price-value-20"));
        String expectedText2=" $349.00 ";
        Assert.assertEquals("Verifying text",expectedText,actualText);
        //2.8 Change quantity to 2
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top
        //green Bar
        String actualText3 = getTextFromElement(By.id("bar-notification-container"));
        String expectedText3="The product has been added to your shopping cart";
        Assert.assertEquals("Verify msg",expectedText3,actualText3);
        //After that close the bar clicking on the cross button.
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        clickOnElement(By.className("button-1 cart-button"));
        //2.12 Verify the message "Shopping cart"
        String actualText4=getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        String expectedText4="Shopping cart";
        Assert.assertEquals("Verify msg",expectedText4,actualText4);
        //2.13 Verify the quantity is 2
        String actualText5=getTextFromElement(By.name("itemquantity11234"));
        String expectedText5="2";
        Assert.assertEquals("Verify msg",expectedText5,actualText5);
        //2.14 Verify the Total $698.00
        String actualText6=getTextFromElement(By.xpath("//span[contains(text(),'$698.00')]"));
        String expectedText6="$698.00";
        Assert.assertEquals("Verify msg",expectedText6,actualText6);
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.16 Click on checkout
        clickOnElement(By.className("button-1 checkout-button"));
        //“2.17 Verify the Text “Welcome, Please Sign In!”
        String actualText7 = getTextFromElement(By.xpath("Welcome, Please Sign In!"));
        String expectedText7="Welcome, Please Sign In!";
        Assert.assertEquals("Verify msg",expectedText7,actualText7);
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.className("button-1 register-button"));
        //2.19 Verify the text “Register”
        String actualText8 = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        String expectedText8="Register";
        Assert.assertEquals("Verify msg",expectedText8,actualText8);
        //2.20 Fill the mandatory fields
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.className("button-1 register-next-step-button"));
        //2.22 Verify the message “Your registration completed”
        String actualText9 = getTextFromElement(By.xpath("//div[@class='page-body']/div"));
        String expectedText9="Your registration completed";
        Assert.assertEquals("Verify msg",expectedText8,actualText8);
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.className("button-1 register-continue-button"));
        //2.24 Verify the text “Shopping cart”
        String actualTex1 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        String expectedTex1="Shopping cart";
        Assert.assertEquals("Verify msg",expectedTex1,actualTex1);
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.className("button-1 checkout-button"));
        //2.27 Fill the Mandatory fields
        //2.28 Click on “CONTINUE”
        clickOnElement(By.className("button-1 new-address-next-step-button"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.className("button-1 shipping-method-next-step-button"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        //2.32 Select “Visa” From Select credit card dropdown
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='CreditCardType']/option[1]"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Visa");
        //2.33 Fill all the details
        //2.34 Click on “CONTINUE”CHECKOUT”
        clickOnElement(By.className("button-1 payment-info-next-step-button"));
        //
        //2.35 Verify “Payment Method” is “Credit Card”
        String actualTex2 = getTextFromElement(By.xpath("//div[@class='payment-method-info']/ul/li/span[2]"));
        String expectedTex2="Credit Card";
        Assert.assertEquals("Verify msg",expectedTex2,actualTex2);
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String actualTex3 = getTextFromElement(By.xpath("//span[contains(text(),'2nd Day Air')]"));
        String expectedTex3="2nd Day Air";
        Assert.assertEquals("Verify msg",expectedTex3,actualTex3);
        //2.37 Verify Total is “$698.00”
        //2.38 Click on “CONFIRM”
        clickOnElement(By.className("button-1 confirm-order-next-step-button"));
        //2.39 Verify the Text “Thank You”
        String actualTex5 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        String expectedTex5 = "Thank you";
        Assert.assertEquals("Verify msg",expectedTex5, actualTex5);
        //2.40 Verify the message “Your order has been successfully processed!”
        String actualTex6 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        String expectedTex6 = "Your order has been successfully processed!";
        Assert.assertEquals("Verify msg",expectedTex6, actualTex6);
        //2.41 Click on “CONTINUE”
        clickOnElement(By.className("button-1 order-completed-continue-button"));
        //2.42 Verify the text “Welcome to our store”
        String actualTex7 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        String expectedTex7 = "Welcome to our store'";
        Assert.assertEquals("Verify msg",expectedTex7, actualTex7);
        //2.43 Click on “Logout” link
        clickOnElement(By.className("ico-logout"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
