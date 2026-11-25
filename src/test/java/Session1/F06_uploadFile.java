package Session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class F06_uploadFile {
    WebDriver driver ;
    @BeforeMethod
    void setUp(){
        driver = new EdgeDriver(); //open Chrome
        driver.get("https://the-internet.herokuapp.com/upload");

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void TC_A(){
        String s = "testData.txt";
        //C:\Users\compu magic\Desktop
        WebElement ele = driver.findElement(By.id("file-upload"));
        ele.sendKeys("C:\\Users\\compu magic\\Desktop\\" + s);

        WebElement ele2 = driver.findElement(By.id("file-submit"));
        ele2.click();

        WebElement ele3 = driver.findElement(By.id("uploaded-files"));
        boolean actualRes = ele3.isDisplayed();
        Assert.assertTrue(actualRes);
    }
}
