package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{
    WebDriver driver2;

    public HomePage(WebDriver driver) {
        super(driver);
        driver2 = driver;
    }
    @FindBy(id = "close-fixedban")
    private WebElement closeBanner;

    @FindBy(className = "card")
    private List<WebElement> listOfCards;

    @Step("Select  card")
    public SecondPage goToSecondPage(String card){
        log.info("Closing banner");
        hideElement("//*[@id='fixedban']");

        log.info("Clicking on "+card+" card");
        for(WebElement webElement : listOfCards){
            if(webElement.getText().equalsIgnoreCase(card)){
                clickable(webElement);
                break;
            }
    }
        return new SecondPage(driver2);
    }

    public void hideElement(String xpath)
    {
        WebElement element = driver2.findElement(By.xpath(xpath));
        ((JavascriptExecutor)driver2).executeScript("arguments[0].style.visibility='hidden'", element);
    }
//GETTER SETTER
    public WebElement getCloseBanner() {
        return closeBanner;
    }

    public void setCloseBanner(WebElement closeBanner) {
        this.closeBanner = closeBanner;
    }
}
