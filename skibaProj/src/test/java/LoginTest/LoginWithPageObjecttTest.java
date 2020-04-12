package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjecttTest extends AbstractParentTest {

    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());

    }

    @Test
    public void validLogin1(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("STUDENT");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());

    }

    @Test
    public void validLogin2(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("student");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());

    }

    @Test
    public void validLogin3(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("efwe34234!!!");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is present", !homePage.isAvatarDisplayed());
        checkExpectedResult("Input Login is not present", loginPage.isInputLoginPresent());
        checkExpectedResult("input Password is not present", loginPage.isInputPasswordPresent());

    }

}
