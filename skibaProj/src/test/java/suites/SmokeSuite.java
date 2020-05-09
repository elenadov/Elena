package suites;

import LoginTest.LoginWithPageObjecttTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spareTests.SparesTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObjecttTest.class,
                SparesTest.class
        }
)
public class SmokeSuite {
}
