package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(css=".element-group:nth-child(1) .element-list.collapse.show .btn.btn-light")
    private List<WebElement> elementOptions;

    public BasePage clickOnOption(String option){
        log.info("Clicking on " +option+ " option");
        for(WebElement options : elementOptions){
            if(options.getText().equalsIgnoreCase(option)){
                clickable(options);
                switch (options.getText()){
                    case "Text Box":
                        clickable(options);
                        TextboxSection textboxSection = new TextboxSection(driver2);
                        return textboxSection;
                    case "Check Box":
                        clickable(options);
                        CheckboxSection checkboxSection = new CheckboxSection(driver2);
                        return checkboxSection;
                    case "Radio Button":
                        clickable(options);
                        RadiobuttonSection radiobuttonSection = new RadiobuttonSection(driver2);
                        return radiobuttonSection;
                    case "Web Tables":
                        break;
                    case "Buttons":
                        break;
                    case "Links":
                        break;
                    case "Broken Links - Images":
                        break;
                    case "Upload and Download":
                        break;
                    case "Dynamic Properties":
                        break;
            }
            }
        }
        return null;
    }

    //Functions for assertions
    public String getTitleName(){
        waitElementToBeVisible(pageTitle);
        return pageTitle.getText().toLowerCase();
    }
    public boolean isExpanded(){
        return accordion.isDisplayed();
    }

    public TextboxSection openPage(){
        return new TextboxSection(driver2);
    }
}
