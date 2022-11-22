package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest<expectedMessage, actualMessage> extends BaseTest {

    String baseUrl ="http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);

    }

    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials(){

        //find username field and Enter tomsmith
        driver.findElement(By.name("BaseTest")).sendKeys("tomsmith");

        //find Password field and enter SuperSecretPassword!
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
    }
    //Verify dashboard text after login
    String expectedMessage = "Your username is invalid!\n×";

    //Find Log out text element and get the text
    WebElement actualTextMessageElement = driver.findElement(By.xpath("//div[@id='flash']"));
    String actualMessage = actualTextMessageElement.getText();

    //Validate actual and expected



    @Test
    public void verifyThePasswordErrorMessage() {
        // username and enter in field element
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        // password and enter in field element
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        //login button and click
        driver.findElement(By.xpath("//button/i[@class='fa fa-2x fa-sign-in']")).click();

        //Verify dashboard text after login
        String expectedMessage = "Your password is invalid!\n" + "x";

        // Log out text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTextMessageElement.getText();

        //Validate actual and expected
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
