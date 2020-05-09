package parentPage;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.pageElements.WebDriverAwareDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;


public class ParentPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionsWithOurElements actionsWithOurElements;

    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseURL;//here we will write down domen name - http://v3.test.itpmgroup.com/...
    String expectedURL;//consists of baseURL and URL of each page

    public ParentPage(WebDriver webDriver, String partURL) {
        this.webDriver = webDriver;
        baseURL = configProperties.base_url();

//        PageFactory.initElements(webDriver, this);
//        PageFactory.initElements(
//        new HtmlElementDecorator(
//                new HtmlElementLocatorFactory(webDriver))
//                ,this);

        PageFactory.initElements(
                new WebDriverAwareDecorator(
                        new HtmlElementLocatorFactory(webDriver),webDriver),this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
//        will initialize (after creation of object in AbstractParentTest) @FindBy annotation creation of variables
//        "This" means initialize me variable from the page where the action was made
        expectedURL = baseURL + partURL;
    }

    public void checkCurrentURL(){
        try{
            Assert.assertEquals("URL is not expected", expectedURL, webDriver.getCurrentUrl());

        }catch(Exception e){
            logger.error("Cannot get URL" + e);
            Assert.fail("Cannot get URL" + e);
        }
    }
}
