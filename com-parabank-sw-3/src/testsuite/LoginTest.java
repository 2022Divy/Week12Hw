package testsuite;

import Units.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends Utility {
    String baseurl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(baseurl);
    }
    @Test
    public void test1(){
        //1.userShouldLoginSuccessfullyWithValidCredentials
        //* Enter valid username
        sendTextToElement(By.name("username"), "Snpatel");
        //* Enter valid password
        sendTextToElement(By.name("password"), "Patel1234");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.className("button"));
        //* Verify the ‘Accounts Overview’ text is display
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String expextedText = "Accounts Overview";
        Assert.assertEquals("Verifying msg", expextedText,actualText);
    }
    public void test2() {
        //2.verifyTheErrorMessage
        //* Enter invalid username
        sendTextToElement(By.name("username"), "Svpatel");
        //* Enter invalid password
        sendTextToElement(By.name("password"), "Patel1224");
        //* Click on Login button
        clickOnElement(By.className("button"));
        //* Verify the error message ‘The username and password could not be verified.’
        String actualText = getTextFromElement(By.xpath(" "));
        String expextedText = "The username and password could not be verified.";
        Assert.assertEquals("Verifying msg", expextedText,actualText);
    }
    public void test3(){
        //3.userShouldLogOutSuccessfully
        //* Enter valid username
        sendTextToElement(By.name("username"), "Snpatel");
        //* Enter valid password
        sendTextToElement(By.name("password"), "Patel1234");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.className("button"));
        //* Click on ‘Log Out’ link
        clickOnElement(By.xpath("//div[@id='bodyPanel']/div/ul/li[8]/a"));
        //* Verify the text ‘Customer Login’
        String actualText = getTextFromElement(By.xpath("//div[@id='bodyPanel']/div/h2"));
        String expextedText = "Customer Login";
        Assert.assertEquals("Verifying msg", expextedText,actualText);
    }
    @After
    public void teardown(){
        closeBrowser();
    }

}
