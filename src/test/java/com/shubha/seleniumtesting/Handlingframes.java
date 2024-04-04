package com.shubha.seleniumtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Handlingframes {
    public WebDriver driver;

    @Test
    public void frameoperations(){
        driver = new EdgeDriver();
        driver.get("https://www.amazon.com/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Switch to the iframe containing the Amazon banner
        driver.switchTo().frame("ape_Detail_hero-quick-promo_desktop_iframe");

        // Perform actions inside the iframe
        WebElement bannerText = driver.findElement(By.xpath("//h1[@class='a-size-extra-large']"));
        System.out.println("Banner Text: " + bannerText.getText());

        // Switch back to the main content
        driver.switchTo().defaultContent();

        // Perform actions outside the iframe
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Laptop");

        // Close the browser
        driver.quit();

    }
}
