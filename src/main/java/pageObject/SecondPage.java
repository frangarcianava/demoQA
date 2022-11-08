package pageObject;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.alertsFrameWindows.BrowserWindows;
import pageObject.elements.CheckboxSection;
import pageObject.elements.RadiobuttonSection;
import pageObject.elements.TextboxSection;
import pageObject.elements.UploadAndDownloadSection;

import java.util.List;

public class SecondPage extends BasePage{
    WebDriver driver2;

    public SecondPage(WebDriver driver) {
        super(driver);
        driver2=driver;
    }

    @FindBy(className = "main-header")
    private WebElement pageTitle;

    @FindBy(css = ".element-list.collapse.show")
    private WebElement accordion;

    @FindBy(css=".element-group .btn.btn-light")
    private List<WebElement> listOfOptions;

    @FindBy(className = "element-group")
    private List<WebElement> listOfSections;


    public BasePage clickOnOption(String option){
        log.info("Clicking on " +option+ " option");
        hideFooter();
        BasePage section = null;
        for(WebElement options : listOfOptions){
            if(options.getText().equalsIgnoreCase(option)){
                clickable(options);
                section  = getBasePage(option, options);
                return section;
            }
        }
        return section;
    }

    private BasePage getBasePage(String option, WebElement options) {
        switch (options.getText()){
            case "Text Box":
                clickable(options);
                return new TextboxSection(driver2);
            case "Check Box":
                clickable(options);
                return new CheckboxSection(driver2);
            case "Radio Button":
                clickable(options);
                return new RadiobuttonSection(driver2);
            case "Upload and Download":
                scrollUntilSeeElement(options);
                clickable(options);
                return new UploadAndDownloadSection(driver2);
            case "Browser Windows":
                scrollUntilSeeElement(options);
                clickable(options);
                return new BrowserWindows(driver2);
            default:
                throw new InvalidArgumentException(option);
        }
    }

    //Functions for assertions
    public String getTitleName(){
        waitElementToBeVisible(pageTitle);
        return pageTitle.getText().toLowerCase();
    }
    public boolean isExpanded(){
        return accordion.isDisplayed();
    }
}
