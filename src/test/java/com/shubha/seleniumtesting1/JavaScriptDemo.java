package com.shubha.seleniumtesting1;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptDemo {
    public WebDriver driver;
    @BeforeMethod
    public  void getDriver(){
        driver=new EdgeDriver();
    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-300)");
        Thread.sleep(2000);
    }

    @Test
    public void enter_disabled_text() throws InterruptedException {
        driver.get("file:///C:/Users/RAJA%20SAGARA/Downloads/page1.html");
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t1').value='shubha prasad'");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t2').value=''");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t2').value='vsp'");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t2').type='button'");

    }
//    @AfterMethod
//    public void close(){
//        driver.close();
//    }
}

