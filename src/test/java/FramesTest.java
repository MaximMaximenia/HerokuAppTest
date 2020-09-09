import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest {


    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void dynamicControlsTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.cssSelector("a[href=\"/iframe\"]")).click();
        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);
        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(), "Your content goes here.");
    }
}
