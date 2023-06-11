package testsuite;

import Units.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends Utility {
    String baseurl = "https://parabank.parasoft.com/parabank/index.htm";

   @Before
    public void setup(){
       openBrowser(baseurl);
   }
   @Test
    public void test1(){
       //1.verifyThatSigningUpPageDisplay
       //click on the ‘Register’ link
       clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

       String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
       String expectedText = "Signing up is easy!";
       Assert.assertEquals("Verifying signup message",expectedText, actualText);

   }
   public void test2(){
       //2.userSholdRegisterAccountSuccessfully
       //click on the ‘Register’ link
       clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
       //* Enter First name
       sendTextToElement(By.id("customer.firstName"), "Sneha");
       //* Enter Last name
       sendTextToElement(By.id("customer.lastName"),"Patel");
       //* Enter Address
       sendTextToElement(By.id("customer.address.street"),"31,highStreet");
       //* Enter City
       sendTextToElement(By.name("customer.address.city"),"Harrow");
       //* Enter State
       sendTextToElement(By.id("customer.address.state"), "Middlesex");
       //* Enter Zip Code
       sendTextToElement(By.id("customer.address.zipCode"),"HA36QY");
       //* Enter Phone
       sendTextToElement(By.id("customer.phoneNumber"), "7547074678");
       //* Enter SSN
       sendTextToElement(By.id("customer.ssn"),"SX976788");
       //* Enter Username
       sendTextToElement(By.id("customer.username"),"Snpatel");
       //* Enter Password
       sendTextToElement(By.name("customer.password"),"Patel1234");
       //* Enter Confirm
       sendTextToElement(By.name("repeatedPassword"), "Patel1234");
       //* Click on REGISTER button
       clickOnElement(By.className("button"));
       //* Verify the text 'Your account was created successfully. You are now logged in.’
       String actualText = getTextFromElement(By.xpath("//div[@id='rightPanel']/p"));
       String expectedText = "Your account was created successfully. You are now logged in.";
       Assert.assertEquals("Verifying logged in message",expectedText, actualText);

   }
   @After
    public void teardown(){
       closeBrowser();
   }
}
