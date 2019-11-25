package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import javax.management.ValueExp;
import java.util.List;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    private final String CHECK_BOX_SELECTED = "Selected";
    private final String CHECK_BOX_UNSELECTED = "Unselected";

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextIntoInput(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed into input");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("is element displayed -> " + state);
            return state;
        } catch (Exception e) {
            logger.info("is element displayed ->  false");
            return false;
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked");

        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");
    }

    public void selectValueinDDbyJava(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in drop down");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }


    public void selectValueInSpareDDXpathByOption(WebElement dropdown, String option) {
        clickOnElement(dropdown);
        clickOnElement("//select[@id='spares_spareType']/option[@value ='" + option + "']");
        logger.info(option + " was selected in drop down");
    }


    public void selectValueInSpareDDXpathByText(WebElement dropdown, String text) {
        clickOnElement(dropdown);
        clickOnElement("//select[@id='spares_spareType']/option[text()='"+ text+"']");
        logger.info(text + " was selected in drop down");
    }

    public void selectVisibleTextInDDbyJava(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in drop down");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }



    public boolean isElementDisplayed(String locator) {
        try {
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(String xpath) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(xpath)));
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void setStateToCheckBox(WebElement webelement, String expectedState) {
        if (!(expectedState.equals(CHECK_BOX_SELECTED) || expectedState.equals(CHECK_BOX_UNSELECTED))) {
            logger.info("Expected State is not correct");
            stopTestAndPrintMessage();
        }
        boolean isSelected = isCheckboxSelected(webelement);
        logger.info("Checkbox is selected: " + isSelected);
        if (isSelected) {
            if ((expectedState.equals(CHECK_BOX_SELECTED))) {
                logger.debug("Nothing todo");
            } else {
                logger.info("Setting checkbox to: " + expectedState);
                webelement.click();
            }
        } else {
            if ((expectedState.equals(CHECK_BOX_SELECTED))) {
                logger.info("Setting checkbox to: " + expectedState);
                webelement.click();
            } else {
                logger.debug("Nothing todo");
            }
        }
    }


    public boolean isCheckboxSelected(WebElement checkbox) {

        try {
            return checkbox.isSelected();
        } catch (Exception e) {
            logger.info("There is error with checkbox");
            return false;
        }

    }
}
