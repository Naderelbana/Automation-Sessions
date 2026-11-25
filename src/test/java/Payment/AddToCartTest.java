package Payment;

import org.testng.annotations.*;

public class AddToCartTest {
    @BeforeTest
    void setUpTest()
    {
        System.out.println("BeforeTest AddToCartTest");
    }
    @BeforeClass
    void setUpClass()
    {
        System.out.println("BeforeClass AddToCartTest");
    }
    @BeforeMethod
    void setUpMethod()
    {
        System.out.println("BeforeMethod AddToCartTest");
    }
    @AfterMethod
    void closeMethod()
    {
        System.out.println("AfterMethod AddToCartTest");
    }
    @AfterTest
    void closeTest()
    {
        System.out.println("AfterTest");
    }
    @AfterClass
    void closeClass()
    {
        System.out.println("AfterClass AddToCartTest");
    }
    @Test
    void TC_B()
    {
        System.out.println("TC_B AddToCartTest");
    }
    @Test
    void TC_A()
    {
        System.out.println("TC_A AddToCartTest");
    }
}
