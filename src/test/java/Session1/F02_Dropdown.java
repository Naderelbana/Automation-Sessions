package Session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class F02_Dropdown {
    WebDriver driver ;
    @BeforeMethod
    void beforeMethod(){
        driver = new EdgeDriver(); //open Chrome
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    void selectFromDropdown()
    {
        WebElement ele = driver.findElement(By.cssSelector("select[id=\"dropdown\"]"));
        Select sel = new Select(ele);
        sel.selectByVisibleText("Option 2");
//        sel.selectByIndex(2);
//        sel.selectByValue("2");
        boolean actual = driver.findElement(By.cssSelector("option[value=\"2\"]")).isDisplayed();
        Assert.assertTrue(actual);
    }
    @AfterMethod
    void closeMethod(){
    //    driver.quit();
    }
    @Test
    void selectDd(){
        List<WebElement> eles = driver.findElements(By.tagName("option"));
        eles.get(2).click();
        boolean actual = driver.findElement(By.cssSelector("option[value=\"2\"]")).isDisplayed();
        Assert.assertTrue(actual);
    }
}
