package com.shubha.seleniumtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium {
    public WebDriver driver;

    @Test
    public void login() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        String source = driver.getPageSource();

        System.out.println(title);
        System.out.println(url);
        System.out.println(source);

        driver.quit();

    }
}



