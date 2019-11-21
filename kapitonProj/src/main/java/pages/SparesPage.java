package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparesPage extends ParentPage {
    @FindBy(xpath = "//*[@class = 'fa fa-plus']")
    private WebElement buttonAdd;


    public SparesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAddButton() {
        actionWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) {
        return actionWithOurElements.isElementDisplayed(".//*[text()='" + spareName + "']"); //параматризированый локатор
    }

    public void deleteSpareUntilPresent(String spareName) {
        EditSparePage editSparePage = new EditSparePage(webDriver);
        while (isSpareInList(spareName)){
            clickOnSpare(spareName);
            editSparePage.clickOnDeleteButton();

        }
    }

    private void clickOnSpare(String spareName) {
        actionWithOurElements.clickOnElement(".//*[text()='" + spareName + "']");
    }
}