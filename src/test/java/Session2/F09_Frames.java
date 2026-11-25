package Session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F09_Frames {
    WebDriver driver;
    @BeforeMethod
    void setUp(){
        driver = new EdgeDriver(); //open Chrome
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    @Test
    void handleFrames()
    {
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");

        String s1 = driver.findElement(By.id("content")).getText();
        System.out.println(s1);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        String s2 = driver.findElement(By.tagName("body")).getText();
        System.out.println(s2);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        String s3 = driver.findElement(By.tagName("body")).getText();
        System.out.println(s3);
    }
}
