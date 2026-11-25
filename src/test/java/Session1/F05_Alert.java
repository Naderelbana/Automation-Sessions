package Session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class F05_Alert {
    ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();
    WebDriver driver ;
    @BeforeMethod
    void setUp(){
        driver = ThreadGuard.protect(new EdgeDriver());
        localDriver.set(driver);
        localDriver.get().get("https://the-internet.herokuapp.com/javascript_alerts");

        //implicit wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void TC_A(){
        WebElement ele1 = localDriver.get().findElement(By.cssSelector("button[onclick=\"jsAlert()\"]"));
        ele1.click();

        localDriver.get().switchTo().alert().accept();

        WebElement res = localDriver.get().findElement(By.id("result"));
        boolean actual = res.getText().contains("You successfully clicked an alert");
        Assert.assertTrue(actual);

    }

    @Test
    void TC_B(){
        WebElement ele1 = localDriver.get().findElement(By.cssSelector("button[onclick=\"jsConfirm()\"]"));
        ele1.click();

        String s = localDriver.get().switchTo().alert().getText();
        if (s.equals("I am a JS Confirm"))
        {
            localDriver.get().switchTo().alert().accept();
        }
        else {
            localDriver.get().switchTo().alert().dismiss();
        }
        boolean actualRes = localDriver.get().findElement(By.id("result")).getText().contains("You clicked: Ok");
        Assert.assertTrue(actualRes);
    }

    @Test
    void TC_C(){
        WebElement ele2 = localDriver.get().findElement(By.cssSelector("button[onclick=\"jsPrompt()\"]"));
        ele2.click();

        localDriver.get().switchTo().alert().sendKeys("Nader");
        localDriver.get().switchTo().alert().accept();

        boolean actualRes1 = localDriver.get().findElement(By.id("result")).getText().contains("You entered: Nader");
        Assert.assertTrue(actualRes1);
    }
}
