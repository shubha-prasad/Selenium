package com.shubha.seleniumtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class UrlCheck {
    @Test
    public void url() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.actitime.com");
        String url = driver.getCurrentUrl();
        if (url.contains("login")) {
            System.out.println("pass :current url contains 'login' string");
        } else {
            System.out.println("Fail");
        }
        driver.close();
    }

}
