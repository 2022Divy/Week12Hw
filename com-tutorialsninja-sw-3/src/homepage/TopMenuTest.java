package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Utility;

public class TopMenuTest extends Utility {

    String baseurl = "http://tutorialsninja.com/demo/index.php?";
@Before
    public void setUp(){
    openBrowser(baseurl);
}
@Test
    public void test1(){
    //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    //1.1 Mouse hover on “Desktops” Tab and click
    clickOnElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
    //1.2 call selectMenu method and pass the menu = “Show All Desktops”

    //1.3 Verify the text ‘Desktops’
    String actualText = getTextFromElement(By.xpath("//div[@id='content']/h2"));
    String expectedText = "Desktops";
    Assert.assertEquals("Verifying text", expectedText,actualText);
}
public void test2(){
    //2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    clickOnElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
    //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
    //2.3 Verify the text ‘Laptops & Notebooks’
    String actualText=getTextFromElement(By.xpath("//div[@id='content']/h2"));
    String expectedText = "Laptops & Notebooks";
    Assert.assertEquals("Verifying text",expectedText,actualText);
}
public void test3(){
    //3.1 Mouse hover on “Components” Tab and click
    clickOnElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a"));
    //3.2 call selectMenu method and pass the menu = “Show All Components”
    //3.3 Verify the text ‘Components’
    String actualText=getTextFromElement(By.xpath("//div[@id='content']/h2"));
    String expectedText = "Components";
    Assert.assertEquals("Verifying text",expectedText,actualText);
}

@After
    public void tearDown(){
    closeBrowser();
}
}
