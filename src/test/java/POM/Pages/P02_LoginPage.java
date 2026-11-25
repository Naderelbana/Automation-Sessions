package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class P02_LoginPage {
    WebDriver driver;
    private final By userNameLoc = By.id("username");
    private final By passwordLoc = By.name("password");
    private final By loginBtnLoc = By.className("fa-sign-in");
    private final By logoutBtnLoc = By.className("button");
    private final By successMsgLoc = By.id("flash");
    private final By errorMsgLoc = By.id("flash");

    public P02_LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterValidCredential()
    {
        driver.findElement(userNameLoc).sendKeys("tomsmith");
        driver.findElement(passwordLoc).sendKeys("SuperSecretPassword!");
        driver.findElement(loginBtnLoc).click();
    }
    public void enterInValidCredential()
    {
        driver.findElement(userNameLoc).sendKeys("tomsmith");
        driver.findElement(passwordLoc).sendKeys("SuperSecretPassword!!!");
        driver.findElement(loginBtnLoc).click();
    }

    public void assertInValidLogin(){
        SoftAssert soft = new SoftAssert();
        boolean actual1 = driver.findElement(errorMsgLoc).getText().contains("Your password is invalid!");
        soft.assertTrue(actual1);
        soft.assertAll();
    }
}