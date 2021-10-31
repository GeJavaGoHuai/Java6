package com.gehuai;

import org.junit.jupiter.api.Test;

/**
 * @author huaige
 * @Description
 * @date 2021-10-31 20:09
 */
public class BrowserTest extends BaseTest {

    @Test
    void browserTest() {
        driver.get("https://home.testing-studio.com");
    }
}
