package com.gehuai;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author huaige
 * @Description
 * @date 2021-11-01 23:02
 */
public class JsTest {
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
            driver.get("https://www.12306.cn/index/");
            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
            jsDriver.executeScript("window.alert('gehuai  万岁')");
            Thread.sleep(5000);
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            jsDriver.executeScript("document.getElementById('train_date').value='2029-09-08'");
            Thread.sleep(5000);
            System.out.println(jsDriver.executeScript("return document.getElementById('train_date').value"));
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
