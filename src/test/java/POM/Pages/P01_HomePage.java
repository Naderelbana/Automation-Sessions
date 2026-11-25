package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_HomePage {
    WebDriver driver;
    private final By dropDown = By.linkText("Dropdown");
    private final By formAuth = By.linkText("Form Authentication");


    public P01_HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void formAuthClick(){
        driver.findElement(formAuth).click();
    }

    public void dropDownClick(){
        driver.findElement(dropDown).click();
    }

}
