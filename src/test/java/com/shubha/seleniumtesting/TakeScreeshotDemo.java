package com.shubha.seleniumtesting;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeScreeshotDemo {

    public WebDriver driver;

    @Test
    public void take() throws InterruptedException, IOException {
        driver=new EdgeDriver();
        driver.get("https://www.facebook.com/login/");

        Thread.sleep(2000);
        TakesScreenshot ts=(TakesScreenshot) driver;

        File sfile= ts.getScreenshotAs(OutputType.FILE);

        File path= new File("C:\\Users\\RAJA SAGARA\\Desktop\\Bridgelabs\\RestAssuredd\\src\\test\\java\\com\\shubha\\seleniumtesting\\facebook-logo-png--impending-10.png");

        FileHandler.copy(sfile,path);
    }
}
