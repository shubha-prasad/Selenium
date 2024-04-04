package com.shubha.seleniumtesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class FacebookSignUp {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.facebook.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement signUpLink = driver.findElement(By.xpath("//a[text()='Create New Account']"));
        signUpLink.click();


        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        firstNameInput.sendKeys("shubha");

        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        lastNameInput.sendKeys("prasad");

        WebElement emailInput = driver.findElement(By.name("reg_email__"));
        emailInput.sendKeys("shubhatalkad@gmail.com");

        WebElement reenterEmailInput = driver.findElement(By.name("reg_email_confirmation__"));
        reenterEmailInput.sendKeys("shubhatalkad@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("reg_passwd__"));
        passwordInput.sendKeys("Shubha@123");

        WebElement monthDropdown = driver.findElement(By.id("month"));
        monthDropdown.sendKeys("May");

        WebElement dayDropdown = driver.findElement(By.id("day"));
        dayDropdown.sendKeys("15");

        WebElement yearDropdown = driver.findElement(By.id("year"));
        yearDropdown.sendKeys("1990");

        WebElement genderRadioButton = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
        genderRadioButton.click();

        WebElement signUpButton = driver.findElement(By.name("websubmit"));
        signUpButton.click();

    }
}
