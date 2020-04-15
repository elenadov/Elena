package abstractParentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SpareEditPage;
import pages.SparePage;

import javax.xml.ws.WebServiceProvider;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparePage sparePage;
    protected SpareEditPage spareEditPage;

    @Before //this method will setUp our tests before every test
    public void setUp() throws Exception {
//        File file = new File("./src/drivers/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        webDriver = new ChromeDriver();
        webDriver = driverInit();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        spareEditPage = new SpareEditPage(webDriver);
    }

    //browser should be installed physical in the system
    private WebDriver driverInit() throws Exception {
        String browser = System.getProperty("browser");
        if((browser == null) || ("chrome".equalsIgnoreCase(browser))){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if("firefox".equalsIgnoreCase(browser)){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if("ie".equalsIgnoreCase(browser)){
            WebDriverManager.iedriver().arch32().setup();//32-bit
            return new InternetExplorerDriver();
        } else {
            throw new Exception("Check browser variable"); //neyavnaia obrabotka of exception
        }
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }

    protected void checkExpectedResult(String message, boolean expectedResult, boolean actualResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }

}


//-ea -Dbrowser=firefox
//-ea -Dbrowser=ie