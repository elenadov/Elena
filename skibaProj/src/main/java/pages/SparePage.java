package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparePage extends ParentPage {

    @FindBy(xpath = ".//*[@class='fa fa-plus']") //here we have 2 classes, so we can't use className instead of xpath
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    @Step
    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    @Step
    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementDisplayed(".//*[text()='" + spareName + "']");
    }

    @Step
    public void deleteSpareUntilPresent(String spareName) {
        int counter = 0;
        SpareEditPage spareEditPage = new SpareEditPage(webDriver);
        while(isSpareInList(spareName)){
            clickOnSpare(spareName);
            spareEditPage.clickOnDeleteButton();
            logger.info((counter + 1) + " spare was deleted");
            if(counter>100){
                Assert.fail("There are more than 100 spares.");
            }
            counter++;
        }
    }

    @Step
    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(".//*[text()='" + spareName + "']");
    }
}