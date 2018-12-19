package Selenium;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrelloTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_v70-72.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://trello.com/login/");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void a_testUserLogin() throws IOException {

        LoginPage login = new LoginPage(driver);
        ResultPage result = login.loginWithUserAccount();

        String URL = result.getDriver().getCurrentUrl();
        assertEquals(URL, "https://trello.com/login/");
    }

    @Test
    public void b_testCreateNewBoard() {

        LoginPage login = new LoginPage(driver);
        login.loginWithUserAccount();

        NewBoardPage board = new NewBoardPage(driver);
        ResultPage result = board.createNewBoard();

        String URL = result.getDriver().getCurrentUrl();
        assertEquals(URL, "https://trello.com/javatestuser/boards");
    }

    @Test
    public void c_testDeleteBoard() {

        LoginPage login = new LoginPage(driver);
        login.loginWithUserAccount();

        DeleteBoardPage board = new DeleteBoardPage(driver);
        ResultPage result = board.deleteBoard();

        String text = result.getDriver().findElement(By.cssSelector("#content > div > div > p")).getText();
        assertEquals(text, "Можливо ця дошка приватна. Той, хто дав вам це посилання, має запросити вас до своєї дошки або команди.");
    }
}