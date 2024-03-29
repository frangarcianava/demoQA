package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.elements.CheckboxSection;
import pageObject.elements.RadiobuttonSection;
import pageObject.elements.TextboxSection;
import pageObject.elements.UploadAndDownloadSection;

import java.awt.*;

public class ElementTest extends BaseTest {

    @Test(priority = 1, description = "Validate that the elements section is opened")
    public void clickOnElementsSection() {
        secondPage = homePage.goToSecondPage("Elements");

        Assert.assertEquals("Elements".toLowerCase(), secondPage.getTitleName(), "The section title is not correct.");
        Assert.assertTrue(secondPage.isExpanded(), "The menu list of " + secondPage.getTitleName() + " should be expanded");
    }

    @Test(priority = 2, description = "Validate Textbox section")
    public void fillTextBoxSection() throws InterruptedException {
        textboxSection = (TextboxSection) secondPage.clickOnOption("text box");

        log.info("Checking section title");
        Assert.assertEquals("Text Box".toLowerCase(), secondPage.getTitleName(), "The section title is not correct.");

        log.info("Filling data...");
        log.info("Send a wrong email");
        Assert.assertTrue(textboxSection.fillOutForm("frangmail.com"), "The email field should be throw an error");

        log.info("Send a valid email");
        Assert.assertTrue(textboxSection.fillOutForm("fran@gmail.com"), "The output section should appear");

    }

    //    @Test(priority = 3, description = "Validate Checkbox section")
    public void fillCheckboxSection() {
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

    //    @Test(priority = 4, description = "Validate Radiobutton section")
    public void validateRadiobuttonSection() {
        radiobuttonSection = (RadiobuttonSection) secondPage.clickOnOption("radio button");

        log.info("Checking section title");
        Assert.assertEquals("Radio Button".toLowerCase(), secondPage.getTitleName(), "The section title is not correct.");

        log.info("Check initial state...");
        radiobuttonSection.clearRadioButtons();
        Assert.assertFalse(radiobuttonSection.noRadioButton());
        Assert.assertFalse(radiobuttonSection.outputDisplayed());

        log.info("Check message when 'YES' option is selected");
        radiobuttonSection.clickRadioButton("yes");
        Assert.assertTrue(radiobuttonSection.outputDisplayed());
        Assert.assertTrue(radiobuttonSection.getOutput().contains("yes"));
        Assert.assertEquals(radiobuttonSection.getOptionColor(), "#28a745");


        log.info("Check message when 'Impressive' option is selected");
        radiobuttonSection.clickRadioButton("impressive");
        Assert.assertTrue(radiobuttonSection.outputDisplayed());
        Assert.assertTrue(radiobuttonSection.getOutput().contains("impressive"));
        Assert.assertEquals(radiobuttonSection.getOptionColor(), "#28a745");

    }

    //    @Test(priority = 5, description = "Validate Upload and Download section")
    public void validateUploadAndDownloadSection() throws InterruptedException, AWTException {
        uploadAndDownloadSection = (UploadAndDownloadSection) secondPage.clickOnOption("upload and download");

        log.info("Checking section title");
        Assert.assertEquals("Upload and download".toLowerCase(), secondPage.getTitleName(), "The section title is not correct.");

        log.info("Downloading file...");
        uploadAndDownloadSection.clickOnDownload();

        log.info("Checking if the file is downloaded successfully");
        Assert.assertTrue(uploadAndDownloadSection.compareFileNames());
        Assert.assertTrue(uploadAndDownloadSection.fileExists());

        log.info("Select file to upload...");
        Assert.assertTrue(uploadAndDownloadSection.uploadFile());
    }
}
