package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BasePage
{


    WebDriver driver;


    public BasePage(WebDriver driver)
{
        this.driver=driver;
        PageFactory.initElements(driver,this);
}
    public void waitForPageToLoad(By locateBy)
    {
        WebDriverWait wait= new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(locateBy));
    }



}
