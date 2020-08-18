import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FindElementsInMyHTML {
    WebDriver browser;

    @Test
    public void findTable() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("C:\\Users\\Admin\\IdeaProjects\\HerokuAppTest\\src\\main\\resources\\HTMLWork.html");
        String name = browser.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]")).getText();
        String age = browser.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[3]")).getText();
        String gender = browser.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[4]")).getText();
        Assert.assertEquals(name, "Max");
        Assert.assertEquals(age, "26");
        Assert.assertEquals(gender, "Male");


    }

    @Test
    public void findInputs() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("C:\\Users\\Admin\\IdeaProjects\\HerokuAppTest\\src\\main\\resources\\HTMLWork.html");
        Assert.assertEquals(browser.findElement(By.name("fname")).getText(), "");
        Assert.assertEquals(browser.findElement(By.id("age")).getAttribute("value"), "25");
    }

    @Test
    public void testCheckbox() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("C:\\Users\\Admin\\IdeaProjects\\HerokuAppTest\\src\\main\\resources\\HTMLWork.html");
        Assert.assertEquals(browser.findElement(By.id("female")).getAttribute("checked"), "true");
        Assert.assertEquals(browser.findElement(By.id("other")).getAttribute("checked"), null);
        browser.findElement(By.id("male")).click();
        Assert.assertEquals(browser.findElement(By.id("male")).getAttribute("checked"), "true");

    }

    @Test
    public void findButton() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("C:\\Users\\Admin\\IdeaProjects\\HerokuAppTest\\src\\main\\resources\\HTMLWork.html");
        Assert.assertEquals(browser.findElement(By.id("reg_button")).getAttribute("value"), "Register client!");
    }

    @Test
    public void findParagraph() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("C:\\Users\\Admin\\IdeaProjects\\HerokuAppTest\\src\\main\\resources\\HTMLWork.html");
        Assert.assertEquals(browser.findElement(By.id("citation")).getText(), "the wolf is weaker than the lion and the tiger but does not perform in the circus");


    }

    @Test
    public void findImage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("C:\\Users\\Admin\\IdeaProjects\\HerokuAppTest\\src\\main\\resources\\HTMLWork.html");
        Assert.assertEquals(browser.findElement(By.id("wolf")).getAttribute("src"), "https://funik.ru/wp-content/uploads/2018/11/504cbccbef3fe5a08e9c.jpg");


    }
    @Test
    public void testHyper() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("C:\\Users\\Admin\\IdeaProjects\\HerokuAppTest\\src\\main\\resources\\HTMLWork.html");
        browser.findElement(By.id("hyper")).click();
        browser.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
       Assert.assertEquals(browser.findElement(By.xpath("//*[@id=\"main\"]/h2[1]")).getText(),"Definition and Usage");

    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        browser.close();
    }
}
