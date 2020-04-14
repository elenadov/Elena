package spareTests;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {

    private final String spareName = "TestSpareName"; //input value to check in the table

    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");

        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.clickOnAddButton();

        spareEditPage.enterSpareNameIntoTextField(spareName);
        spareEditPage.selectSpareTypeFromDropdown("Датчики"); //java selection
        spareEditPage.clickOnSubmitButton();

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
    }

    @After
    public void deleteSpare(){
        sparePage.deleteSpareUntilPresent(spareName);
    }
}
