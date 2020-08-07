import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsTest {
    WebDriver browser;
    @Test
    public void validateInput (){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        browser = new ChromeDriver(options);
        browser.manage().window().maximize(); // !!!!!!!!!!!!!!!!!!!
        browser.get( "http://the-internet.herokuapp.com/inputs");
        WebElement input = browser.findElement(By.tagName("input"));
        input.sendKeys("18");
        input.sendKeys(Keys.ARROW_DOWN);
        String text = input.getAttribute("value");
        Assert.assertEquals(text,"17");
        input.clear();
        text = input.getAttribute("value");
        Assert.assertEquals(text,"");
        browser.close();

}}
