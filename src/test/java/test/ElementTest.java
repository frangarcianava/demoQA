package test;

import listeners.RetryListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.TextboxSection;

public class ElementTest extends BaseTest{

    @Test(description = "Validate that the elements section is opened")
    public void clickOnElementsSection() {
//        SoftAssert softAssert = new SoftAssert();
        secondPage = homePage.goToSecondPage("Elements");

        Assert.assertEquals("Elements", secondPage.getTitleName(), "The section title is not correct.");
        Assert.assertTrue(secondPage.isExpanded(), "The menu list of "+secondPage.getTitleName()+" should be expanded");
    }

    @Test(description = "Validate Textbox section")
    public void fillTextBoxSection() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        textboxSection = (TextboxSection) secondPage.clickOnOption("text box");
        log.info("Filling data...");
        log.info("Send a wrong email");
        Assert.assertTrue(textboxSection.fillOutForm("frangmail.com"),"The email field should be throw an error");
        log.info("Send a valid email");
        Assert.assertTrue(textboxSection.fillOutForm("fran@gmail.com"), "The output section should appear");

    }

    @Test(description = "Validate Checkbox section")
    public void fillCheckboxSection() {

    }

}
