package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage
{
    private WebDriver driver;
    private WebDriverWait wait;
    protected static Logger log = LogManager.getLogger();

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        this.driver = driver;
    }

    protected WebDriverWait getWait(){
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void waitElementToBeVisible(WebElement webElement){
        getWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void sendKeysField(WebElement webElement, String field){
        waitElementToBeVisible(webElement);
        webElement.sendKeys(field);
    }

    protected void clickable(WebElement webElement){
        getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    protected void explicitWait() throws InterruptedException {
        getWait().wait(3000);
    }

    public void scrollUntilSeeElement(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void clearRadioButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#yesRadio').checked = false");
        js.executeScript("document.querySelector('#impressiveRadio').checked = false");
    }

    public void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display = 'none'");
    }

    public void clearTextField(WebElement webElement){
        waitElementToBeVisible(webElement);
        webElement.clear();
    }

    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }
}
