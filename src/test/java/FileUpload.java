import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class FileUpload {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void dynamicControlsTest() {
        String path = System.getProperty("user.dir") + "/src/main/resources/Koala.jpg";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get("http://the-internet.herokuapp.com/upload");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("file-upload")));
        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText().trim(), "Koala.jpg");
        driver.close();


    }
}
