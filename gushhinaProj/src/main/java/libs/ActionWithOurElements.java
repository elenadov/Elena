package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ActionWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked.");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(WebElement webElement){
        try{
            boolean state=webElement.isDisplayed();
            logger.info("Is element displayed - "+ state);
            return state;

        }catch (Exception e){
            logger.info("Is element displayed - "+ false);
            return false;
        }
    }

    public void enterTextInToInput(WebElement webElement, String text){
        try{
         webElement.clear();
         webElement.sendKeys(text);
         logger.info(text + " was imputed in to the input.");

        }catch (Exception e ) {
            stopTestAndPrintMessage();
        }

    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");
    }
    public void selectValueInDDByJava(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in Drop Down");
        }catch (Exception e){
            stopTestAndPrintMessage();
        }
    }

    public void selectVisibleTextInDDByJava(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in Drop Down");
        }catch (Exception e){
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(String locator) {
        try{
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        }catch (Exception e){
            return false;
        }
    }

    public void clickOnElement(String xpath) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(xpath)));
        }catch (Exception e){
            stopTestAndPrintMessage();
        }
    }
    public void setStateToCheckBox (WebElement checkBox, String state){
        boolean isStateCheck = state.toLowerCase().equals("check");
        boolean isStateUnCheck = state.toLowerCase().equals("uncheck");
        boolean isCheckBoxSelect = checkBox.isSelected();
        if(isStateCheck || isStateUnCheck){
            if((isStateCheck && isCheckBoxSelect) || (isStateUnCheck && !isCheckBoxSelect)){
                logger.info("CheckBox is already in needed state.");
            }else if ((isStateCheck && !isCheckBoxSelect) || (isStateUnCheck && isCheckBoxSelect)){
                clickOnElement(checkBox);
            }

        }else {
            logger.error("State should be only 'check' or 'uncheck'." );
            stopTestAndPrintMessage();
        }
    }
}