package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.CheckboxSection;
import pageObject.TextboxSection;

public class ElementTest extends BaseTest{

    @Test(priority = 1, description = "Validate that the elements section is opened")
    public void clickOnElementsSection() {
        secondPage = homePage.goToSecondPage("Elements");

        Assert.assertEquals("Elements".toLowerCase(), secondPage.getTitleName(), "The section title is not correct.");
        Assert.assertTrue(secondPage.isExpanded(), "The menu list of "+secondPage.getTitleName()+" should be expanded");
    }

//    @Test(priority = 2, description = "Validate Textbox section")
//    public void fillTextBoxSection() throws InterruptedException {
//        textboxSection = (TextboxSection) secondPage.clickOnOption("text box");
//
//        log.info("Checking section title");
//        Assert.assertEquals("Text Box".toLowerCase(), secondPage.getTitleName(), "The section title is not correct.");
//
//        log.info("Filling data...");
//        log.info("Send a wrong email");
//        Assert.assertTrue(textboxSection.fillOutForm("frangmail.com"),"The email field should be throw an error");
//
//        log.info("Send a valid email");
//        Assert.assertTrue(textboxSection.fillOutForm("fran@gmail.com"), "The output section should appear");
//
//    }

    @Test(priority = 3, description = "Validate Checkbox section")
    public void fillCheckboxSection() throws InterruptedException {
        checkboxSection = (CheckboxSection) secondPage.clickOnOption("check box");

        log.info("Checking section title");
        Assert.assertEquals("Check Box".toLowerCase(), secondPage.getTitleName(), "The section title is not correct.");

        log.info("Check initial state...");
        Assert.assertEquals(1, checkboxSection.initialElementsDisplayed());
        Assert.assertFalse(checkboxSection.checkboxInitialState());
        Assert.assertTrue(checkboxSection.collapsedTreeButton());
        Assert.assertEquals("Home".toLowerCase(), checkboxSection.getOptionName());

        log.info("Click 'expand all' button");
        Assert.assertTrue(checkboxSection.clickExpandAll());

        log.info("Click 'collapse all' button");
        Assert.assertTrue(checkboxSection.clickCollapseAll());

        log.info("Click on option");
        System.out.println(checkboxSection.clickOnCheckbox("Downloads"));
//        Assert.assertTrue(checkboxSection.clickOnCheckbox("Downloads"));
    }

}
