package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class P03_SuccessfullLogin {
    WebDriver driver;
    private final By logoutBtnLoc = By.className("button");
    private final By successMsgLoc = By.id("flash");

    public P03_SuccessfullLogin(WebDriver driver){
        this.driver = driver;
    }

    public void assertSuccessfullyLogin(){
        SoftAssert soft = new SoftAssert();
        boolean actual1 = driver.findElement(logoutBtnLoc).isDisplayed();
        soft.assertTrue(actual1);
        boolean actual2 = driver.findElement(successMsgLoc).getText().contains("You logged into a secure area!");
        soft.assertTrue(actual2);
        soft.assertAll();
    }

}
