package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditSparePage extends ParentPage {
    @FindBy(id = "spares_spareName")
    private WebElement inputSpareName;
    @FindBy(id ="spares_spareType")
    private WebElement spareTypeField;
    @FindBy(xpath = ".//*[@class='form-control']/*[text()='Датчики']")
    private WebElement spareTypeName;
    @FindBy (name = "add")
    private WebElement submitButton;


    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextInToInput(inputSpareName, spareName);
    }

    public void selectSpareTypeFromDropDown() {
        actionsWithOurElements.clickOnElement(spareTypeField);
        actionsWithOurElements.clickOnElement(spareTypeName);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }
}
