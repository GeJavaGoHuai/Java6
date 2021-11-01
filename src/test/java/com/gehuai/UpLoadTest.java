package com.gehuai;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author huaige
 * @Description
 * @date 2021-11-01 23:26
 */
public class UpLoadTest {
    private static WebDriver driver;

    @BeforeAll
    public static void initData() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    void jsTest() {
        try {
          driver.get("https://image.baidu.com/");
          driver.findElement(By.xpath("//img[@class='st_camera_off']")).click();
          Thread.sleep(5000);
          driver.findElement(By.xpath("//input[@id='stfile']")).sendKeys("/Users/huaige/Desktop/两轮.png");
          Thread.sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void quit() {
        //关闭所有浏览器窗口
        driver.quit();
    }
}
