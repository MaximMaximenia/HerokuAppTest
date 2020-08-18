import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddRemoveElements {
    WebDriver browser;

    @Test
    public void addTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        browser = new ChromeDriver(options);
        browser.manage().window().maximize(); // !!!!!!!!!!!!!!!!!!!
        browser.get("http://the-internet.herokuapp.com/add_remove_elements/");
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        browser.findElement(By.xpath("//*[@id=\"elements\"]/button[1]")).click();
        List<WebElement> allDeleteElements = browser.findElement(By.xpath("//*[@id=\"elements\"]")).findElements(By.tagName("button"));
        Assert.assertEquals(allDeleteElements.size(), 1);
        browser.close();

    }
}
