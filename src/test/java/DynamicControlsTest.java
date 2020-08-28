import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicControlsTest {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void dynamicControlsTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        driver.findElement(By.xpath("//*[@id='input-example']//input"));
        try {
            driver.findElement(By.xpath("//*[@id='input-example']//input")).sendKeys("2332");}
         catch(ElementNotInteractableException e){
             System.out.println("INPUT DISABLED");
        }
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        driver.findElement(By.xpath("//*[@id='input-example']//input")).sendKeys("23232");
        driver.close();


    }
}
