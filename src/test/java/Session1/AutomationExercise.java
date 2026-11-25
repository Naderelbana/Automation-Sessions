package Session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomationExercise {
    EdgeDriver driver;
    @BeforeMethod
    void beforeMethod(){
        driver = new EdgeDriver(); //open Chrome
        driver.get("http://automationexercise.com");

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void ContactUsForm()
    {
        WebElement ele = driver.findElement(By.cssSelector("a[href=\"/contact_us\"]"));
        ele.click();
        ////h2[.="Get In Touch"]
        WebElement res = driver.findElement(By.xpath("(//h2[@class=\"title text-center\"])[2]"));
        System.out.println(res.getText());
        boolean actual = res.getText().contains("GET IN TOUCH");
        Assert.assertTrue(actual);

        WebElement ele2 = driver.findElement(By.cssSelector("input[name=\"name\"]"));
        ele2.sendKeys("Nader");

        WebElement ele3 = driver.findElement(By.cssSelector("input[name=\"email\"]"));
        ele3.sendKeys("nader.mido63@gmail.com");

        WebElement ele4 = driver.findElement(By.cssSelector("input[name=\"subject\"]"));
        ele4.sendKeys("cairo");

        WebElement ele5 = driver.findElement(By.cssSelector("textarea[id=\"message\"]"));
        ele5.sendKeys("hello world");

        String s = "testData.txt";
        //C:\Users\compu magic\Desktop
        WebElement ele6 = driver.findElement(By.cssSelector("input[name=\"upload_file\"]"));
        ele6.sendKeys("C:\\Users\\compu magic\\Desktop\\" + s);

        WebElement ele7 = driver.findElement(By.cssSelector("input[name=\"submit\"]"));
        ele7.click();

        String ss = driver.switchTo().alert().getText();
        if (ss.equals("Press OK to proceed!"))
        {
            driver.switchTo().alert().accept();
        }
        else {
            driver.switchTo().alert().dismiss();
        }

        WebElement ele8 = driver.findElement(By.cssSelector(".status"));
        boolean actual2 = ele8.getText().contains("Success! Your details have been submitted successfully.");

    }
    @Test
    void searchProduct(){
        WebElement ele = driver.findElement(By.cssSelector("a[href=\"/products\"]"));
        ele.click();

        WebElement ele2 = driver.findElement(By.cssSelector("input[name=\"search\"]"));
        ele2.sendKeys("men");

        //button[id="submit_search"]
        WebElement ele3 = driver.findElement(By.cssSelector("button[id=\"submit_search\"]"));
        ele3.click();

        //h2[class="title text-center"]
        WebElement res = driver.findElement(By.xpath("(h2[class=\"title text-center\"]"));
        boolean actual = res.getText().contains("SEARCHED PRODUCTS");
        Assert.assertTrue(actual);
    }
}
