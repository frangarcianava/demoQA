package pageObject.elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.BasePage;


public class TextboxSection extends BasePage {

    public TextboxSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userName")
    private WebElement username;

    @FindBy(id="userEmail")
    private WebElement email;

    @FindBy(id = "currentAddress")
    private WebElement address;

    @FindBy(id="permanentAddress")
    private WebElement permanentAddress;

    @FindBy(id="submit")
    private WebElement submitBtn;

    @FindBy(id="output")
    private WebElement output;

    @FindBy(className = "field-error")
    private WebElement errorEmail;

    public boolean fillOutForm(String emailData) throws InterruptedException {
        clearFields();
        sendKeysField(username, "Francisco");
        sendKeysField(address, "Avellaneda223");
        sendKeysField(permanentAddress, "Besares 39");
        sendKeysField(email, emailData);
        scrollUntilSeeElement(submitBtn);
        clickable(submitBtn);
        if(!emailData.contains("@")){
            return errorEmail.isDisplayed();
        }else{
            return output.isDisplayed();
        }
    }

    public void clearFields(){
        clearTextField(username);
        clearTextField(address);
        clearTextField(permanentAddress);
        clearTextField(email);
    }
}
