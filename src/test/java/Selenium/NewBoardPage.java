package Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewBoardPage {

    private WebDriver driver;

    public NewBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultPage createNewBoard() {
        driver.findElement(By.className("mod-add")).click();

        WebElement boardTitle = driver.findElement(By.className("subtle-input"));
        boardTitle.sendKeys("IF-090.Java");

        driver.findElement(By.xpath("//*[@id=\"classic\"]/div[4]/div/div/div/form/button")).click();

        return new ResultPage(driver);
    }
}
