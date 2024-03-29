package pages;

import io.qameta.allure.Step;
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
        super(webDriver, "/login");
    } // будут содержаться все классы на логин пейдже и все действия
    @Step
    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
        } catch (Exception e) {
            Assert.fail("Cannot work with browser");
        }
    }

    @Step
    public void enterloginInToInputLogin(String login) {
        //WebElement inputLogin = webDriver.findElement(By.name("_username"));
//        inputLogin.clear();
//        inputLogin.sendKeys(login);
//        logger.info(login + " was inputed in to Input login");
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);
    }

    @Step
    public void enterPassInToInputPass(String password) {
       // WebElement inputPass = webDriver.findElement(By.id("password"));
//        inputPass.clear();
//        inputPass.sendKeys(password);
//        logger.info(password + " was inputed in to Input password");
        actionsWithOurElements.enterTextIntoInput(inputPass, password);
    }

    @Step
    public void clickOnButtonVhod() {
        //WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
//        buttonVhod.click();
//        logger.info("Button was clicked");
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

   public String currentUrl()
    {return webDriver.getCurrentUrl();
    }

    @Step
    public void fillLoginFormAndSubmitIt(String login, String password) {
        openPage();
        enterloginInToInputLogin(login);
        enterPassInToInputPass(password);
        clickOnButtonVhod();
    }
}
