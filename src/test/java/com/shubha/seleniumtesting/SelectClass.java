package com.shubha.seleniumtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectClass {
    public WebDriver driver;
    public WebElement element;

    @Test
    public void selectclassoperation(){
        driver = new EdgeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();


        WebElement departmentDropdown = driver.findElement(By.id("searchDropdownBox"));


        Select select = new Select(departmentDropdown);
        select.selectByVisibleText("Amazon Devices");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        select.selectByIndex(1); // Selects "Appliances"


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        select.selectByValue("search-alias=automotive"); // Selects "Automotive"


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("Selected option: " + selectedOption.getText());


        driver.quit();
    }
}
