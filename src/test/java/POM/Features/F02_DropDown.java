package POM.Features;

import POM.Pages.P01_HomePage;
import POM.Pages.P04_DropDownPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F02_DropDown {
    WebDriver driver ;
    P01_HomePage Hp;
    P04_DropDownPage Dp;
    @BeforeMethod
    void beforeMethod(){
        driver = new EdgeDriver(); //open Chrome
        Hp = new P01_HomePage(driver);
        Dp = new P04_DropDownPage(driver);
        driver.get("https://the-internet.herokuapp.com");
    }
    @Test
    void selectFromDropdown()
    {
        Hp.dropDownClick();
        Dp.selectOption();
        Dp.assertOptionSelected();
    }
}