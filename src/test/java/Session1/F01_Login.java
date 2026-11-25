package Session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class F01_Login {
    EdgeDriver driver;
    @BeforeMethod
    void beforeMethod(){
        driver = new EdgeDriver(); //open Chrome
        driver.get("https://the-internet.herokuapp.com/login");
    }

        @Test
        void validLogin()
        {
            WebElement userNameField = driver.findElement(By.id("username"));
            userNameField.sendKeys("tomsmith");

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("SuperSecretPassword!");

            WebElement loginField = driver.findElement(By.className("fa-sign-in"));
            loginField.click();

            SoftAssert soft = new SoftAssert();
            WebElement textLoc = driver.findElement(By.xpath("//h4[.=\"Welcome to the Secure Area. When you are done click logout below.\"]"));
            boolean actual = textLoc.getText().contains("Welcome to the Secure Area. When you are done click logout below.\n");
            soft.assertTrue(actual);


            soft.assertAll();
        }



//        ChromeDriver driver1 = new ChromeDriver();
//        driver1.get("https://the-internet.herokuapp.com/login");
//
//
//        WebElement userNameFieldCss = driver1.findElement(By.cssSelector("#username"));
//        userNameFieldCss.sendKeys("Naderelbana");
//
//        WebElement passwordFieldXpath = driver1.findElement(By.xpath("//input[@id=\"password\"]"));
//        passwordFieldXpath.sendKeys("NaderElbanaa!");
//
//
//        WebElement loginFieldCss = driver1.findElement(By.cssSelector(".fa-sign-in"));
//        loginFieldCss.click();
//
//        //div[contains(text(), 'Your username is invalid!')]
//        WebElement textLoc1 = driver.findElement(By.xpath("//div[contains(text(), \"Your username is invalid!\")]"));
//        boolean actual1 = textLoc.getText().contains("Your username is invalid!.\n");
//        Assert.assertEquals(actual1, true, "appear once failure");

    }

