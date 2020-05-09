package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class) //will run test with different parameters

public class LoginWithPageObjecttTestWithParams extends AbstractParentTest {

    String login, pass;

    public LoginWithPageObjecttTestWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    //this block will give us parameters, one by one
    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][] {
                    {"Student", "906090"}, //each row is separate set of data = number of run of test case
                    {"login", "909090"}
                }
        );
    }

    @Test
    public void unValidLogin(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin(login);
        loginPage.enterPassIntoInputPassword(pass);
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar should not be present", !homePage.isAvatarDisplayed());

    }

}
