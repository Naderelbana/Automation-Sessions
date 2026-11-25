package Session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class F08_MultibleWindows {
    WebDriver driver;
    @BeforeMethod
    void setUp(){
        driver = new EdgeDriver(); //open Chrome
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    void handleWindows(){
        String s1 = driver.getCurrentUrl();
        System.out.println(s1);
        driver.findElement(By.linkText("Click Here")).click();

        List<String> TabsIDs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(TabsIDs.get(1));
        System.out.println(driver.getCurrentUrl());

        driver.switchTo().window(TabsIDs.get(0));
        System.out.println(driver.getCurrentUrl());
    }
}
