import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataTablesTest {
    WebDriver browser;
    @Test
    public void dataTablesTest (){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        browser = new ChromeDriver(options);
        browser.get("http://the-internet.herokuapp.com/tables");
        String smithLastName =  browser.findElement(By.xpath("//table//tr[1]//td[1]")).getText();
        String smithMail =  browser.findElement(By.xpath("//table//tr[1]//td[3]")).getText();
        String smithFirstName =  browser.findElement(By.xpath("//table//tr[1]//td[2]")).getText();

        String bachLastName =  browser.findElement(By.xpath("//table//tr[2]//td[1]")).getText();
        String bachFirstName =  browser.findElement(By.xpath("//table//tr[2]//td[2]")).getText();
        String bachMail =  browser.findElement(By.xpath("//table//tr[2]//td[3]")).getText();

        Assert.assertEquals(smithFirstName,"John");
        Assert.assertEquals(smithLastName,"Smith");
        Assert.assertEquals(smithMail,"jsmith@gmail.com");
        Assert.assertEquals(bachFirstName,"Frank");
        Assert.assertEquals(bachLastName,"Bach");
        Assert.assertEquals(bachMail,"fbach@yahoo.com");

        browser.close();

            }

        }

