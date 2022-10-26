package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxSection extends BasePage{
    public CheckboxSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "rct-title")
    private List<WebElement> treeTitle;

    @FindBy(className = "rct-checkbox")
    private List<WebElement> treeCheckbox;

    @FindBy(className = "rct-collapse-btn")
    private List<WebElement> treeExpandButton;

    @FindBy(className = "rct-option-collapse-all")
    private WebElement collapseAllButton;

    @FindBy(className = "rct-option-expand-all")
    private WebElement expandAllButton;

    @FindBy(className = "rct-node-expanded")
    private List<WebElement> expandedSections;

    @FindBy(className = "rct-node-collapsed")
    private List<WebElement> collapsedSections;

    @FindBy(className = "rct-node-leaf")
    private List<WebElement> childs;

    public int initialElementsDisplayed(){
        clickable(collapseAllButton);
        return treeCheckbox.size();
    }
    public boolean checkboxInitialState(){
        return treeCheckbox.get(0).isSelected();
    }
    public boolean collapsedTreeButton(){
        return collapsedSections.size() == 1 && expandedSections.size() == 0;
    }
    public String getOptionName(){
        return treeTitle.get(0).getText().toLowerCase();
    }

    public boolean clickExpandAll(){
        clickable(expandAllButton);
        return collapsedSections.size()==0;
    }
    public boolean clickCollapseAll(){
        clickable(collapseAllButton);
        return expandedSections.size()==0;
    }

    public boolean clickOnCheckbox(String option) throws InterruptedException {
        clickable(treeExpandButton.get(0));
        for(int i=0;i<treeCheckbox.size();i++) {
            if (treeTitle.get(i).getText().equalsIgnoreCase(option)) {
                clickable(treeCheckbox.get(i));
                Thread.sleep(5000);
                System.out.println("Checkbox selected: "+treeCheckbox.get(i).toString());
                return treeCheckbox.get(i).isSelected();
            }
        }
        return false;
    }

}
