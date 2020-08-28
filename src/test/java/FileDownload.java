import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class FileDownload {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void downloadTxtTest() throws InterruptedException {
        String downloadFilePath = "C:\\Users\\Admin\\IdeaProjects\\HerokuAppTest\\src\\main\\resources\\DownloadFiles";
        Map<String, Object> preferences = new Hashtable<String, Object>();
        preferences.put("download.default_directory", downloadFilePath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", preferences);

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 20);
        driver.get("http://the-internet.herokuapp.com/download");
        driver.findElement(By.cssSelector("a[href=\"download/test file 2.txt\"]")).click();
        Thread.sleep(5000);
        driver.close();
        File txt = new File("src/main/resources/DownloadFiles/test file 2.txt");
        Assert.assertTrue(txt.isFile());

    }

    @Test
    public void downloadPngTest() throws InterruptedException, IOException {
        String downloadFilePath = "C:\\Users\\Admin\\IdeaProjects\\HerokuAppTest\\src\\main\\resources\\DownloadFiles";
        Map<String, Object> preferences = new Hashtable<String, Object>();
        preferences.put("download.default_directory", downloadFilePath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", preferences);

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 20);
        driver.get("http://the-internet.herokuapp.com/download");
        driver.findElement(By.cssSelector("a[href=\"download/TestPic.png\"]")).click();
        Thread.sleep(5000);
        driver.close();
        File png = new File("src/main/resources/DownloadFiles/TestPic.png");
        Assert.assertTrue(png.isFile());
    }
}
