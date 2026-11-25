package POM.Features;

import POM.Pages.P01_HomePage;
import POM.Pages.P02_LoginPage;
import POM.Pages.P03_SuccessfullLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class F01_Login {
    WebDriver driver ;
    P01_HomePage Hp;
    P02_LoginPage Lp;
    P03_SuccessfullLogin SlP;
    @BeforeMethod
    void beforeMethod(){
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new EdgeDriver(); //open Chrome
        Hp = new P01_HomePage(driver);
        Lp = new P02_LoginPage(driver);
        SlP = new P03_SuccessfullLogin(driver);
        driver.get("https://the-internet.herokuapp.com");
    }
    @Test
    void validLogin(){
        Hp.formAuthClick();
        Lp.enterValidCredential();
        SlP.assertSuccessfullyLogin();
    }

    @Test
    void inValidLogin(){
        Hp.formAuthClick();
        Lp.enterInValidCredential();
        Lp.assertInValidLogin();
    }

}