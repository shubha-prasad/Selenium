package com.shubha.seleniumtesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyBoard {
    public WebDriver driver;

    @Test
    public void keyBoardOperations() throws AWTException, InterruptedException {
        driver=new EdgeDriver();
        driver.get("https://www.facebook.com/login/");

        driver.manage().window().maximize();

        Robot robot=new Robot();

        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_A);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_A);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_C);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
    }
}