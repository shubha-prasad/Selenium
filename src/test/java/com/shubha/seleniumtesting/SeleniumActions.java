package com.shubha.seleniumtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumActions {
    public WebDriver driver;
    public WebElement webElement;

    @Test
    public void actions() throws NoSuchElementException
    {
        WebDriver driver = new EdgeDriver();


        driver.get("https://jqueryui.com/droppable");

        driver.manage().window().maximize();

        driver.switchTo().frame(0);


        WebElement draggableElement = driver.findElement(By.id("draggable"));
        Actions actions = new Actions(driver);
        actions.moveToElement(draggableElement).perform();


        WebElement draggable =driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggable, droppable).perform();


        driver.switchTo().defaultContent();


        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");


        driver.manage().window().maximize();


        driver.switchTo().frame("iframeResult");


        WebElement doubleClickElement = driver.findElement(By.xpath("//p[@id='demo']"));
        actions.doubleClick(doubleClickElement).perform();


        driver.quit();
    }
}

