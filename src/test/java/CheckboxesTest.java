import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {
    WebDriver browser;

    @Test
    public void addTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        browser = new ChromeDriver(options);
        //1checkbox
        browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = browser.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        Assert.assertEquals(checkbox1.getAttribute("checked"), null);
        checkbox1.click();
        Assert.assertEquals(checkbox1.getAttribute("checked"), "true");
        //2checkbox
        WebElement checkbox2 = browser.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        checkbox2.getAttribute("checked");
        Assert.assertEquals(checkbox2.getAttribute("checked"), "true");
        checkbox2.click();
        Assert.assertEquals(checkbox2.getAttribute("checked"), null);
        browser.close();
    }
}
