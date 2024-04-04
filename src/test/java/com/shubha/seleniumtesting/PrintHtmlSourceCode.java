package com.shubha.seleniumtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintHtmlSourceCode {
    public static void main(String [] args){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        String htmlcode = driver.getPageSource();
        System.out.println(htmlcode);
        driver.close();
    }
}
