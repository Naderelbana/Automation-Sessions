package Session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class F07_DataProvider {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "DP")
    void loginValid(String UN , String PW)
    {
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys(UN);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(PW);


        WebElement loginField = driver.findElement(By.id("login-button"));
        loginField.click();

        WebElement productLoc = driver.findElement(By.className("title"));
        boolean actual = productLoc.isDisplayed();
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "DP")
    String [][] giveData(){
        String [][] Data = {
                {"standard_user" , "secret_sauce"},
                {"locked_out_user" , "secret_sauce"},
                {"error_user", "secret_sauce"}
        };
        return  Data;
    }
}
