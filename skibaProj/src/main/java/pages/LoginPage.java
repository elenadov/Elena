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
    private WebElement inputPassword;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try{
            webDriver.get("http://v3.test.itpmgroup.com");

        }catch(Exception e){
            Assert.fail("Cannot work with browser");

        }
    }

    public void enterLoginIntoInputLogin(String login) {
//        WebElement inputLogin = webDriver.findElement(By.name("_username"));
//        inputLogin.clear();
//        inputLogin.sendKeys(login);
//        logger.info(login + " was entered into input Login");
        actionsWithOurElements.enterTextIntoInput(inputLogin, login);
    }

    public void enterPassIntoInputPassword(String password) {
//        WebElement inputPassword = webDriver.findElement(By.id("password"));
//        inputPassword.clear();
//        inputPassword.sendKeys(password);
//        logger.info(password + " was entered into input Password");
        actionsWithOurElements.enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonVhod() {
//        WebElement buttonVhod = webDriver.findElement(By.tagName("button"));
//        buttonVhod.click();
//        logger.info("Button Vhod was clicked");
        actionsWithOurElements.clickOnElement(buttonVhod);
    }

    public boolean isInputLoginPresent(){
        try {
//            WebElement inputLogin = webDriver.findElement(By.name("_username"));
            return inputLogin.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public boolean isInputPasswordPresent(){
        try {
//            WebElement inputPassword = webDriver.findElement(By.id("password"));
            return inputPassword.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public void fillingLoginFormAndSubmitIt(String login, String password) {
        openPage();
        enterLoginIntoInputLogin(login);
        enterPassIntoInputPassword(password);
        clickOnButtonVhod();
    }
}
