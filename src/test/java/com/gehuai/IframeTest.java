package com.gehuai;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author huaige
 * @Description
 * @date 2021-10-31 18:53
 */
public class IframeTest {
    private static WebDriver driver;


    @BeforeAll
    public static void initData() {
/*        System.setProperty("webdriver.chrome.driver", "/Users/huaige/Downloads/selenium/chromedriver");
          driver = new ChromeDriver();
          //建议放path变量里面，这个方法不是很好
          System.setProperty("webdriver.gecko.driver", "/Users/huaige/Downloads/selenium/geckodriver");
*/

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    void frameTest() {
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
        driver.switchTo().frame("iframeResult");
        System.out.println(driver.findElement(By.id("draggable")).getText());
        //切换到父级
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.id("submitBTN")).getText());
    }

    @AfterAll
    public static void quit() {
        //关闭所有浏览器窗口
        driver.quit();
    }
}
