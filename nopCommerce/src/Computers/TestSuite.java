package Computers;

import Utils.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestSuite  extends Utility {
 String baseurl = "https://demo.nopcommerce.com/";

 @Before
    public void setUp(){
        openBrowser(baseurl);
 }

 @Test
    public void test1(){
     //1.1 Click on Computer Menu.
     clickOnElement(By.xpath("//a[contains(text(),'Computers ')]"));
     //1.2 Click on Desktop
     clickOnElement(By.xpath("//h2[@class='title']/a"));
     //1.3 Select Sort By position "Name: Z to A"
     WebElement dropDown = driver.findElement(By.xpath("//select[@id='products-orderby']/option[3]"));
     Select select = new Select(dropDown);
     select.selectByVisibleText("Name: Z to A");
     //1.4 Verify the Product will arrange in Descending order.

 }
 public void verifyProductAddedToShoppingCartSuccessFully(){
     //2.1 Click on Computer Menu.
     clickOnElement(By.xpath("//a[contains(text(),'Computers ')]"));
     //2.2 Click on Desktop
     clickOnElement(By.xpath("//h2[@class='title']/a"));
     //2.3 Select Sort By position "Name: A to Z"
     WebElement dropDown = driver.findElement(By.xpath("//select[@id='products-orderby']/option[2]"));
     Select select = new Select(dropDown);
     select.selectByVisibleText("Name: A to Z");
     //2.4 Click on "Add To Cart"
     clickOnElement(By.className("button-2 product-box-add-to-cart-button"));
     //2.5 Verify the Text "Build your own computer"
     String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
     String expectedText= "Build your own computer";
     Assert.assertEquals("Verifying text", expectedText,actualText);
     //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
     WebElement dropDown1 = driver.findElement(By.id("product_attribute_1"));
     Select select1 = new Select(dropDown1);
     select1.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

     //2.7.Select "8GB [+$60.00]" using Select class.
     WebElement dropDown2 = driver.findElement(By.name("product_attribute_2"));
     Select select2 = new Select(dropDown2);
     select2.selectByVisibleText("8GB [+$60.00]");

     //2.8 Select HDD radio "400 GB [+$100.00]"
     WebElement dropDown3 = driver.findElement(By.xpath("//label[contains(text(),'400 GB [+$100.00]')]"));
     Select select3 = new Select(dropDown3);
     select3.selectByVisibleText("400 GB [+$100.00]");

     //2.9 Select OS radio "Vista Premium [+$60.00]"
     WebElement dropDown4=driver.findElement(By.name("product_attribute_4"));
     Select select4 = new Select(dropDown4);
     select4.selectByVisibleText("Vista Premium [+$60.00]");

     //A 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
     //[+$5.00]"
     WebElement dropDown5= driver.findElement(By.xpath("//dd[@id=product_attribute_input_5]/ul/li/input"));
     Select select5 = new Select(dropDown5);
     select5.selectByVisibleText("Microsoft Office [+$50.00]");

     WebElement dropDown6 = driver.findElement(By.xpath("//dd[@id=product_attribute_input_5]/ul/li[3]/input"));
     Select select6 = new Select(dropDown6);
     select6.selectByVisibleText("Total Commander [+$5.00]");

     //2.11 Verify the price "$1,475.00"
     String actualTex = getTextFromElement(By.className("price-value-1"));
     String expectedTex = "$1,475.00";
     Assert.assertEquals("Verify msg", expectedTex, actualTex);
     //2.12 Click on "ADD TO CARD" Button.
     clickOnElement(By.className("button-1 add-to-cart-button"));
     //2.13 Verify the Message "The product has been added to your shopping cart" on Top
     //green Bar

     //After that close the bar clicking on the cross button.
     //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
     clickOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
     //2.15 Verify the message "Shopping cart"
     String actualTex1 = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
     String expectedTex1 = "Shopping cart";
     Assert.assertEquals("verify message",expectedTex1,actualTex1);
     //2.16 Change the Qty to "2" and Click on "Update shopping cart"
     clickOnElement(By.id("updatecart"));
     //2.17 Verify the Total"$2,950.00"
     String actualTex2 = getTextFromElement(By.xpath("//strong[contains(text(),'$2,950.00')]"));
     String expectedTex2 = "$2,950.00";
     Assert.assertEquals("verify message",expectedTex2,actualTex2);
     //2.18 click on checkbox “I agree with the terms of service”
     clickOnElement(By.id("termsofservice"));
     //2.19 Click on “CHECKOUT”
     clickOnElement(By.className("button-1 checkout-button"));
     //2.20 Verify the Text “Welcome, Please Sign In!”
     String actualTex3=getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
     String expectedTex3="Welcome, Please Sign In!'";
     Assert.assertEquals("Verify msg",expectedTex3,actualTex3);
     //2.21Click on “CHECKOUT AS GUEST” Tab
     clickOnElement(By.className("button-1 checkout-as-guest-button"));
     //2.22 Fill the all mandatory field
     //2.23 Click on “CONTINUE”
     clickOnElement(By.className("button-1 new-address-next-step-button"));
     //2.24 Click on Radio Button “Next Day Air($0.00)”
     clickOnElement(By.id("shippingoption_1"));
     //2.25 Click on “CONTINUE”
     clickOnElement(By.className("button-1 shipping-method-next-step-button"));
     //2.26 Select Radio Button “Credit Card”
     clickOnElement(By.className("paymentmethod_1"));
     //2.27 Select “Master card” From Select credit card dropdown
     WebElement dropDn = driver.findElement(By.xpath("//select[@id='CreditCardType']/option[2]"));
     Select select7 = new Select(dropDn);
     select7.selectByVisibleText("Master card");
     //2.28 Fill all the details
     //2.29 Click on “CONTINUE”
     clickOnElement(By.className("button-1 payment-info-next-step-button"));
     //2.30 Verify “Payment Method” is “Credit Card”
     String actualTex4 = getTextFromElement(By.xpath("//div[@class='billing-info-wrap']/div[2]/ul/li/span[2]"));
     String expectedTex4 = "Credit Card";
     Assert.assertEquals("Verify msg",expectedTex4,actualTex4);
     //2.32 Verify “Shipping Method” is “Next Day Air”
     String actualTex5 = getTextFromElement(By.xpath("//span[contains(text(),'Next Day Air')]"));
     String expectedTex5 = "Next Day Air";
     Assert.assertEquals("Verify msg",expectedTex5,actualTex5);
     //2.33 Verify Total is “$2,950.00”
     String actualTex6 = getTextFromElement(By.xpath("//span[@class='value-summary']"));
     String expectedTex6 = "$2,950.00";
     Assert.assertEquals("Verify msg",expectedTex6,actualTex6);
     //2.34 Click on “CONFIRM”
     clickOnElement(By.className("button-1 confirm-order-next-step-button"));
     //2.35 Verify the Text “Thank You”
     //2.36 Verify the message “Your order has been successfully processed!”
     //2.37 Click on “CONTINUE”
     //2.37 Verify the text “Welcome to our store”
 }
 @After
    public void tearDown(){
     closeBrowser();
 }

}
