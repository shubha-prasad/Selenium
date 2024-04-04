package com.shubha.seleniumtesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Login {
    public WebDriver driver;

    @Test
    public void login() throws InterruptedException {
        driver = new EdgeDriver();
        driver.get("https://www.facebook.com/login/");
        Thread.sleep(2000);
        driver.manage().window().maximize();

        driver.findElement(By.id("email")).sendKeys("shubha1@gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.id("pass")).sendKeys("Shubha231!");
        Thread.sleep(2000);

        driver.findElement(By.id("loginbutton")).click();
    }

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

    @Test
    public void signUp() throws InterruptedException {
        driver = new EdgeDriver();
        driver.get("https://www.facebook.com/login/");

        Thread.sleep(2000);
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Sign up for Facebook")).click();

        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("Shubha");

        Thread.sleep(2000);
        driver.findElement(By.name("lastname")).sendKeys("Prasad");

        Thread.sleep(2000);
        driver.findElement(By.name("reg_email__")).sendKeys("shubha1@gmail.com");

        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("shubha1@gmail.com");

        Thread.sleep(2000);
        driver.findElement(By.id("password_step_input")).sendKeys("Shubha23@");

        Thread.sleep(2000);
        driver.findElement(By.name("birthday_day")).sendKeys("13");

        Thread.sleep(2000);
        driver.findElement(By.name("birthday_month")).sendKeys("Aug");

        Thread.sleep(2000);
        driver.findElement(By.name("birthday_year")).sendKeys("2001");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='sex' and @value='1']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();

        Thread.sleep(2000);
        driver.findElement(By.name("websubmit")).click();
    }

    @Test
    public void alreadyHaveAnAccount() throws InterruptedException {
        driver = new EdgeDriver();
        driver.get("https://www.facebook.com/login/");

        Thread.sleep(2000);
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Sign up for Facebook")).click();

        driver.findElement(By.linkText("Already have an account?")).click();
    }

    @Test
    public void sourceCode() throws InterruptedException {
        driver = new EdgeDriver();
        driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");

        Thread.sleep(2000);
        driver.manage().window().maximize();

        String source= driver.getPageSource();
        System.out.println(source);
    }
}
