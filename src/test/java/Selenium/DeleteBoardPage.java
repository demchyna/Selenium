package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteBoardPage {

    private WebDriver driver;

    public DeleteBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultPage deleteBoard() {
        driver.findElement(By.linkText("IF-090.Java")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div[2]/div/ul[1]/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div[2]/div/ul[3]/li/a")).click();
        driver.findElement(By.cssSelector("#classic > div.pop-over.is-shown > div > div:nth-child(2) > div > div > div > input")).click();
        driver.findElement(By.linkText("Видалення дошки назавжди…")).click();
        driver.findElement(By.cssSelector("#classic > div.pop-over.is-shown > div > div:nth-child(2) > div > div > div > input")).click();

        return new ResultPage(driver);
    }
}