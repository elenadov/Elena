package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/");
        } catch (Exception e) {
            Assert.fail("Can't work with browser");
        }
    }

    public void enterLoginInToInputLogin(String login) {
        // WebElement inputLogin = webDriver.findElement(By.name("_username"));
        //inputLogin.clear();
        //inputLogin.sendKeys(login);
        //logger.info(login + " was inputed to input Login");
        actionWithOurElements.enterTextInToInput(inputLogin, login);

    }

    public void enterPassInToInputPassWord(String password) {
        actionWithOurElements.enterTextInToInput(inputPass, password);

    }

    public void clickOnButtonVhod() {
        //WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
        actionWithOurElements.clickOnElement(buttonVhod);
    }

    public void fillingLoginFormAndSubmitIt(String login, String pass) {
        openPage();
        enterLoginInToInputLogin(login);
        enterPassInToInputPassWord(pass);
        clickOnButtonVhod();
    }
}