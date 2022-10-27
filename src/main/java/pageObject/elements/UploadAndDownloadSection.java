package pageObject.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageObject.BasePage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

import static java.lang.String.*;

public class UploadAndDownloadSection extends BasePage {

    public UploadAndDownloadSection(WebDriver driver) {
        super(driver);
    }

    String lastFile;

    @FindBy(id="downloadButton")
    private WebElement downloadButton;

    private WebElement selectFile = getDriver().findElement(By.cssSelector("input[id='uploadFile']"));

    @FindBy(id="uploadedFilePath")
    private WebElement filePath;

    public void clickOnDownload(){
        clickable(downloadButton);
    }

    public void clickOnUpload() {
        clickable(selectFile);
    }

    public boolean fileExists() {
        //String file = downloadButton.getAttribute("download");
        File f = new File("C:/Users/Fran Garcia Nava/Downloads/"+ lastFile);
        return f.exists();
    }

    public boolean compareFileNames() throws AWTException {
        return getLastFileDownloaded().contains(downloadButton.getAttribute("download").replace(".jpeg",""));
    }

    public String getLastFileDownloaded() throws AWTException {
        Robot bot = new Robot();
        String mainWindow = getDriver().getWindowHandle();
        bot.keyPress(KeyEvent.VK_CONTROL);
        bot.keyPress(KeyEvent.VK_J);
        bot.keyRelease(KeyEvent.VK_CONTROL);
        bot.keyRelease(KeyEvent.VK_J);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }
        // get the latest downloaded file name
        String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");

        getDriver().close();
        // switch back to main window
        getDriver().switchTo().window(mainWindow);
        lastFile = fileName;
        return fileName;
    }

    public boolean uploadFile() {
        sendKeysField(selectFile, "C:/Users/Fran Garcia Nava/Downloads/DNI.jpg");
        return filePath.isDisplayed();
    }


}
