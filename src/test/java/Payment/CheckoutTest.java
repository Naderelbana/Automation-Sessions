package Payment;

import org.testng.annotations.*;

public class CheckoutTest {
    @BeforeClass
    void setUpClass()
    {
        System.out.println("BeforeClass CheckoutTest");
    }
    @BeforeMethod
    void setUpMethod()
    {
        System.out.println("BeforeMethod CheckoutTest");
    }
    @AfterMethod
    void closeMethod()
    {
        System.out.println("AfterMethod CheckoutTest");
    }
    @AfterClass
    void closeClass()
    {
        System.out.println("AfterClass CheckoutTest");
    }
    @Test
    void TC_B()
    {
        System.out.println("TC_B CheckoutTest");
    }
    @Test
    void TC_A()
    {
        System.out.println("TC_A CheckoutTest");
    }
}
