package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.alertsFrameWindows.BrowserWindows;
import pageObject.elements.TextboxSection;

public class AlertsFrameWindowsTest extends BaseTest{

    @Test(priority = 1, description = "Validate Alerts, frame & Windows section")
    public void alertsFrameWindows(){
        secondPage = homePage.goToSecondPage("Alerts, Frame & Windows");
        Assert.assertEquals("Alerts, Frame & Windows".toLowerCase(), secondPage.getTitleName(), "The section title is not correct.");
        Assert.assertTrue(secondPage.isExpanded(), "The menu list of " + secondPage.getTitleName() + " should be expanded");
    }

    @Test(priority = 2, description = "Validate browser windows section")
    public void browserWindowsSection() {
        browserWindows = (BrowserWindows) secondPage.clickOnOption("browser windows");

        log.info("Checking section title");
        Assert.assertEquals("browser windows".toLowerCase(), secondPage.getTitleName(), "The section title is not correct.");

        log.info("Clicking on new tab button");
        Assert.assertEquals(2, browserWindows.checkNewTabIsOpened());

        log.info("Check url of the new tab");
        Assert.assertEquals("https://demoqa.com/sample",browserWindows.checkNewTabData());

        log.info("Close current tab and open new window");
        browserWindows.closeTab();
        browserWindows.clickNewWindow();


    }
}
