package com.shubha.seleniumtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class A {
    WebDriver driver;
    @Test
    public void forgotPassword() throws InterruptedException {
        driver = new EdgeDriver();
        driver.get("https://www.facebook.com/login/");
        Thread.sleep(2000);
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Forgotten account?")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("identify_email")).sendKeys("shubha1@gmail.com");

        Thread.sleep(2000);
        driver.findElement(By.name("did_submit")).click();
    }
}
