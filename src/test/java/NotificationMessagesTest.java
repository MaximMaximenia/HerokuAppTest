import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessagesTest {
    WebDriver browser;
    @Test
    public void notificationMessageTest (){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        browser = new ChromeDriver(options);
        browser.get("http://the-internet.herokuapp.com/notification_message_rendered");
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/p/a")).click();
        String text = browser.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
        Assert.assertEquals(text,"Action successful\n" +
                "×");
        browser.quit();


}}
