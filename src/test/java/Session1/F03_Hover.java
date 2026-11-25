package Session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F03_Hover {
    ChromeDriver driver ;
    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver(); //open Chrome
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    void TC_A(){
        // moveToElement , Actions

        Actions act = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath("(//img[@src=\"/img/avatar-blank.jpg\"])[2]"));
        act.moveToElement(ele).perform();

        WebElement elee = driver.findElement(By.cssSelector("a[href=\"/users/2\"]"));
        elee.click();

        boolean actual = driver.findElement(By.tagName("h1")).isDisplayed();
        Assert.assertTrue(actual);

    }
}
