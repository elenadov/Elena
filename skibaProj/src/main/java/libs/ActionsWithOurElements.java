package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoInput(WebElement webElement, String text){
        try{
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was entered into input successfully");
        }catch(Exception e){
            stopTestAndPrintMessage();
        }
    }

    public void clickOnElement(WebElement webElement){
        try{
            webElement.click();
            logger.info("Element was clicked successfully");
        }catch(Exception e){
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("IsElementDisplayed -> " + state);
            return state;
        } catch (Exception e) {
            logger.info("IsElementDisplayed -> false");
            return false;
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Cannot work with element");
        Assert.fail("Cannot work with element");
    }

    public void selectValueFromDDByJava(WebElement dropdown, String value) {
        try{
            Select select = new Select(dropdown);//class for working with dropdowns (if in code are "option" and "select")
            select.selectByValue(value);
            logger.info(value + " was selected in dropdown");

        }catch(Exception e){
            stopTestAndPrintMessage();
        }
    }

    public void selectVisibleTextFromDDByJava(WebElement dropdown, String text) {
        try{
            Select select = new Select(dropdown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in dropdown");

        }catch(Exception e){
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(String locator) {
        try{
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        }catch(Exception e){
            return false;
        }
    }

    public void clickOnElement(String xpath) {
        try{
            clickOnElement(webDriver.findElement(By.xpath(xpath)));
        }catch(Exception e){
            stopTestAndPrintMessage();
        }

    }
}
