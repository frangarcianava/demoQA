package pageObject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RadiobuttonSection extends BasePage{
    public RadiobuttonSection(WebDriver driver) { super(driver); }

    @FindBy(xpath="//label[@for='yesRadio']")
    private WebElement yesRadio;

    @FindBy(css="label[for='impressiveRadio']")
    private WebElement impressiveRadio;

    @FindBy(id="noRadio")
    private WebElement noRadio;

    @FindBy(className = "mt-3")
    private WebElement output;

    @FindBy(className = "text-success")
    private WebElement optionSuccess;

    public boolean noRadioButton(){
        return noRadio.isEnabled();
    }

    public boolean outputDisplayed(){
        try{
            return output.isDisplayed();
        }catch(NoSuchElementException ex){
            return false;
        }
    }

    public String getOutput(){
        waitElementToBeVisible(output);
        System.out.println(output.getText());
        return output.getText().toLowerCase();
    }

    public void clickRadioButton(String option){
        if(option.equalsIgnoreCase("yes")){
            clickable(yesRadio);
        }else{
            clickable(impressiveRadio);
        }
    }

    public String getOptionColor(){
        String rgba = optionSuccess.getCssValue("color");
        return Color.fromString(rgba).asHex();
    }

    public void clearRadioButtons(){
        clearRadioButton();
    }

}
