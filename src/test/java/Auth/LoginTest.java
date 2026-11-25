package Auth;

import org.testng.annotations.*;

public class LoginTest {
    @BeforeSuite
    void setUpSuite()
    {
        System.out.println("BeforeSuite");
    }
    @BeforeTest
    void setUpTest()
    {
        System.out.println("BeforeTest LoginTest");
    }
    @BeforeClass
    void setUpClass()
    {
        System.out.println("BeforeClass LoginTest");
    }
    @BeforeMethod
    void setUpMethod()
    {
        System.out.println("BeforeMethod LoginTest");
    }
    @AfterMethod
    void closeMethod()
    {
        System.out.println("AfterMethod LoginTest");
    }
    @AfterSuite
    void closeSuite()
    {
        System.out.println("AfterSuite");
    }
    @AfterTest
    void closeTest()
    {
        System.out.println("AfterTest");
    }
    @AfterClass
    void closeClass()
    {
        System.out.println("AfterClass LoginTest");
    }
    @Test
    void TC_B()
    {
        System.out.println("TC_B LoginTest");
    }
    @Test
    void TC_A()
    {
        System.out.println("TC_A LoginTest");
    }
}
