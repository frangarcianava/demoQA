package test;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pageObject.*;

/**
 * Unit test for simple App.
 */
public class BaseTest
{
    protected static MyDriver myDriver;
    protected static Logger log = LogManager.getLogger();
    protected static HomePage homePage;
    protected static SecondPage secondPage;
    protected static TextboxSection textboxSection;
    protected static CheckboxSection checkboxSection;
    protected static RadiobuttonSection radiobuttonSection;


    @Parameters({"browser"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String browser) {
        log.info("Setting Up...");
        myDriver = new MyDriver(browser);
        homePage = new HomePage(myDriver.getDriver());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        log.info("Closing...");
        homePage.dispose();
        myDriver.getDriver().quit();
    }

    public MyDriver getDriver() {
        return myDriver;
    }

}
