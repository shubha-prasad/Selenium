package com.shubha.seleniumtesting;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyUrlNavigation {

    WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }

    @Test
    public void url(){

        driver.get("https://www.seleniumhq.org/");
        String url = driver.getCurrentUrl();
        if(url.equals("https://www.selenium.dev/")){
            System.out.println("url is successfully navigating and pass");
        }
        else{
            System.out.println("url is successfully navigating and fail");
        }
        driver.quit();
    }
}
