package Tests;


import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Driver {

    WebDriver driver;


    @BeforeClass
    public void setUp(ITestContext testContext)
    {
        System.setProperty("webdriver.chrome.driver", "/Users/chitra/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().deleteAllCookies();
        testContext.setAttribute("webdriver",this.driver);


    }



    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
