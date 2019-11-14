package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import parentPage.ParentPage;

public class HomePage extends ParentPage {
    public HomePage(WebDriver webdriver) {
        super(webdriver);
    }
    public boolean isAvatarDisplayed() {
        try {
            WebElement avatar = webdriver.findElement(By.xpath(".//*[@class='pull-left image']"));
            return avatar.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
