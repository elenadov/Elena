package LoginTest;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Ignore;
import org.junit.Test;

//clean test -Dtest=LoginWithPageObjecttTest,LoginWithPageObjecttTestWithParams -Dmaven.test.failure.ignore=true allure:report

@Epic("Allure example")
@Feature("Junit 4 support")
public class LoginWithPageObjecttTest extends AbstractParentTest {
    @Description("Some detailed test description")
    @Story("Base support for bdd annotation")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());

    }

    @Description("Some detailed test description")
    @Story("Base support for bdd annotation")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Ignore // temporary skipped test
    @Test
    public void validLogin1(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("STUDENT");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());

    }

    @Description("Some detailed test description")
    @Story("Base support for bdd annotation")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void validLogin2(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("student");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());

    }

    @Description("Some detailed test description")
    @Story("Base support for bdd annotation")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
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
