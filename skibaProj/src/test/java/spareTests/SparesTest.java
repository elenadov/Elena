package spareTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {

    private final String spareName = "TestSpareName_"+ Utils.getDateAndTimeFormated(); //input value to check in the table

    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");

        homePage.checkCurrentURL();
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.checkCurrentURL();
        sparePage.deleteSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();

        spareEditPage.checkCurrentURL();
        spareEditPage.enterSpareNameIntoTextField(spareName);
        spareEditPage.selectSpareTypeFromDropdown("Датчики"); //java selection
        spareEditPage.clickOnSubmitButton();

        sparePage.checkCurrentURL();
        checkExpectedResult("Can not find spare in list", sparePage.isSpareInList(spareName));
    }

    @Test
    public void addNewSpare1(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");

        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.clickOnAddButton();

        spareEditPage.enterSpareNameIntoTextField("Test");
        spareEditPage.clickOnClosedDropdown();
        spareEditPage.clickOnValueOfDropdown();
        spareEditPage.clickOnSubmitButton();

        checkExpectedResult("Can not find spare in list", sparePage.isSpareInList(spareName));
    }

    @After
    public void deleteSpare(){
        sparePage.deleteSpareUntilPresent(spareName);
    }
}
