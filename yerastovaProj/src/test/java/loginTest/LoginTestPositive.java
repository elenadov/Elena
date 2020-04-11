package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTestPositive {

    @Test
    public void validLogin () {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        //neyavnoe ozhidanie - implicitlyWait
        // will try each action every half of second during 5 seconds if it goes fail
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("http://v3.test.itpmgroup.com");

        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("909090");

        webDriver.findElement(By.tagName("button")).click(); //click by mouse

        Assert.assertTrue("Avatar is not present", webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed());
        Assert.assertTrue("Avatar is not present", webDriver.findElement(By.xpath(".//*[@class='user-image']")).isDisplayed());

        webDriver.quit();
    }


}
