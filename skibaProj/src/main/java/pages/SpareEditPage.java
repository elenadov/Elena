package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SpareEditPage extends ParentPage {

    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy(xpath = ".//option[4]")
    private WebElement valueOfDropdown;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    @FindBy(name = "add")
    private WebElement submitButton;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public SpareEditPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    @Step
    public void enterSpareNameIntoTextField(String spareName) {
        actionsWithOurElements.enterTextIntoInput(spareNameInput, spareName);
    }

    @Step
    public void clickOnClosedDropdown() {
        actionsWithOurElements.clickOnElement(spareTypeDD);
    }

    @Step
    public void clickOnValueOfDropdown() {
        actionsWithOurElements.clickOnElement(valueOfDropdown);
    }

    @Step
    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    @Step
    public void selectSpareTypeFromDropdown(String spareType) {
        actionsWithOurElements.selectVisibleTextFromDDByJava(spareTypeDD, spareType);
    }

    @Step
    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    @Step
    public void clickOnDeleteButton() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
