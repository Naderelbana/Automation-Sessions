package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class P04_DropDownPage {
    WebDriver driver;
    private final By dropDownLoc = By.cssSelector("select[id=\"dropdown\"]");
    private final By optionLoc = By.cssSelector("option[value=\"2\"]");

    public P04_DropDownPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void selectOption(){
        Select sel = new Select(driver.findElement(dropDownLoc));
        sel.selectByVisibleText("Option 2");
    }

    public void assertOptionSelected(){
       boolean actual = driver.findElement(optionLoc).isDisplayed();
        Assert.assertTrue(actual);
    }
}
