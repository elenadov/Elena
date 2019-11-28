package sparesTests;


import abstractParrentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "HushchynaSpare " + Utils.getDateAndTimeFormated();
    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");

        homePage.checkCurrentUrl();
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.checkCurrentUrl();
        sparePage.deleteSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();

        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareNameIntoInput(spareName);
        editSparePage.selectSpareTypeFromDropDown("Датчики");
        editSparePage.clickOnSubmitButton();

        checkExpectedResult("Can not find spare in list"
                , sparePage.isSpareInList(spareName));


    }

    @After
    public void deleteSpare(){
        sparePage.deleteSpareUntilPresent(spareName);
    }







}