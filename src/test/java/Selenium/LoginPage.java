package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultPage loginWithUserAccount() {
        WebElement username = driver.findElement(By.name("user"));
        WebElement password = driver.findElement(By.name("password"));

        username.clear();
        password.clear();

        username.sendKeys("javatestuser");
        password.sendKeys("1234abcd");

        driver.findElement(By.id("login")).click();

        return new ResultPage(driver);
    }
}
