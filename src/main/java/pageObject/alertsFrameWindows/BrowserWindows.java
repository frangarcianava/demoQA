package pageObject.alertsFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserWindows extends BasePage {
    public BrowserWindows(WebDriver driver) {
        super(driver);
    }
    List<String> browserTabs;
    String currentPage = getDriver().getWindowHandle();

    @FindBy(id="tabButton")
    private WebElement newTabButton;

    @FindBy(id="windowButton")
    private WebElement newWindowButton;

    @FindBy(id="messageWindowButton")
    private WebElement newWindowMessageButton;

    public int checkNewTabIsOpened(){
        clickable(newTabButton);
        browserTabs = new ArrayList<>(getDriver().getWindowHandles());
        return browserTabs.size();
    }

    public String checkNewTabData(){
        getDriver().switchTo().window(browserTabs.get(1));
        return getDriver().getCurrentUrl();
    }

    public void closeTab(){
        getDriver().close();
        getDriver().switchTo().window(currentPage);
    }

    public void clickNewWindow(){
        clickable(newWindowButton);
    }

}
