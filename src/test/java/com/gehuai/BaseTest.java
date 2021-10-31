package com.gehuai;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author huaige
 * @Description
 * @date 2021-10-31 19:39
 */
public class BaseTest {
    public static WebDriver driver;

    @BeforeAll
    public static void initData() {
        String browserName = System.getenv("browser");
        if ("chrome".equals(browserName)) {
            // 为什么要设置这个？
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromeDriver");
            driver = new ChromeDriver();
//        } else if ("firebox".equals(browserName)) {
//            System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
//            driver = new FirefoxDriver();
//        } else if ("safari".equals(browserName)) {
//            driver = new SafariDriver();
        }
    }


    @AfterAll
    public static void quit() {
        //关闭所有浏览器窗口
        driver.quit();
    }

}
