package Auth;

import org.testng.annotations.*;

public class RegisterTest {

    @BeforeClass
    void setUpClass()
    {
        System.out.println("BeforeClass RegisterTest");
    }
    @BeforeMethod
    void setUpMethod()
    {
        System.out.println("BeforeMethod RegisterTest");
    }
    @AfterMethod
    void closeMethod()
    {
        System.out.println("AfterMethod RegisterTest");
    }
    @AfterClass
    void closeClass()
    {
        System.out.println("AfterClass RegisterTest");
    }
    @Test
    void TC_B()
    {
        System.out.println("TC_B RegisterTest");
    }
    @Test
    void TC_A()
    {
        System.out.println("TC_A RegisterTest");
    }
}
