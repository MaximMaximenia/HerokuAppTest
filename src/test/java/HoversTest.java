import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTest {
    WebDriver browser;

    @Test
    public void hoversTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/hovers");
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img")).click();
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).click();
        WebElement error = browser.findElement(By.tagName("h1"));
        Assert.assertEquals(error.getText(),"Not Found");

        browser.get("http://the-internet.herokuapp.com/hovers");
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img")).click();
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a")).click();
        WebElement error2 = browser.findElement(By.tagName("h1"));
        Assert.assertEquals(error2.getText(),"Not Found");

        browser.get("http://the-internet.herokuapp.com/hovers");
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img")).click();
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a")).click();
        WebElement error3 = browser.findElement(By.tagName("h1"));
        Assert.assertEquals(error3.getText(),"Not Found");
        browser.quit();

}}
