package com.gehuai;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author huaige
 * @Description
 * @date 2021-10-31 15:19
 */
public class WindowTest {
    //为啥一定要static修饰
    private static WebDriver driver;

    @BeforeAll
    public static void initData() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    void switchWindowTest() throws Exception {
        //打开浏览器
        driver.get("https://www.baidu.com/");
        //点击登录
        driver.findElement(By.id("s-top-loginbtn")).click();

        //*[@id="passport-login-pop-dialog"]/div/div/div/div[2]/a   利用chrome 复制过来的xpath路径
        //div[@id='passport-login-pop-dialog']//div/a[@class='pass-reglink pass-link'   我自己写的
        //a[@class='pass-reglink pass-link'


        String baiduHandle = driver.getWindowHandle();
        //点击注册
        driver.findElement(By.xpath("//a[@class='pass-reglink pass-link']")).click();

        for (String win : driver.getWindowHandles()) {
            if (!win.equals(baiduHandle)) {
                //切换到注册win
                driver.switchTo().window(win);
                //注册用户名
                driver.findElement(By.name("userName")).sendKeys("gehuai097878h");
                //注册手机号
                driver.findElement(By.name("phone")).sendKeys("18917070142");
                //密码
                driver.findElement(By.id("TANGRAM__PSP_4__password")).sendKeys("gh668899");
                //切换回到登录的窗口
                driver.switchTo().window(baiduHandle);
                //输入手机号码
                driver.findElement(By.name("userName")).sendKeys("18917079142");
                //输入密码
                driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("gh668899");
                //点击登录
                driver.findElement(By.id("TANGRAM__PSP_11__submit")).click();
                Thread.sleep(5000);
            }
        }
    }

    @AfterAll
    public static void quit() {
        //关闭所有浏览器窗口
        driver.quit();
    }

}
