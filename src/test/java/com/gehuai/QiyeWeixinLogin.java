package com.gehuai;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author huaige
 * @Description
 * @date 2021-11-03 08:05
 */
public class QiyeWeixinLogin {
    private static WebDriver driver;


    @BeforeAll
    public static void initData() {
        driver = new ChromeDriver();
        //隐式等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //最大化
        driver.manage().window().maximize();
    }

    @Test
    void loginTest() {
        try {
            driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx?from=myhome_baidu");
            Thread.sleep(30000);

            //人工扫描登录后，获取cookies
            Set<Cookie> cookies = driver.manage().getCookies();

            //存储cookies
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.writeValue(new File("cookies.yaml"), cookies);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    void loginWithCookieTest() {
        try {
            driver.get("https://work.weixin.qq.com/wework_admin/loginpage_wx?from=myhome_baidu");
            //读取cookies
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            TypeReference typeReference = new TypeReference<List<HashMap<String, Object>>>() {
            };
            List<HashMap<String, Object>> cookies = (List<HashMap<String, Object>>)
                    mapper.readValue(new File("cookies.yaml"), typeReference);
//            打印cookies
//            System.out.println(cookies);
            cookies.forEach(cookieMap->{
                driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(),cookieMap.get("value").toString()));
            });

            //刷新页面
            driver.navigate().refresh();
            Thread.sleep(30000);

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
