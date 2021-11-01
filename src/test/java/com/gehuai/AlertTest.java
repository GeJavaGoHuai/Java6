package com.gehuai;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * @author huaige
 * @Description
 * @date 2021-11-02 07:35
 */
public class AlertTest {
    public static WebDriver driver;

    @BeforeAll
    public static void initData(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    void alertTest(){
        try{
            driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
            driver.switchTo().frame("iframeResult");
            Actions action=new Actions(driver);
            action.dragAndDrop( driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).perform();
            Thread.sleep(5000);
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            driver.switchTo().parentFrame();
            System.out.println(driver.findElement(By.id("submitBTN")).getText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @AfterAll
    public static void quitChrome(){
        driver.quit();
    }
}
