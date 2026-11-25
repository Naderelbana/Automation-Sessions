package Session1;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class F04_Waits {
    WebDriver driver ;
    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver(); //open Chrome
        driver.get("https://the-internet.herokuapp.com/hovers");

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void TC_A(){
        // moveToElement , Actions

        // explicit wait
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("View profile")));

        // fluent wait
        FluentWait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("element wasn't found");
        wait1.until(ExpectedConditions.elementToBeClickable(By.id("")));




        Actions act = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath("(//img[@src=\"/img/avatar-blank.jpg\"])[2]"));
        act.moveToElement(ele).perform();

        WebElement elee = driver.findElement(By.cssSelector("a[href=\"/users/2\"]"));
        elee.click();

        boolean actual = driver.findElement(By.tagName("h1")).isDisplayed();
        Assert.assertTrue(actual);

    }
}
