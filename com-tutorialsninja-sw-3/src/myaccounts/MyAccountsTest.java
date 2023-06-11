package myaccounts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Utility;

public class MyAccountsTest extends Utility {
    String baseurl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //1.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”

        //1.3 Verify the text “Register Account”.
        String actualText = getTextFromElement(By.xpath("//div[@id='content']/h1"));
        String expectedText = "Register Account";
        Assert.assertEquals("Verifying text", expectedText, actualText);
    }
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //2.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”

        //2.3 Verify the text “Returning Customer”.
        String actualTex = getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        String expectedTex = "Returning Customer";
        Assert.assertEquals("Verifying text", expectedTex, actualTex);

    }
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        //3.3 Enter First Name
        sendTextToElement(By.name("firstname"),"divya");
        //3.4 Enter Last Name
        sendTextToElement(By.name("lastname"), "patel");
        //3.5 Enter Email
        sendTextToElement(By.name("email"),"divya1234@gmail.com");
        //3.6 Enter Telephone
        sendTextToElement(By.name("telephone"),"07393155506");
        //3.7 Enter Password
        sendTextToElement(By.name("password"), "Patel1234");
        //3.8 Enter Password Confirm
        sendTextToElement(By.name("confirm"), "Patel1234");
        //3.9 Select Subscribe Yes radio button
        WebElement dropDown = driver.findElement(By.name("newsletter"));
        Select select = new Select(dropDown);

        select.selectByVisibleText("Yes");

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//div[@class='buttons']/div/a/b"));
        //3.11 Click on Continue button
        clickOnElement(By.className("btn btn-primary"));
        //3.12 Verify the message “Your Account Has Been Created!”
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String expectedText1 = "Your Account Has Been Created!'";
        Assert.assertEquals("Verifying text", expectedText1, actualText1);

        //3.13 Click on Continue button
        clickOnElement(By.className("btn btn-primary"));
        //3.14 Clickr on My Account Link.
        clickOnElement(By.xpath("//h2"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        //3.16 Verify the text “Account Logout”
        String actualText2 = getTextFromElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[5]/a"));
        String expectedText2 = "Logout";
        Assert.assertEquals("Verifying text", expectedText2, actualText2);

        //3.17 Click on Continue button
        clickOnElement(By.className("btn btn-primary"));
    }
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        //4.3 Enter Email address
        sendTextToElement(By.id("input-email"), "divya1234@gmail.com");
        //4.4 Enter Last Name

        //4.5 Enter Password
        sendTextToElement(By.name("password"), "Patel1234");
        //4.6 Click on Login button
        clickOnElement(By.className("btn btn-primary"));
        //4.7 Verify text “My Account”
        String actualText3 = getTextFromElement(By.xpath("//h2"));
        String expectedText3 = "My Account";
        Assert.assertEquals("Verifying text", expectedText3, actualText3);
        //4.8 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

    }


}
